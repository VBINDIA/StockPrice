package com.StockPricesApp.demo.config;

import java.io.IOException;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.StockPricesApp.demo.entity.Stock;
import com.StockPricesApp.demo.repo.StockRepository;
import com.StockPricesApp.demo.services.StockServices;
@Configuration
@EnableScheduling
public class ServerWebSocketHandler extends TextWebSocketHandler {
	Set<WebSocketSession> sessions=new  HashSet<WebSocketSession>();
	@Autowired
	StockServices stockServices;
	@Autowired
	StockRepository stockRepository;
	Random random= new Random();
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		 sessions.add(session);
		 String broadcast="";
		 for(Stock stock:stockServices.getAllStock()){
         	broadcast=broadcast+stock.getMarketPlace()+":"+stock.getPrice()+";";
         	};
         session.sendMessage(new TextMessage(broadcast));
	}
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	    //String request = message.getPayload();	   
	    //System.out.println(request);	    	        
	   // String response = String.format("response from server to '%s'", HtmlUtils.htmlEscape(request));	   
	   // session.sendMessage(new TextMessage(response));
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessions.remove(session);
	}
	@Scheduled(fixedRate = 5000)
	void sendPeriodicMessages() throws IOException {
		 System.out.println(LocalTime.now());
	    for (WebSocketSession session : sessions) {
	        if (session.isOpen()) {
	            String broadcast = "";
	           // logger.info("Server sends: {}", broadcast);
	            for(Stock stock:stockServices.getAllStock()){
	            	broadcast=broadcast+stock.getMarketPlace()+":"+stock.getPrice()+";";
	            	};
	            session.sendMessage(new TextMessage(broadcast));
	        }
	    }
	}
	@Scheduled(fixedRate = 3000)
	void updateZensar(){
		int i=random.nextInt(400 - 200) + 200;
		stockRepository.save(new Stock(1L,"Zensar","Zensar",i));
	}
	@Scheduled(fixedRate = 3000)
	void updateApple(){
		int i=random.nextInt(5000 - 2000) + 2000;
		stockRepository.save(new Stock(2L,"Apple","Apple",i));
	}
	@Scheduled(fixedRate = 3000)
	void updateIBM(){
		int i=random.nextInt(500 - 400) + 400;
		stockRepository.save(new Stock(3L,"IBM","IBM",i));
	}
	@Scheduled(fixedRate = 3000)
	void updateInfosys(){
		int i=random.nextInt(1000 - 800) + 800;
		stockRepository.save(new Stock(4L,"Infosys","Infosys",i));
	}
	@Scheduled(fixedRate = 3000)
	void updateReliance(){
		int i=random.nextInt(100 - 20) + 20;
		stockRepository.save(new Stock(5L,"Reliance","Reliance",i));
	}
	
	
	
	
	
}

package com.StockPricesApp.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StockPricesApp.demo.entity.Stock;
import com.StockPricesApp.demo.repo.StockRepository;
@Service
public class StockServiceImplemet implements StockServices {
@Autowired
StockRepository stockRepository;
	@Override
	public List<Stock> getAllStock() {
		
		
		return stockRepository.findAll();
	}

	@Override
	public Stock getStockById(int stockId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock createNewStock(Stock stock, String authToken) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.StockPricesApp.demo.services;

import java.util.List;

import com.StockPricesApp.demo.entity.Stock;

public interface StockServices {
	List<Stock> getAllStock(); 
	Stock getStockById(int stockId);
Stock createNewStock(Stock stock,String authToken);
}

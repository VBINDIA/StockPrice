package com.StockPricesApp.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StockPricesApp.demo.entity.*;

public interface StockRepository extends JpaRepository<Stock, Long> {


}

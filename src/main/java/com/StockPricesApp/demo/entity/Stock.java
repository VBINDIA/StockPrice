package com.StockPricesApp.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="stock")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString    
public class Stock {
	@Id
	private Long id;
	
	private String name;
	String marketPlace;
	double price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMarketPlace() {
		return marketPlace;
	}
	public void setMarketPlace(String marketPlace) {
		this.marketPlace = marketPlace;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}

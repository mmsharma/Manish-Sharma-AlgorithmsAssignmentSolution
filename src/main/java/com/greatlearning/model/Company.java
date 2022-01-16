package com.greatlearning.model;

public class Company {
	
	private double stockPrice;
	private boolean stockRisen;
	public double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	public boolean isStockRisen() {
		return stockRisen;
	}
	public void setStockRisen(boolean stockRisen) {
		this.stockRisen = stockRisen;
	}
}

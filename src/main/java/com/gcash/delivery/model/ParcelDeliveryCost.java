package com.gcash.delivery.model;

import com.gcash.delivery.voucher.model.Discount;

public class ParcelDeliveryCost {
	
	private float cost;
	private Discount discount;
	private Rate rate;
	
	public ParcelDeliveryCost(float cost,Discount discount,Rate rate) {
		this.cost = cost;
		this.discount = discount;
		this.rate = rate;
	}
	
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	
	public Rate getRate() {
		return rate;
	}
	public void setRate(Rate rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		
		return "{ "
				+ " cost: " + cost
				+ " Discount: " + discount 
				+ " Rate: " + rate
				+ " }";
	}
	

}

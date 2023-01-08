package com.gcash.delivery.voucher.model;


public class Discount {
	
	private String code;
	private float discount;
	private String expiry;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	
	@Override
	public String toString() {
		
		return "{ "
				+ " code:" + code
				+ " discount:" + discount
				+ " expiry:" + expiry
				+ " }";
	}

}

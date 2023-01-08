package com.gcash.delivery.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Rates")
public class Rate {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="type")
	private String type;
	@Column(name="rate")
	private float rate;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "{ "
				+ " id: " + id
				+ " type: " + type
				+ " rate: " + rate
				+ " }";
	}

}

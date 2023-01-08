package com.gcash.delivery.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gcash.delivery.model.ParcelDeliveryCost;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryCostResponseDto {
	
	private ParcelDeliveryCost cost;
	private ErrorDto error;

	public ParcelDeliveryCost getCost() {
		return cost;
	}
	public void setCost(ParcelDeliveryCost cost) {
		this.cost = cost;
	}
	public ErrorDto getError() {
		return error;
	}
	public void setError(ErrorDto error) {
		this.error = error;
	}

}

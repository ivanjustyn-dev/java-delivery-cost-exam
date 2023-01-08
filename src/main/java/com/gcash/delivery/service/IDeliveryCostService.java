package com.gcash.delivery.service;

import org.springframework.stereotype.Service;

import com.gcash.delivery.model.Parcel;
import com.gcash.delivery.model.ParcelDeliveryCost;

@Service
public interface IDeliveryCostService {
	
	public ParcelDeliveryCost computeCost(Parcel parcel, String voucher) throws Exception;

}

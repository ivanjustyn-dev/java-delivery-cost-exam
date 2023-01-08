package com.gcash.delivery.factory;

import org.springframework.stereotype.Component;

import com.gcash.delivery.model.Parcel;
import com.gcash.delivery.model.Rate;

@Component
public interface IParcelRateFactory {
	
	public Rate getRate(Parcel parcel);

}

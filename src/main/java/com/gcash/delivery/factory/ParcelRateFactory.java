package com.gcash.delivery.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.gcash.delivery.model.Parcel;
import com.gcash.delivery.model.Rate;
import com.gcash.delivery.repository.RateRepository;

@Component
@Primary
public class ParcelRateFactory implements IParcelRateFactory{
	
	@Autowired
	RateRepository rateRepository;
	
	public float computeVolume(Parcel parcel) {
		return parcel.getHeight() * parcel.getWidth() * parcel.getLength();
	}

	@Override
	public Rate getRate(Parcel parcel) {
		if( parcel.getWeight() > 10) return rateRepository.findByType("HP"); 
		
		float parcelVolume = computeVolume(parcel);
		if( parcelVolume > 2500) return rateRepository.findByType("LP"); 
		if( parcelVolume > 1500) return rateRepository.findByType("MP"); 
		return rateRepository.findByType("SP"); 
	}

}

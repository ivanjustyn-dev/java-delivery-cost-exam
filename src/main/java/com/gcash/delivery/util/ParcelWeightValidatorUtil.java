package com.gcash.delivery.util;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.gcash.delivery.model.Parcel;

@Component
@Primary
public class ParcelWeightValidatorUtil implements IParcelValidatorUtil{

	@Override
	public boolean isParcelValid(Parcel parcel) {
		return parcel.getWeight() <= 50;
	}
	
	

}

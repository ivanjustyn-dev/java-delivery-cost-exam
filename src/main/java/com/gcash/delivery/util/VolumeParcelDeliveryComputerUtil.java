package com.gcash.delivery.util;

import org.springframework.stereotype.Service;

import com.gcash.delivery.model.Parcel;
import com.gcash.delivery.model.Rate;
import com.gcash.delivery.voucher.model.Discount;

@Service
public class VolumeParcelDeliveryComputerUtil extends AbstractDiscountedParcelDeliveryCostComputerUtil{

	
	
	private float computeParcelVolume(Parcel parcel) {
		return parcel.getHeight() * parcel.getWidth() * parcel.getLength();
	}
	@Override
	public float computeCost(Parcel parcel, Rate rate, Discount discount) {
		float total = computeParcelVolume(parcel) * rate.getRate();
		return total - getDiscount(total, discount);
	}

}

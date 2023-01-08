package com.gcash.delivery.util;

import org.springframework.stereotype.Service;

import com.gcash.delivery.model.Parcel;
import com.gcash.delivery.model.Rate;
import com.gcash.delivery.voucher.model.Discount;

@Service
public interface IParcelDeliveryCostComputerUtil {
	public float computeCost(Parcel parcel, Rate rate, Discount discount);
}

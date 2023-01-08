package com.gcash.delivery.util;

import com.gcash.delivery.model.Parcel;
import com.gcash.delivery.model.Rate;
import com.gcash.delivery.voucher.model.Discount;

public abstract class AbstractDiscountedParcelDeliveryCostComputerUtil implements IParcelDeliveryCostComputerUtil{

	public float getDiscount(float total, Discount discount) {
		if (discount == null) return 0;
		return total * discount.getDiscount() / 100;
	}
	
}

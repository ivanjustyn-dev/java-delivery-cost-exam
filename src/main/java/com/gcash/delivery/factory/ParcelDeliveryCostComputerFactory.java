package com.gcash.delivery.factory;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.gcash.delivery.model.Parcel;
import com.gcash.delivery.model.ParcelDeliveryCost;
import com.gcash.delivery.model.Rate;
import com.gcash.delivery.util.IParcelDeliveryCostComputerUtil;
import com.gcash.delivery.util.VolumeParcelDeliveryComputerUtil;
import com.gcash.delivery.util.WeightParcelDeliveryCostComputerUtil;
import com.gcash.delivery.voucher.model.Discount;

@Component
@Primary
public class ParcelDeliveryCostComputerFactory implements IParcelDeliveryCostComputerFactory{

	@Override
	public IParcelDeliveryCostComputerUtil getParcelDeliveryCostComputerUtil(Parcel parcel) {
		if(parcel.getWeight() > 10) return new WeightParcelDeliveryCostComputerUtil();
		return new VolumeParcelDeliveryComputerUtil();
	}
	
	
}

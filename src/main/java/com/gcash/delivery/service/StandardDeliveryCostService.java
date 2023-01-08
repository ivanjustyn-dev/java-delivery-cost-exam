package com.gcash.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.gcash.delivery.factory.IParcelDeliveryCostComputerFactory;
import com.gcash.delivery.factory.IParcelRateFactory;
import com.gcash.delivery.model.Parcel;
import com.gcash.delivery.model.ParcelDeliveryCost;
import com.gcash.delivery.model.Rate;
import com.gcash.delivery.util.IParcelDeliveryCostComputerUtil;
import com.gcash.delivery.voucher.model.Discount;
import com.gcash.delivery.voucher.service.IVoucherService;

@Service
@Primary
public class StandardDeliveryCostService implements IDeliveryCostService{
	
	@Autowired
	IVoucherService voucherService;
	
	@Autowired
	IParcelRateFactory parcelRateFactory;
	
	@Autowired
	IParcelDeliveryCostComputerFactory costComputerFactory;


	@Override
	public ParcelDeliveryCost computeCost(Parcel parcel, String voucher) throws Exception{
		IParcelDeliveryCostComputerUtil costComputer = this.costComputerFactory.getParcelDeliveryCostComputerUtil(parcel);
		Rate rate = parcelRateFactory.getRate(parcel);
		Discount discount = voucher == null ? null : voucherService.getDiscount(voucher);
		float cost = costComputer.computeCost(parcel, rate, discount);
		
		return new ParcelDeliveryCost(
				cost,
				discount,
				rate);
	}

}

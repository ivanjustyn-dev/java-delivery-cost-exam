package com.gcash.delivery.factory;

import org.springframework.stereotype.Component;

import com.gcash.delivery.model.Parcel;
import com.gcash.delivery.model.ParcelDeliveryCost;
import com.gcash.delivery.model.Rate;
import com.gcash.delivery.util.IParcelDeliveryCostComputerUtil;
import com.gcash.delivery.voucher.model.Discount;

@Component
public interface IParcelDeliveryCostComputerFactory {

	public IParcelDeliveryCostComputerUtil getParcelDeliveryCostComputerUtil(Parcel parcel);
}

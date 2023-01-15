package com.gcash.delivery.factory;

import org.springframework.stereotype.Component;

import com.gcash.delivery.model.Parcel;
import com.gcash.delivery.util.IParcelDeliveryCostComputerUtil;

@Component
public interface IParcelDeliveryCostComputerFactory {

	public IParcelDeliveryCostComputerUtil getParcelDeliveryCostComputerUtil(Parcel parcel);
}

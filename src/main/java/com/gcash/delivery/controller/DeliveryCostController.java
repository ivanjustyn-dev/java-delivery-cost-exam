package com.gcash.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcash.delivery.dto.DeliveryCostResponseDto;
import com.gcash.delivery.dto.ErrorDto;
import com.gcash.delivery.model.Parcel;
import com.gcash.delivery.model.ParcelDeliveryCost;
import com.gcash.delivery.service.IDeliveryCostService;
import com.gcash.delivery.util.IParcelValidatorUtil;

@RestController
@RequestMapping("/delivery-service")
public class DeliveryCostController {
	
	@Autowired
	IDeliveryCostService service;
	
	@Autowired
	IParcelValidatorUtil parcelValidator;
	
	@GetMapping("/parcel-delivery-cost")
	public ResponseEntity<DeliveryCostResponseDto> parcelDeliveryCost(
			@RequestBody Parcel parcel,
			@RequestParam(name = "voucher",required = false) String voucher
			) {
		DeliveryCostResponseDto response = new DeliveryCostResponseDto();
		try {
			if(!parcelValidator.isParcelValid(parcel)) {
				throw new Exception("Parcel is invalid");
			}
			ParcelDeliveryCost cost = service.computeCost(parcel, voucher);
			response.setCost(cost);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch(Exception e) {
			ErrorDto error = new ErrorDto();
			error.setMessage(e.getMessage());
			response.setError(error);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

}

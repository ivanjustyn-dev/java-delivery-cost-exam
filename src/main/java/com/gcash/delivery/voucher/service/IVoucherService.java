package com.gcash.delivery.voucher.service;

import org.springframework.stereotype.Service;

import com.gcash.delivery.voucher.exception.VoucherException;
import com.gcash.delivery.voucher.model.Discount;

@Service
public interface IVoucherService {
	
	public Discount getDiscount(String voucherCode) throws VoucherException; 

}

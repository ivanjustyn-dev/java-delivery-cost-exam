package com.gcash.delivery.voucher.exception;

public class VoucherException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public VoucherException(String voucher) {
		super("Voucher code: '"+voucher+"' invalid");
	}

}

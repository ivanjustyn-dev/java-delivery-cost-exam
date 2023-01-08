package com.gcash.delivery.voucher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gcash.delivery.voucher.exception.VoucherException;
import com.gcash.delivery.voucher.model.Discount;

@Service
@Qualifier("MyntVoucherService")
public class MyntVouncherService implements IVoucherService{
	
//	VoucherRequestDto requestDto;
//	VoucherResponstDto responseDto;
	
	
	private final String voucherUrl;
	private final String apiKey;
	
	private final RestTemplate restTemplate;
	
	public MyntVouncherService(
			@Value("${mynt.voucherUrl}") String voucherUrl,
			@Value("${mynt.apiKey}") String apiKey,
			@Autowired RestTemplate restTemplate
			) {
		this.voucherUrl = voucherUrl;
		this.apiKey = apiKey;
		this.restTemplate = restTemplate;
	}
	
	private String buildRequestUrl(String voucherCode) {
		return voucherUrl + voucherCode + "?key=" + apiKey;
	}

	@Override
	public Discount getDiscount(String voucherCode) throws VoucherException{
		try {
		String requestUrl = buildRequestUrl(voucherCode);
		ResponseEntity<Discount> discountResponse = restTemplate.exchange(
				requestUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Discount>() {}
				);
		return discountResponse.getBody();
		} catch(Exception e) {
			throw new VoucherException(voucherCode);
		}
	}

}

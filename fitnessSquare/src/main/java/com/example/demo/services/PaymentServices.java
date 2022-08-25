package com.example.demo.services;

import java.util.List;


import com.example.demo.payloads.PaymentDto;

public interface PaymentServices {
	
	
	// create payment
	PaymentDto create(PaymentDto paymentDto, Integer memberId);
	
	// list of payment
	List<PaymentDto> getAllPayment();
	

}

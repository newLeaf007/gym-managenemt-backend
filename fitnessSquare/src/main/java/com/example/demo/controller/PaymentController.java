package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payloads.PaymentDto;
import com.example.demo.services.PaymentServices;

@RestController
@RequestMapping("/")
public class PaymentController {
	
	@Autowired
	private PaymentServices paymentServices;
	
	@CrossOrigin(origins ="http://localhost:3000")
	@PostMapping("/payment/member/{memberId}")
	public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto paymentDto,@PathVariable("memberId") Integer memberId){
		PaymentDto paymentDto2 = this.paymentServices.create(paymentDto, memberId);
		return new ResponseEntity<PaymentDto>(paymentDto2,HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins ="http://localhost:3000")	
	@GetMapping("/payment")
	public ResponseEntity<List<PaymentDto>> getAllPayment(){
		List<PaymentDto> list = this.paymentServices.getAllPayment();
		return new ResponseEntity<List<PaymentDto>>(list,HttpStatus.OK);
	}

}

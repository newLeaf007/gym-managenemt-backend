package com.example.demo.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Member;
import com.example.demo.entities.Payment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.payloads.PaymentDto;
import com.example.demo.repositories.MemberRepo;
import com.example.demo.repositories.PaymentRepo;

@Service
public class PaymentServicesImpl implements PaymentServices {
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	@Autowired
	private MemberRepo memberRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PaymentDto create(PaymentDto paymentDto,Integer memberId) {
		Member member = this.memberRepo.findById(memberId).orElseThrow(()->new ResourceNotFoundException("Member","MemberId",String.valueOf(memberId)));
		
		Payment payment = this.modelMapper.map(paymentDto, Payment.class);
		payment.setMember(member);
		payment.setAddedOn(new Date());
		Payment created = this.paymentRepo.save(payment);
		return this.modelMapper.map(created, PaymentDto.class);
		
	}

	@Override
	public List<PaymentDto> getAllPayment() {
		List<Payment> list = this.paymentRepo.findAll();
		List<PaymentDto> listDto = list.stream().map((payment)->this.modelMapper.map(payment, PaymentDto.class)).collect(Collectors.toList());
		return listDto;
	}
}

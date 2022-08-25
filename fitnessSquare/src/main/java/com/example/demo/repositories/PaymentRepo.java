package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Member;
import com.example.demo.entities.Payment;

public interface PaymentRepo  extends JpaRepository<Payment, Integer>{
	
	//getPaymentbyuser
	List<Payment> findByMember(Member member);
	
}

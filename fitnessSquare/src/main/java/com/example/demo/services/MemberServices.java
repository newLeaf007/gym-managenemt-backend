package com.example.demo.services;

import java.util.List;
import java.util.Map;

import com.example.demo.payloads.Dashboard;
import com.example.demo.payloads.MemberDto;
import com.example.demo.payloads.MemberWithTotalAmount;
import com.example.demo.payloads.MonthWithTotalAoumnt;
import com.example.demo.payloads.PaymentWithUser;
import com.example.demo.payloads.SelectMemberWithID;

public interface MemberServices {
	
	
	//create member
	MemberDto create(MemberDto memberDto);
	
	//update member information
	MemberDto update(MemberDto memberDto,Integer memberId);
	
	//get all member
	List<MemberDto> getAllMemeber();
	
	//get list by name
	List<MemberDto> getallbyName(String name);
	
	List<SelectMemberWithID> IdwithMember();
	
	List<PaymentWithUser> getPaymentList();
	
	List<PaymentWithUser> getListForCurrentMonth();
	
	Dashboard getDetails();
	List<MemberWithTotalAmount> getTotalAmount();
	List<MonthWithTotalAoumnt> getTotalAmountMonth();
	

}

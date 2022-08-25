package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payloads.Dashboard;
import com.example.demo.payloads.MemberDto;
import com.example.demo.payloads.MemberWithTotalAmount;
import com.example.demo.payloads.PaymentWithUser;
import com.example.demo.payloads.SelectMemberWithID;
import com.example.demo.services.MemberServices;

@RestController
@RequestMapping("/")
public class MemberController {
	
	@Autowired
	private MemberServices memberServices;
	
	@CrossOrigin(origins ="http://localhost:3000")
	@PostMapping("/member")
	public ResponseEntity<MemberDto> createMember(@RequestBody MemberDto memberDto){
		MemberDto memberDto2 = this.memberServices.create(memberDto);
		return new ResponseEntity<MemberDto>(memberDto2,HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins ="http://localhost:3000")
	@GetMapping("/member")
	public ResponseEntity<List<MemberDto>> getAllMember(){
		List<MemberDto> list = this.memberServices.getAllMemeber();
		return new ResponseEntity<List<MemberDto>>(list,HttpStatus.OK);
	}
	
	@CrossOrigin(origins ="http://localhost:3000")
	@GetMapping("/member/{name}")
	public ResponseEntity<List<MemberDto>> getAllMemberByName(@PathVariable("name") String name){
		List<MemberDto> list = this.memberServices.getallbyName(name);
		return new ResponseEntity<List<MemberDto>>(list,HttpStatus.OK);
	}
	
	@CrossOrigin(origins ="http://localhost:3000")
	@PutMapping("/member/{memberId}")
	public ResponseEntity<MemberDto> updateMember(@RequestBody MemberDto memberDto,@PathVariable Integer memberId){
		MemberDto memberDto2 = this.memberServices.update(memberDto, memberId);
		return new ResponseEntity<MemberDto>(memberDto2,HttpStatus.OK);
	}

	@CrossOrigin(origins ="http://localhost:3000")
	@GetMapping("/member/memberWithIds")
	public ResponseEntity<List<SelectMemberWithID>> getNameWithId(){
		List<SelectMemberWithID> map = this.memberServices.IdwithMember();
		return new ResponseEntity<List<SelectMemberWithID>>(map,HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("/member/payment/all")
	public ResponseEntity<List<PaymentWithUser>> getPaymentUser(){
		List<PaymentWithUser> list = this.memberServices.getPaymentList();
		return new ResponseEntity<List<PaymentWithUser>>(list,HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("/dashboard")
	public ResponseEntity<Dashboard> getDashbard(){
		Dashboard dashboard = this.memberServices.getDetails();
		return new ResponseEntity<Dashboard>(dashboard,HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("/memberwithamount")
	public ResponseEntity<List<MemberWithTotalAmount>> getMemberDetailAmount(){
		List<MemberWithTotalAmount>  list = this.memberServices.getTotalAmount();
		return new ResponseEntity<List<MemberWithTotalAmount>>(list,HttpStatus.OK);
	}
}

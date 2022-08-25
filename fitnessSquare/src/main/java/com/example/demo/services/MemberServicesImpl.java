package com.example.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Member;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.payloads.Dashboard;
import com.example.demo.payloads.MemberDto;
import com.example.demo.payloads.MemberWithTotalAmount;
import com.example.demo.payloads.MonthWithTotalAoumnt;
import com.example.demo.payloads.PaymentWithUser;
import com.example.demo.payloads.SelectMemberWithID;
import com.example.demo.repositories.MemberRepo;
import com.example.demo.repositories.PaymentRepo;

@Service
public class MemberServicesImpl implements MemberServices {
	
	@Autowired
	private MemberRepo memberRepo;
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public MemberDto create(MemberDto memberDto) {
		Member member = this.modelMapper.map(memberDto, Member.class);
		member.setAddedOn(new Date());
		Member saveMember = this.memberRepo.save(member);
		return this.modelMapper.map(saveMember, MemberDto.class);
	}

	@Override
	public MemberDto update(MemberDto memberDto, Integer memberId) {
		Member member = this.memberRepo.findById(memberId).orElseThrow(()-> new ResourceNotFoundException("Member","memberId",String.valueOf(memberId)));
	
		member.setName(memberDto.getName()==null?member.getName():memberDto.getName());
		member.setActive(memberDto.getActive()==null?member.getActive():memberDto.getActive());
		member.setAddedOn(memberDto.getAddedOn()==null?member.getAddedOn():memberDto.getAddedOn());
		member.setId(member.getId());
		member.setPhone(memberDto.getPhone()==null?member.getPhone():memberDto.getPhone());
		member.setTiming(memberDto.getTiming()==null?member.getTiming():memberDto.getTiming());
		
		Member updated = this.memberRepo.save(member);
		
		return this.modelMapper.map(updated, MemberDto.class);
	}

	@Override
	public List<MemberDto> getAllMemeber() {
		List<Member> list = this.memberRepo.findAll();
		List<MemberDto> listDto = list.stream().map((member)->this.modelMapper.map(member, MemberDto.class)).collect(Collectors.toList());
		return listDto;
	}

	@Override
	public List<MemberDto> getallbyName(String name) {
		List<Member> list = this.memberRepo.findByName(name);
		List<MemberDto> listDto = list.stream().map((member)->this.modelMapper.map(member, MemberDto.class)).collect(Collectors.toList());
		return listDto;
	}

	@Override
	public List<SelectMemberWithID> IdwithMember() {
		
		List<Member> list = this.memberRepo.findAll();
		List<SelectMemberWithID> listOptions = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			SelectMemberWithID current = new SelectMemberWithID();
			current.setValue(list.get(i).getId());
			current.setLabel(list.get(i).getName());
			listOptions.add(current);
		}
		
		return listOptions;
		
		
	}

	@Override
	public List<PaymentWithUser> getPaymentList() {
		List<Member> list = this.memberRepo.findAll();
		List<PaymentWithUser> listPayment = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			String username = list.get(i).getName();
			for(int j=0;j<list.get(i).getPayment().size();j++) {
				PaymentWithUser current = new PaymentWithUser();
				current.setName(username);
				current.setAmount(list.get(i).getPayment().get(j).getAmount());
				current.setMonth(list.get(i).getPayment().get(j).getMonth());
				current.setType(list.get(i).getPayment().get(j).getType());
				current.setYear(list.get(i).getPayment().get(j).getYear());
				current.setAddedOn(list.get(i).getPayment().get(j).getAddedOn());
				listPayment.add(current);
			}
		}
		return listPayment;
	}

	@Override
	public List<PaymentWithUser> getListForCurrentMonth() {
		List<Member> list = this.memberRepo.findAll();
		List<PaymentWithUser> listPayment = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			String username = list.get(i).getName();
			for(int j=0;j<list.get(i).getPayment().size();j++) {
			 
				PaymentWithUser current = new PaymentWithUser();
				current.setId(list.get(i).getPayment().get(j).getId());
				current.setName(username);
				current.setAmount(list.get(i).getPayment().get(j).getAmount());
				current.setMonth(list.get(i).getPayment().get(j).getMonth());
				current.setType(list.get(i).getPayment().get(j).getType());
				current.setYear(list.get(i).getPayment().get(j).getYear());
				current.setAddedOn(list.get(i).getPayment().get(j).getAddedOn());
				listPayment.add(current);
			}
		}
		return listPayment;
	}

	@Override
	public Dashboard getDetails() {
		Dashboard dashboard = new Dashboard();
		List<Member> listMember = this.memberRepo.findAll();
		List<PaymentWithUser> listPayment = getDetailsWithPayment();
		dashboard.setTotalMmember(listMember.size());
		int sum=0;
		for(int i=0;i<listPayment.size();i++) {
			sum = sum + (listPayment.get(i).getAmount()==null?0:listPayment.get(i).getAmount());
		}
		dashboard.setTotalPayment(sum);
		int activeCount=0;
		
		dashboard.setActiveTotalMember(activeCount);
		
		return dashboard;
		
	}

	public List<PaymentWithUser> getDetailsWithPayment() {
		List<Member> list = this.memberRepo.findAll();
		List<PaymentWithUser> listPayment = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			String username = list.get(i).getName();
			for(int j=0;j<list.get(i).getPayment().size();j++) {
			 
				PaymentWithUser current = new PaymentWithUser();
				current.setId(list.get(i).getPayment().get(j).getId());
				current.setName(username);
				current.setAmount(list.get(i).getPayment().get(j).getAmount());
				current.setMonth(list.get(i).getPayment().get(j).getMonth());
				current.setType(list.get(i).getPayment().get(j).getType());
				current.setYear(list.get(i).getPayment().get(j).getYear());
				current.setAddedOn(list.get(i).getPayment().get(j).getAddedOn());
				listPayment.add(current);
			}
		}
		return listPayment;
	}

	@Override
	public List<MemberWithTotalAmount> getTotalAmount() {
		List<PaymentWithUser> listPayment = getDetailsWithPayment();
		List<MemberWithTotalAmount> list = new ArrayList<>();
		List<String> username = new ArrayList<>();
		for(int i=0;i<listPayment.size();i++) {
			if(!username.contains(listPayment.get(i).getName()))
			username.add(listPayment.get(i).getName());
		}
		
		for(int i=0;i<username.size();i++) {
			MemberWithTotalAmount current = new MemberWithTotalAmount();
			int sum =0;
			for(int j=0;j<listPayment.size();j++) {
				current.setName(username.get(i));
				
				if(username.get(i).equals(listPayment.get(j).getName())) {
					sum = sum + (listPayment.get(j).getAmount()!=null ? listPayment.get(j).getAmount():0 );
				}
			}
			current.setAmount(sum);
			list.add(current);
			
		}
		return list;
	}

	@Override
	public List<MonthWithTotalAoumnt> getTotalAmountMonth() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.example.demo.payloads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.entities.Payment;

public class MemberDto {
	
	private Integer id;
	private String name;
	private String phone;
	private String address;
	private Boolean active;
	private Date addedOn;
	private String timing;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Date getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}
	public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
	public MemberDto() {
		super();
	}
	
	
	List<PaymentDto> payment = new ArrayList<>();
	public List<PaymentDto> getPayment() {
		return payment;
	}
	public void setPayment(List<PaymentDto> payment) {
		this.payment = payment;
	}
	

}

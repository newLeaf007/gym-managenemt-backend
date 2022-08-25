package com.example.demo.payloads;

import java.util.Date;

import com.example.demo.entities.Member;

public class PaymentDto {
	
	private Integer id;
	private Integer amount;
	private String month;
	private String type;
	private String year;
	//private MemberDto member;
	
	private Date addedOn;
	
	
	public Date getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}


	public PaymentDto() {
		super();
	}
	
	

}

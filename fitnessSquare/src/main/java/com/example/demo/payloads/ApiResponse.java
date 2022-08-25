package com.example.demo.payloads;

public class ApiResponse {
	
	private String message;
	private Boolean success;
	
	
	
	public ApiResponse(String message, Boolean success) {
		super();
		this.message = message;
		this.success = success;
	}
	
	
	public ApiResponse() {
		super();
	}


	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	

}

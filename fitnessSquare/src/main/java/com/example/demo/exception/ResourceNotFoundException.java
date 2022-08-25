package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	private String fieldType;
	private String filedName;
	private String fieldValue;
	public ResourceNotFoundException(String fieldType, String filedName, String fieldValue) {
		super(String.format("%s is not found %s:%s", fieldType,filedName,fieldValue));
		this.fieldType = fieldType;
		this.filedName = filedName;
		this.fieldValue = fieldValue;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getFiledName() {
		return filedName;
	}
	public void setFiledName(String filedName) {
		this.filedName = filedName;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	public ResourceNotFoundException() {
		super();
	}
	
	
	
	

}

package com.cg.onlineeducation.dto;

public class SmsNotification {
	private int studentId;
	private String phoneNo;
	private String message;
	
	public SmsNotification() {
		super();
	}
	
	public SmsNotification(int studentId, String phoneNo, String message) {
		super();
		this.studentId = studentId;
		this.phoneNo = phoneNo;
		this.message = message;
	}

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getMessage() {
		return message;
	}
	public void setMesage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SmsNotification [studentId=" + studentId + ", phoneNo=" + phoneNo + ", mesage=" + message + "]";
	}
	
	
}

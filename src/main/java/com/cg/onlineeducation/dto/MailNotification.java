package com.cg.onlineeducation.dto;

import javax.validation.constraints.Email;

public class MailNotification {
	private int studentId;
	private String emailId;
	private String subjectOfMail;
	private String message;
	public MailNotification() {
		super();
	}
	public MailNotification(int studentId, String emailId, String subjectOfMail, String message) {
		super();
		this.studentId = studentId;
		this.emailId = emailId;
		this.subjectOfMail = subjectOfMail;
		this.message = message;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getSubjectOfMail() {
		return subjectOfMail;
	}
	public void setSubjectOfMail(String subjectOfMail) {
		this.subjectOfMail = subjectOfMail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "MailNotification [studentId=" + studentId + ", emailId=" + emailId + ", subjectOfMail=" + subjectOfMail
				+ ", message=" + message + "]";
	}
	

}

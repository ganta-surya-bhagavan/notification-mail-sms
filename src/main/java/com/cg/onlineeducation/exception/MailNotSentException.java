package com.cg.onlineeducation.exception;

public class MailNotSentException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public MailNotSentException() {
		
	}
	public MailNotSentException(String message) {
		super(message);
	}

}

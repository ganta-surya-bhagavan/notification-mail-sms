package com.cg.onlineeducation.exception;

public class SmsNotSentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SmsNotSentException() {
		
	}
	public SmsNotSentException(String message) {
		super(message);
	}

}

package com.cg.onlineeducation.controller;

import com.cg.onlineeducation.dto.Response;
import com.cg.onlineeducation.exception.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class NotificationExceptionController {
	@ExceptionHandler(MailNotSentException.class)
	public ResponseEntity<Response> handleMailNotSentException(MailNotSentException ex)
	{
		Response response=new Response(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
		
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(SmsNotSentException.class)
	public ResponseEntity<Response> handleSmsNotSentException(SmsNotSentException ex)
	{
		Response response=new Response(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
		
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		
	}
	
}

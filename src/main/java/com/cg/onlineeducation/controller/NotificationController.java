package com.cg.onlineeducation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineeducation.dto.MailNotification;
import com.cg.onlineeducation.dto.SmsNotification;
import com.cg.onlineeducation.service.NotificationService;

@RestController
public class NotificationController {
	@Autowired
	private NotificationService  notificationService;
	
	@PostMapping( value="/sendEmail")
	public boolean sendEmail(@Valid @RequestBody MailNotification  emailNotification)  { 
		return notificationService.sendEmail(emailNotification);
	}
	@PostMapping( value="/sendSms")
	public boolean sendSms( @RequestBody SmsNotification  smsNotification)  {
		 
		return notificationService.sendSms(smsNotification);
	}

}

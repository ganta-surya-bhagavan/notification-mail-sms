package com.cg.onlineeducation.service;

import com.cg.onlineeducation.dto.MailNotification;
import com.cg.onlineeducation.dto.SmsNotification;

public interface NotificationService {
	
	public boolean sendEmail(MailNotification mailNotification);
	public boolean sendSms(SmsNotification smsNotification);

}

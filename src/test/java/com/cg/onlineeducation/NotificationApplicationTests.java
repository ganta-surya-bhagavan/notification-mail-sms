package com.cg.onlineeducation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineeducation.dto.MailNotification;
import com.cg.onlineeducation.dto.SmsNotification;
import com.cg.onlineeducation.exception.MailNotSentException;
import com.cg.onlineeducation.service.NotificationService;

@SpringBootTest
class NotificationApplicationTests {
	@Autowired
	private NotificationService notificationService;
	
	@Test
	void testSendEmail1() {
		MailNotification mailNotification = new MailNotification(123,"120005037@sastra.ac.in","hello","have a good day");
		assertTrue(notificationService.sendEmail(mailNotification));
	}
	
	@Test
	void testSendEmail2() {
		MailNotification mailNotification = new MailNotification(123,"suryabhagavan48048@gmail.com","hello","have a good day");
		assertTrue(notificationService.sendEmail(mailNotification));
	}
	
	@Test
	void testSendSms1() {
		SmsNotification smsNotification = new SmsNotification(123,"+918919702475","have a good day");
		assertTrue(notificationService.sendSms(smsNotification));
	}
	
	@Test
	void testSendSms2() {
		SmsNotification smsNotification = new SmsNotification(123,"+917286047013","have a good day");
		assertTrue(notificationService.sendSms(smsNotification));
	}

}

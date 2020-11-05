package com.cg.onlineeducation.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.client.RestTemplate;

import com.cg.onlineeducation.dto.MailNotification;
import com.cg.onlineeducation.dto.SmsNotification;
import com.cg.onlineeducation.dto.User;
import com.cg.onlineeducation.exception.MailNotSentException;
import com.cg.onlineeducation.exception.SmsNotSentException;
import com.cg.onlineeducation.exception.StudentNotFoundException;
import com.sun.mail.smtp.SMTPAddressFailedException;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class NotificationServiceImpl implements NotificationService {
	private final static String ACCOUNT_SID="ACbdc67c93986d6bf23a3046b9b914c60c";
	private final static String AUTH_ID="02e7f3807670df26bc23f08fe7c52db8";
	static
	{
		Twilio.init(ACCOUNT_SID,AUTH_ID);
	}
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private Configuration configuration;
	@Autowired
	private RestTemplate restTemplate;
	private static final String URI = "";
	@Override
	public boolean sendEmail(MailNotification mailNotification) {
		MimeMessage message = sender.createMimeMessage();
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mailNotification.getEmailId());
		if(restTemplate.getForObject(URI+mailNotification.getStudentId(),User.class)==null) {
			throw new StudentNotFoundException("Student not found");
		}
		if(!matcher.matches()) {
			throw new MailNotSentException("Ennter valid emailId");
		}
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			Template template = configuration.getTemplate("email-template.ftl");
			Map<String,Object> model = new HashMap<>();
			model.put("message",mailNotification.getMessage());
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
			helper.setTo(mailNotification.getEmailId());
			helper.setText(html, true);
			helper.setSubject(mailNotification.getSubjectOfMail());
			helper.setFrom("ntrfanveedu@gmail.com");
			sender.send(message);
			
		}
		catch(SMTPAddressFailedException exception) {
			throw new MailNotSentException(exception.getMessage());
		}
		catch(MailException | MessagingException | IOException | TemplateException   exception  ) {
			throw new MailNotSentException(exception.getMessage());
		} 
		return true;
	}
	@Override
	public boolean sendSms(SmsNotification smsNotification) {
		if(restTemplate.getForObject(URI+smsNotification.getStudentId(),User.class)==null) {
			throw new StudentNotFoundException("Student not found");
		}
		try {
		Message.creator(new PhoneNumber(smsNotification.getPhoneNo()), new PhoneNumber("+12057517211"),smsNotification.getMessage()).create();}
		catch(ApiException apiException) {
			throw new SmsNotSentException(apiException.getMessage());
		}
		return true;
	}

}

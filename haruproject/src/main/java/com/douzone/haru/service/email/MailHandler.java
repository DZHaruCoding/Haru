package com.douzone.haru.service.email;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Configuration
public class MailHandler {
    
	
    private JavaMailSender mailSender;
   
	private MimeMessage message;
  
	private MimeMessageHelper messageHelper;
    
    public MailHandler(JavaMailSender mailSender) throws MessagingException {
        this.mailSender = mailSender;
        message = this.mailSender.createMimeMessage();
        messageHelper = new MimeMessageHelper(message, true, "UTF-8");
    }
    
    public void setSubject(String subject) throws MessagingException {
        messageHelper.setSubject(subject);
    }
    public void setText(String htmlContent) throws MessagingException {
        messageHelper.setText(htmlContent, true);
    }
    public void setFrom(String fromAddress, String name) throws UnsupportedEncodingException, MessagingException {
        messageHelper.setFrom(fromAddress, name);
    }
    public void setTo(String email) throws MessagingException {
        messageHelper.setTo(email);
    }
    public void addInline(String contentId, DataSource dataSource) throws MessagingException {
        messageHelper.addInline(contentId, dataSource);
    }
    public void send(MailHandler sendMail) {
        mailSender.send(message);
    }
    
}
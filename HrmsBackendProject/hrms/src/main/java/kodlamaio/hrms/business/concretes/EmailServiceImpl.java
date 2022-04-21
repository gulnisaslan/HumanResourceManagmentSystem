package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

	
	 @Autowired private JavaMailSender emailSender;
	  
	 SimpleMailMessage message =new SimpleMailMessage();
	 
	 
	  
	 @Override public void sendSimpleMessage(String to, String subject, String text) { 
		 message.setTo(to);
		 message.setSubject(subject);
		 message.setText(text);
		 emailSender.send(message);
	  
	 }
	

}

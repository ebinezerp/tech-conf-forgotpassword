package com.example.demo.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class ForgetPasswordEmail  {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private UserService userService;
	
	
	
	public boolean send(String toEmail,String content,String contextPath) {
		
		User user=userService.getByEmail(toEmail);
		
		try {
		javaMailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage,true);
				messageHelper.setTo(toEmail);
				messageHelper.setText(user.getPassword(), true);
				
				messageHelper.setSubject(" Registration Email");		
			}
			
			
			
		});
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	

}

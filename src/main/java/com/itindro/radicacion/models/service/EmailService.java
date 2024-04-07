package com.itindro.radicacion.models.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;

@Service
public class EmailService {
	
	@Autowired
    private JavaMailSender javaMailSender;
	


    public void sendEmail(String to, String subject, String text, List<MultipartFile> files) {
       
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);

            // Adjuntar archivos
            for (MultipartFile file : files) {
                ByteArrayDataSource dataSource = new ByteArrayDataSource(file.getBytes(), file.getContentType());
                helper.addAttachment(file.getOriginalFilename(), dataSource);
            }

            javaMailSender.send(mimeMessage);
        } catch (MessagingException | IOException e) {
            e.printStackTrace(); // Maneja la excepción según tu necesidad
        }
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//		message.setContent(text,"text/html;charset=UTF-8");
    }

}

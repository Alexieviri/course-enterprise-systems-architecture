package org.myspring.emailSender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailSender {


    private String sendTo = "thanekrios63@gmail.com";

    private final JavaMailSender mailSender;

    @Autowired
    public EmailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(String changeType, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(sendTo);
        message.setFrom("Spring");
        message.setSubject(changeType);
        message.setText(body);
        mailSender.send(message);
    }

    public String getSendTo() {
        return sendTo;
    }
}

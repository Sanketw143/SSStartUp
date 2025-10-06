package org.ssupstart.ems.listners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.ssupstart.ems.dtos.OtpMessage;

@Slf4j
@Component
public class ConsumeOtp {

    @Autowired
    private JavaMailSender mailSender;

    @KafkaListener(topics = "test", containerFactory = "kafkaListenerContainerFactory")
    public void sendOtpEmail(OtpMessage otp) {
        log.info("Consuming msg for mobile no {} and email {} ", otp.getPhone(), otp.getEmail());
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(otp.getEmail());
        msg.setSubject("Your Verification Code");
        msg.setText("Your OTP code is: " + otp + " (valid 5 min)");
        mailSender.send(msg);
    }
}

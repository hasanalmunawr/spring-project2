package hasanalmunawr.Dev.springproject2.service.impl;

import hasanalmunawr.Dev.springproject2.exception.ApiException;
import hasanalmunawr.Dev.springproject2.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static hasanalmunawr.Dev.springproject2.utils.EmailUtils.getEmailMessage;
import static hasanalmunawr.Dev.springproject2.utils.EmailUtils.getResetPasswordMessage;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private static final String NEW_USER_ACCOUNT_VERIFICATION = "New User Account Verification";
    private static final String PASSWORD_RESET_REQUEST = "Reset Password Request";
    private final JavaMailSender sender;

    @Value("${spring.mail.verify.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String formEmail;

    @Async
    @Override
    public void sendNewAccountEmail(String name, String email, String token) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            message.setFrom(formEmail);
            message.setTo(email);
            message.setText(getEmailMessage(name, host, token));
            sender.send(message);
        } catch (Exception e) {
            log.error("[EmailServiceImpl:sendNewAccountEmail] Error : ", e);
            throw new ApiException("Unable to send email");
        }
    }

    @Async
    @Override
    public void sendPasswordResetEmail(String name, String email, String token) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(PASSWORD_RESET_REQUEST);
            message.setFrom(formEmail);
            message.setTo(email);
            message.setText(getResetPasswordMessage(name, host, token));
            sender.send(message);
        } catch (Exception e) {
            log.error("[EmailServiceImpl:sendPasswordResendEmail] Error : ", e);
            throw new ApiException("Unable to send email");
        }
    }
}

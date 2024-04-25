package hasanalmunawr.Dev.springproject2.service;


public interface EmailService {

    void sendNewAccountEmail(String name, String to, String token);
    void sendPasswordResetEmail(String name, String to, String token);
}

package info.kowalczuk.spring.api.service;

public interface EmailService {
    void send(String from, String to, String subject, String message);
}

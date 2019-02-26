package info.kowalczuk.spring.service;

import info.kowalczuk.spring.api.service.EmailService;
import info.kowalczuk.spring.config.AppConfiguration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfiguration.class)
public class EmailServiceTest {

    @Autowired
    private EmailService email;

    private final String EMAIL_FROM = "czaderacc@gmail.com";
    private final String EMAIL_TO = "czader98@gmail.com";
    private final String EMAIL_SUBJECT = "Dodanie nowego dokumentu";
    private final String EMAIL_MESSAGE = "Dodano nowy dokument do kolekcji.";

    @Test//Remember to fill username and password in email.properties
    @Disabled
    public void testEmail() throws InterruptedException {
        assertNotNull(email);
        long start = new Date().getTime();
        email.send(EMAIL_FROM, EMAIL_TO,
                EMAIL_SUBJECT, EMAIL_MESSAGE);
        long end = new Date().getTime();
        long time = (end - start) / 1000;
        System.out.println("Czas synchronicznej: " + time);
    }

    @Test
    @Disabled
    public void testAsyncEmail() throws InterruptedException {
        assertNotNull(email);
        long start = new Date().getTime();
        email.sendAsync(EMAIL_FROM, EMAIL_TO,
                EMAIL_SUBJECT, EMAIL_MESSAGE);
        long end = new Date().getTime();
        long time = (end - start) / 1000;
        System.out.println("Czas asynchronicznej: " + time);
    }
}

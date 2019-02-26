package info.kowalczuk.spring.service;


import info.kowalczuk.spring.api.service.EmailService;
import info.kowalczuk.spring.config.AppConfiguration;
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

    @Test//Remember to fill username and password in email.properties
    public void testEmail() throws InterruptedException {
        assertNotNull(email);
        long start = new Date().getTime();
        email.send("czaderacc@gmail.com", "czader98@gmail.com", "Dodanie nowego dokumentu",
                "Dodano nowy dokument do kolekcji.");
        long end = new Date().getTime();
        long time = (end - start) / 1000;
        System.out.println(time);
    }
}

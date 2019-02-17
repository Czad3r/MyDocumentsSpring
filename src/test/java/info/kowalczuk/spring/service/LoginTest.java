package info.kowalczuk.spring.service;

import info.kowalczuk.spring.api.service.Login;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:ConfigurationXML/loginTest/loginTest.xml"})
@ActiveProfiles("dev")
public class LoginTest {
    private static final String EMAIL = "test@mydocuments.com";
    private static final String PASS = "test";
    @Autowired
    private Login login;

    @Test
    public void testLogin() {
        assertNotNull(login);
        assertTrue(login.isAuthorized(EMAIL, PASS));
    }
}


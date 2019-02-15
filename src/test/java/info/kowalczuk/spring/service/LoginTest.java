package info.kowalczuk.spring.service;

import info.kowalczuk.spring.api.service.Login;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private static final String EMAIL = "test@mydocuments.com";
    private static final String PASS = "test";
    private ClassPathXmlApplicationContext context;
    @BeforeEach
    public void setup(){
        context = new ClassPathXmlApplicationContext("classpath:ConfigurationXML/loginTest/loginTest.xml");
    }
    @Test
    public void testLogin() {
        Login login = context.getBean(Login.class);
        assertNotNull(login);
        assertTrue(login.isAuthorized(EMAIL, PASS));
    }
    @Test
    public void testLogin2() {
        context=new ClassPathXmlApplicationContext("classpath:ConfigurationXML/loginTest/loginTest2.xml");
        Login login = context.getBean(Login.class);
        assertNotNull(login);
        assertFalse(login.isAuthorized(EMAIL,PASS));
    }
}


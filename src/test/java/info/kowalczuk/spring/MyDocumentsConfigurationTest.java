package info.kowalczuk.spring;

import info.kowalczuk.spring.config.AppConfiguration;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyDocumentsConfigurationTest {
    private ApplicationContext context;

    @Before
    public void setup() {
        context = new AnnotationConfigApplicationContext(AppConfiguration.class);
    }

    @Test
    public void testWithBeanConfigurationFindByType() {

    }

    @Test
    public void testWithBeanConfigurationListAll() {

    }
}

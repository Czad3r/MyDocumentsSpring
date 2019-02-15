package info.kowalczuk.spring;

import info.kowalczuk.spring.api.model.Document;
import info.kowalczuk.spring.api.model.Type;
import info.kowalczuk.spring.api.service.SearchEngine;
import info.kowalczuk.spring.config.AppConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyDocumentsConfigurationTest {
    private ApplicationContext context;
    private SearchEngine engine;
    private Type webType;


    @BeforeEach
    public void setup() {
        context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        engine = context.getBean(SearchEngine.class);
        webType = context.getBean(Type.class);

    }

    @Test
    public void testConfigurationTypeNotNull() {
        assertNotNull(webType);
        assertNotNull(context);
        assertNotNull(engine);
    }

    @Test
    public void testConfigurationFindByType() {
        List<Document> documents = engine.findByType(webType);
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(webType.getName(), documents.get(0).getType().getName());
        assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
        assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());
    }

    @Test
    public void testConfigurationListAll() {
        List<Document> documents = engine.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);
    }
}

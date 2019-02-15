package info.kowalczuk.spring;

import info.kowalczuk.spring.api.model.Document;
import info.kowalczuk.spring.api.model.Type;
import info.kowalczuk.spring.api.service.SearchEngine;
import info.kowalczuk.spring.config.AppConfiguration;
import info.kowalczuk.spring.impl.view.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyDocumentsConfigurationTest {

    private ApplicationContext context;
    private SearchEngine engine;
    private Type docType;


    @BeforeEach
    public void setup() {
        context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        engine = context.getBean(SearchEngine.class);
        docType = context.getBean("typeDOC", Type.class);
    }

    @Test
    public void testMenu() {
        Menu menu = context.getBean(Menu.class);
        assertNotNull(menu);
        menu.printMenu("classpath:menu.txt");
    }

    @Test
    public void testConfigurationTypeNotNull() {
        assertNotNull(docType);
        assertNotNull(context);
        assertNotNull(engine);
    }

    @Test
    public void testConfigurationFindByType() {
        List<Document> documents = engine.findByType(docType);
        assertNotNull(documents);
        assertTrue(documents.size() == 2);
        assertEquals(docType.getName(), documents.get(0).getType().getName());
        assertEquals(docType.getDesc(), documents.get(1).getType().getDesc());
        assertEquals(docType.getExtension(), documents.get(0).getType().getExtension());
    }

    @Test
    public void testConfigurationListAll() {
        List<Document> documents = engine.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);
    }
}

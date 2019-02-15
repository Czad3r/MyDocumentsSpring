package info.kowalczuk.spring;

import info.kowalczuk.spring.api.model.Document;
import info.kowalczuk.spring.api.model.Type;
import info.kowalczuk.spring.api.service.SearchEngine;
import info.kowalczuk.spring.config.AppConfiguration;
import info.kowalczuk.spring.impl.view.Menu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfiguration.class})
public class MyDocumentsConfigurationTest {

    @Autowired
    private SearchEngine engine;
    @Qualifier("docType")
    @Autowired
    private Type docType;
    @Autowired
    private Menu menu;

    @Test
    public void testMenu() {
        assertNotNull(menu);
        menu.printMenu("classpath:menu.txt");
    }

    @Test
    public void testConfigurationTypeNotNull() {
        assertNotNull(docType);
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

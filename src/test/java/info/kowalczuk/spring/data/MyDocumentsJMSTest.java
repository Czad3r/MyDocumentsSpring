package info.kowalczuk.spring.data;

import info.kowalczuk.spring.api.model.Type;
import info.kowalczuk.spring.api.service.SearchEngine;
import info.kowalczuk.spring.config.AppConfiguration;
import info.kowalczuk.spring.impl.component.JMSProducer;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfiguration.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyDocumentsJMSTest {
    private static final int MAX_ALL_DOCS = 5;
    private static final int MAX_WEB_DOCS = 2;

    @Autowired
    private SearchEngine engine;
    @Autowired
    private JMSProducer jmsProducer;

    @Test
    public void testSpringJMS_1(){
        String message = jmsProducer.getMessage();
        assertNotEquals(new String(), message);
        jmsProducer.send();
    }
    @Test
    public void testSpringJMS_2() throws InterruptedException {
        assertNotNull(engine);
        // Czeka przynajmniej 5 sekund na skonsumowanie wiadomości.
        Thread.sleep(5000);
        // Po wiadomości JMS i wstawieniu musi być 5 dokumentów.
        assertEquals(MAX_ALL_DOCS, engine.listAll().size());
        Type documentType = new Type("WEB", ".url");
        assertEquals(MAX_WEB_DOCS, engine.findByType(documentType).size());
    }

}

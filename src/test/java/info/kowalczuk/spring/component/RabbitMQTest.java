package info.kowalczuk.spring.component;

import info.kowalczuk.spring.api.model.Document;
import info.kowalczuk.spring.api.service.SearchEngine;
import info.kowalczuk.spring.config.AppConfiguration;
import info.kowalczuk.spring.impl.component.amqp.RabbitMQProducer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfiguration.class)
public class RabbitMQTest {
    private static final String DOCUMENT_ID = "1acbb68a-a859-49c9-ac88-d9e9322bac55";
    @Autowired
    private SearchEngine engine;

    @Autowired
    private RabbitMQProducer rabbitmqProducer;

    @Test
    public void testSpringRabbitMQ_1(){
        assertNotNull(rabbitmqProducer);
        assertNotNull(engine);
        Document document = engine.findById(DOCUMENT_ID);
        assertNotNull(document);
        rabbitmqProducer.send(document);
    }
}

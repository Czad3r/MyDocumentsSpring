package info.kowalczuk.spring.impl.component.amqp;

import info.kowalczuk.spring.api.model.Document;
import info.kowalczuk.spring.impl.utils.XmlUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component("rabbitmqConsumer")
public class RabbitMQConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        Document document = XmlUtils.fromXML(new String(message.getBody()), Document.class);
    }
}

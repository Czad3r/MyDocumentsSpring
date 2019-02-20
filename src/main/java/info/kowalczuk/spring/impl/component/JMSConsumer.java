package info.kowalczuk.spring.impl.component;

import info.kowalczuk.spring.api.data.DocumentRepository;
import info.kowalczuk.spring.api.model.Document;
import info.kowalczuk.spring.impl.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


@Component
public class JMSConsumer implements MessageListener {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            Document document = XmlUtils.fromXML(textMessage.getText(), Document.class);
            documentRepository.save(document);
        } catch (JMSException ex) {
            ex.printStackTrace();
        }


    }
}

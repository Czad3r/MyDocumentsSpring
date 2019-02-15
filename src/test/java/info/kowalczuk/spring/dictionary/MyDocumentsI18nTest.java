package info.kowalczuk.spring.dictionary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Locale;

public class MyDocumentsI18nTest {
    private ClassPathXmlApplicationContext context;
    private final String PL_VALUE="Witaj w programie Moje dokumenty";
    private final String EN_VALUE="Hello in MyDocuments";
    private final String ES_VALUE="Bienvenido a Mis Documentos";

    @BeforeEach
    public void setup(){
        context = new ClassPathXmlApplicationContext ("Dictionaries/language-i18n-context.xml");
    }
    @Test
    public void testMenu() {
        String polish = context.getMessage("main.title",null, new Locale("pl"));
        String spanish = context.getMessage("main.title",null, new Locale("es"));
        String english = context.getMessage("main.title",null, new Locale("en"));
        assertEquals(polish,PL_VALUE);
        assertEquals(spanish,ES_VALUE);
        assertEquals(english,EN_VALUE);
    }
}

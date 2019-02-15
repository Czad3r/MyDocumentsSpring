package info.kowalczuk.spring.config;

import info.kowalczuk.spring.api.model.Type;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ComponentScan(basePackages = "info.kowalczuk.spring")
@ImportResource({"classpath:/ConfigurationXML/repositoriesTest/documentRepositoryTest.xml ",
                "classpath:/ConfigurationXML/repositoriesTest/typeRepositoryTest.xml"})

public class AppConfiguration {
    @Bean
    public Type webType(){
        Type type=new Type();
        type = new Type();
        type.setName("WEB");
        type.setDesc("Łącze sieciowe");
        type.setExtension(".url");
        return type;
    }
}

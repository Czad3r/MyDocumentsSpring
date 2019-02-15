package info.kowalczuk.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ComponentScan(basePackages = "info.kowalczuk.spring")
@ImportResource({"classpath:/ConfigurationXML/repositoriesTest/documentRepositoryTest.xml "})

public class AppConfiguration {

}

package ua.shtamak.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.shtamak.custom.annotation.Trimmed;


//@EnableStringTrimming
@Configuration
public class ApplicationConfig {
    @Bean
    public SomeClass someClass() {
        return new SomeClass();
    }

    @Trimmed
    public static class SomeClass {
        public String hello(String param) {
            System.out.println("input param: " + param);
            return param;
        }

        public void writeSomeTest(String someText) {
            System.out.println(someText);
        }

        public String writeNotTrimmedHello() {
            return "         Hello!          ";
        }
    }
}

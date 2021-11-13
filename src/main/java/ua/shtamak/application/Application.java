package ua.shtamak.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.shtamak.application.config.ApplicationConfig;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        var hello = context.getBean(ApplicationConfig.SomeClass.class);
        var result = hello.hello("Hello    ");
        System.out.println(result);
        hello.writeSomeTest("   Some       text...     ");
        System.out.println(hello.writeNotTrimmedHello());
    }
}

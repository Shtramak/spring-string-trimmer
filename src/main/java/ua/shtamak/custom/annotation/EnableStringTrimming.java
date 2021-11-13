package ua.shtamak.custom.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ua.shtamak.custom.StringTrimmingConfiguration;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Configuration
@Import(StringTrimmingConfiguration.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableStringTrimming {
}

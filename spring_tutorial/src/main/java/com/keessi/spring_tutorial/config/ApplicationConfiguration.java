package com.keessi.spring_tutorial.config;

import com.keessi.spring_tutorial.lang.Language;
import com.keessi.spring_tutorial.lang.impl.English;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.keessi.spring_tutorial.bean"})
public class ApplicationConfiguration {
    @Bean(name = "language")
    public Language getLanguage() {
        return new English();
    }
}

package com.keessi.springMVC_tutorial.config;

import com.keessi.springMVC_tutorial.resolver.UrlLocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;

@Configuration
@ComponentScan("com.keessi.springMVC_tutorial")
public class AppContextConfig {
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name = "messageSource")
    public MessageSource getMessageResource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver() {
//        CookieLocaleResolver resolver = new CookieLocaleResolver();
//        resolver.setDefaultLocale(Locale.ENGLISH);
//        resolver.setCookieDomain("myAppLocaleCookie");
//        resolver.setCookieMaxAge(60 * 60);
        return new UrlLocaleResolver();
    }
}

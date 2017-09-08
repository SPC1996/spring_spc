package com.keessi.spring_tutorial;

import com.keessi.spring_tutorial.bean.GreetingService;
import com.keessi.spring_tutorial.bean.MyComponent;
import com.keessi.spring_tutorial.config.ApplicationConfiguration;
import com.keessi.spring_tutorial.lang.Language;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        System.out.println("------------------------------------------------");
        Language language = (Language) context.getBean("language");
        System.out.println("Language Type : " + language);
        System.out.println("Call language.sayGoodBye()");
        System.out.println("------------------------------------------------");

        System.out.println("------------------------------------------------");
        GreetingService service = (GreetingService) context.getBean("greetingService");
        service.sayGreeting();
        System.out.println("------------------------------------------------");

        System.out.println("------------------------------------------------");
        MyComponent component = (MyComponent) context.getBean("myComponent");
        component.showApplicationInfo();
        System.out.println("------------------------------------------------");
    }
}

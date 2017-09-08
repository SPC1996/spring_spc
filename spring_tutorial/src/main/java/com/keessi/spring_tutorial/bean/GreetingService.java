package com.keessi.spring_tutorial.bean;

import com.keessi.spring_tutorial.lang.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private final Language language;

    @Autowired
    public GreetingService(Language language) {
        this.language = language;
    }

    public void sayGreeting() {
        System.out.println(language.getGreeting());
    }
}

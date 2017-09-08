package com.keessi.spring_tutorial.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    private final MyRepository myRepository;

    @Autowired
    public MyComponent(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public void showApplicationInfo() {
        System.out.println("Now is " + myRepository.getSystemDate());
        System.out.println("Application name is " + myRepository.getApplicationName());
    }
}

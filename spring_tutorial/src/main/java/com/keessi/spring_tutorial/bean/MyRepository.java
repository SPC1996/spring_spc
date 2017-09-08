package com.keessi.spring_tutorial.bean;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class MyRepository {
    public String getApplicationName() {
        return "Spring Tutorial";
    }

    public Date getSystemDate() {
        return new Date();
    }
}

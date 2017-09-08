package com.keessi.spring_tutorial.lang.impl;

import com.keessi.spring_tutorial.lang.Language;

public class English implements Language {
    @Override
    public String getGreeting() {
        return "Hello";
    }

    @Override
    public String getGoodBye() {
        return "Bye bye";
    }

    @Override
    public String toString() {
        return "English";
    }
}

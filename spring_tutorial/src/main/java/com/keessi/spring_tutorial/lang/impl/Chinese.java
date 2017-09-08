package com.keessi.spring_tutorial.lang.impl;

import com.keessi.spring_tutorial.lang.Language;

public class Chinese implements Language {
    @Override
    public String getGreeting() {
        return "你好";
    }

    @Override
    public String getGoodBye() {
        return "再见";
    }

    @Override
    public String toString() {
        return "Chinese";
    }
}

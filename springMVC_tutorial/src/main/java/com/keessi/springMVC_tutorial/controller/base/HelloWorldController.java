package com.keessi.springMVC_tutorial.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
    @GetMapping("/hello.html")
    public String hello(Model model) {
        model.addAttribute("greeting", "Hello SpringMVC");
        return "hello";
    }
}

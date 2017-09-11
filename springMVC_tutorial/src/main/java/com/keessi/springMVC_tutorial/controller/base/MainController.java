package com.keessi.springMVC_tutorial.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String getStaticResource(Model model) {
        return "static";
    }
}

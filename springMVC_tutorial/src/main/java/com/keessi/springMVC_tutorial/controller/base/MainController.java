package com.keessi.springMVC_tutorial.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    @GetMapping("/")
    public String getStaticResource(Model model) {
        return "static";
    }

    @Deprecated
    @GetMapping("/admin/oldLogin")
    public String oldLogin(Model model) {
        return "oldLogin";
    }

    //    @GetMapping("/admin/login")
    @GetMapping("{locale:en|zh}/admin/login")
    public String login(Model model, @PathVariable("locale") String locale) {
        System.out.println("--------MainController.login-------");
        System.out.println("--------You are in controller------");
        return "login";
    }
}

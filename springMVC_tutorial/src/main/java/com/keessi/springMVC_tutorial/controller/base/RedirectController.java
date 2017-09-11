package com.keessi.springMVC_tutorial.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
    @GetMapping("/redirect.html")
    public String redirect() {
        return "redirect:/hello.html";
    }
}

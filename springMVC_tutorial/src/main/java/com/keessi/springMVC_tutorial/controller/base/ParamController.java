package com.keessi.springMVC_tutorial.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
    @GetMapping("/user.html")
    public String getUser(Model model, @RequestParam(value = "name", defaultValue = "Guest") String name) {
        model.addAttribute("name", name);
        if ("admin".equals(name)) {
            model.addAttribute("email", "123456@qq.com");
        } else {
            model.addAttribute("email", "Not Set");
        }
        return "user";
    }

    @GetMapping("/document/{language}/{id}/{text}.html")
    public String getDocument(Model model,
                              @PathVariable(value = "language") String language,
                              @PathVariable(value = "id") String id,
                              @PathVariable(value = "text") String text) {
        model.addAttribute("language", language);
        model.addAttribute("id", id);
        model.addAttribute("text", text);
        return "document";
    }
}

package com.keessi.springMVC_tutorial.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class OtherController {
    @GetMapping("/request.html")
    public String getRequestMsg(HttpServletRequest request, Model model) {
        model.addAttribute("type", request.getMethod());
        model.addAttribute("url", request.getRequestURL());
        model.addAttribute("headers", request.getHeaderNames().toString());
        return "request";
    }

    @GetMapping("/response.html")
    public String getResponseMsg(HttpServletResponse response, Model model) {
        model.addAttribute("status", response.getStatus());
        model.addAttribute("headers", response.getHeaderNames().toString());
        return "response";
    }
}

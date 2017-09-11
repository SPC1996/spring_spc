package com.keessi.springMVC_tutorial.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ResponseBodyController {
    @GetMapping(value = "/origin.html", produces = "text/html;charset=UTF-8")
    public String getOrigin() {
        return "不返回JSP， 返回字符串";
    }
}

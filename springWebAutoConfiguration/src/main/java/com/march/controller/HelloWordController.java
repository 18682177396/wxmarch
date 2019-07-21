package com.march.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWordController {

    @RequestMapping
    @ResponseBody
    public String helloWorld(){
        return "hello,Word!!";
    }
}

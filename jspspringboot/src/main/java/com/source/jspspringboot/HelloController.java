package com.source.jspspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public  String  hello(Model model,String name){
        System.out.println(name+"..........................................");
        model.addAttribute("name",name);
        return "hello";
    }

    @GetMapping("/hello2")
    public String hello2(Model model, String name) {
        System.out.println(name+"................222222222..........................");
        model.addAttribute("name", name);
        return "hello";
    }
}

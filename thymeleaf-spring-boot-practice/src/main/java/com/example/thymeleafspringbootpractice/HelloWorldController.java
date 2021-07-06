package com.example.thymeleafspringbootpractice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message","helo worldddsdsdsd");
        return "helloworld";
    }
    @GetMapping("/style")
    public String style(Model model){
        return "add-csss-js";
    }
    @GetMapping("/bootstrap")
    public String bootstrap(Model model){
        model.addAttribute("name","this is name coming from bootstrap endpoint");
        return "add-bootstrap";
    }
}

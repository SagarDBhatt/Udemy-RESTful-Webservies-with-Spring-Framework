package com.onslearning.udemyrestfulwebservices.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/")
    public String getHelloWorld(){
        return "Hello World";
    }

    @RequestMapping("/api")
    public String getString(){
        return "Use of URI - api";
    }

}

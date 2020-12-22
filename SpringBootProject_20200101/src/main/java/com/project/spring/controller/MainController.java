package com.project.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class MainController {
	@RequestMapping("/")
    public String root_test() throws Exception{
        return "Hello Spring Boot";
    }
 
    @RequestMapping("/test")
    public String demo_test() throws Exception{
        return "Hello Spring Boot TEST";
    }

}

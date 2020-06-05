package com.firstservice.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ProductController {

    @Value("${message}")
    String message;

    @GetMapping("/message")
    public String test() {
        return message;
    }
}
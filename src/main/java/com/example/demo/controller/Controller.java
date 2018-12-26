package com.example.demo.controller;

import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/converter")
public class Controller {

    @Autowired
    Service service;

    @GetMapping()
    public String convert(@RequestParam String from, @RequestParam String to, @RequestParam Double sum){
        return "<h1>" + service.converter(from, to, sum) + "</h1>";
    }

}

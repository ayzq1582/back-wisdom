package com.zhy.wisdom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DomeController {

    @GetMapping("/test")
    private String test(){
        return "hello";
    }
}

package com.AppCha.appCha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {


    @GetMapping(path = "/index")
    public String form() {
        return "index";
    }
}

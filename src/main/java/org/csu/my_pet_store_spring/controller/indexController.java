package org.csu.my_pet_store_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    @GetMapping("/")
    public String viewIndex(){
        return "index";
    }
}

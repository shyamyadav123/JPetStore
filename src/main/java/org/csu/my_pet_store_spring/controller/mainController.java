package org.csu.my_pet_store_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
    @GetMapping("/catalog/main")
    public  String viewMain(){
        return "/catalog/main";
    }

}

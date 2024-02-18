package com.mcalvaro.springbootdi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


    @GetMapping({ "/", "" })
    public String index(Model model) {
        model.addAttribute("result", service.run());
        return "index";
    }
}
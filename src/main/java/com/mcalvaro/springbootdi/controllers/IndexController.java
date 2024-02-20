package com.mcalvaro.springbootdi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mcalvaro.springbootdi.services.IService;

@Controller
public class IndexController {

    private IService service;

    public IndexController(IService service) {

        this.service = service;
    }

    // DI by Setter
    // @Autowired
    // public void setService(IService service) {
    // this.service = service;
    // }

    @GetMapping({ "/", "" })
    public String index(Model model) {
        model.addAttribute("result", service.run());
        return "index";
    }
}

package com.example.wy.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/test")
public class demo {
    @GetMapping(value = "/demo")
    public ModelAndView test(){
        String s ="Hello word!!";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hell",s);
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}

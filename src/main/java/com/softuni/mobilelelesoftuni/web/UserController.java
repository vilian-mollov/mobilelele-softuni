package com.softuni.mobilelelesoftuni.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {


    @GetMapping("/register")
    public ModelAndView getUsersRegister(ModelAndView modelAndView) {
        modelAndView.setViewName("auth-register");
        return modelAndView;
    }

}

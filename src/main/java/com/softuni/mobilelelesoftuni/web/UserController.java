package com.softuni.mobilelelesoftuni.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {


    @GetMapping("/register")
    public ModelAndView getUsersRegister(ModelAndView modelAndView) {
        modelAndView.setViewName("auth-register");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(ModelAndView modelAndView) {
        modelAndView.setViewName("auth-register");
        //todo register user
        return modelAndView;
    }


    @GetMapping("/login")
    public ModelAndView getUsersLogin(ModelAndView modelAndView) {
        modelAndView.setViewName("auth-login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginUser(ModelAndView modelAndView) {
        modelAndView.setViewName("auth-login");
        //todo login user
        return modelAndView;
    }

}
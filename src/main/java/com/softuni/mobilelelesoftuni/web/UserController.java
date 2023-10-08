package com.softuni.mobilelelesoftuni.web;

import com.softuni.mobilelelesoftuni.models.dtos.CreateUserDTO;
import com.softuni.mobilelelesoftuni.models.entities.enums.Role;
import com.softuni.mobilelelesoftuni.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView getUsersRegister(ModelAndView modelAndView) {
        modelAndView.setViewName("auth-register");
        modelAndView.addObject("roles", Role.values());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(ModelAndView modelAndView, CreateUserDTO createUserDTO) {
        modelAndView.setViewName("redirect:/");
        userService.createUser(createUserDTO);
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

package com.softuni.mobilelelesoftuni.web;

import com.softuni.mobilelelesoftuni.models.dtos.CreateUserDTO;
import com.softuni.mobilelelesoftuni.models.dtos.LoginUserDTO;
import com.softuni.mobilelelesoftuni.models.entities.enums.Role;
import com.softuni.mobilelelesoftuni.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

        if(!modelAndView.getModelMap().containsAttribute("createUserDTO")){
            modelAndView.getModelMap().addAttribute("createUserDTO", new CreateUserDTO());
        }


        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@Valid  @ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
                                     BindingResult bindingResult,
                                     RedirectAttributes rAtt,
                                     ModelAndView modelAndView) {

        if(bindingResult.hasErrors()){
            modelAndView.setViewName("redirect:/users/register");
            rAtt.addFlashAttribute("createUserDTO", createUserDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.createUserDTO", bindingResult);
            return modelAndView;
        }

        modelAndView.setViewName("redirect:/home");
        userService.createUser(createUserDTO);
        return modelAndView;
    }


    @GetMapping("/login")
    public ModelAndView getUsersLogin(ModelAndView modelAndView) {
        modelAndView.setViewName("auth-login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginUser(ModelAndView modelAndView, LoginUserDTO loginUserDTO) {
        modelAndView.setViewName("redirect:/home");
        userService.loginUser(loginUserDTO);
        return modelAndView;
    }

}

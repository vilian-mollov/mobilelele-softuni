package com.softuni.mobilelelesoftuni.web;

import com.softuni.mobilelelesoftuni.models.dtos.CreateUserDTO;
import com.softuni.mobilelelesoftuni.models.dtos.LoginUserDTO;
import com.softuni.mobilelelesoftuni.models.entities.enums.Role;
import com.softuni.mobilelelesoftuni.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String register(Model model) {

        if (!model.containsAttribute("createUserDTO")) {
            model.addAttribute("createUserDTO", new CreateUserDTO());
        }

        model.addAttribute("roles", Role.values());

        return "auth-register";
    }

    @PostMapping("/register")
    public String register(@Valid  @ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
                                     BindingResult bindingResult,
                                     RedirectAttributes rAtt) {

        if(bindingResult.hasErrors()){
            rAtt.addFlashAttribute("createUserDTO", createUserDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.createUserDTO", bindingResult);
            return "redirect:/users/register";
        }

        userService.createUser(createUserDTO);
        return "redirect:/home";
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

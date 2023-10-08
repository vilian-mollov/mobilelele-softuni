package com.softuni.mobilelelesoftuni.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/brands")
public class BrandController {

    @GetMapping("/all")
    public ModelAndView getAllBrands(ModelAndView modelAndView) {
        modelAndView.setViewName("brands");
        return modelAndView;
    }


}

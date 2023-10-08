package com.softuni.mobilelelesoftuni.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/offers")
public class OfferController {

    @GetMapping("/add")
    public ModelAndView getAddOffer(ModelAndView modelAndView) {
        modelAndView.setViewName("offer-add");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addOffer(ModelAndView modelAndView) {
        modelAndView.setViewName("offer-add");
        //todo add offer
        return modelAndView;
    }

}

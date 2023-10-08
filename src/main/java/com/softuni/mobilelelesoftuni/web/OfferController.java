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

    @GetMapping("/all")
    public ModelAndView getAllOffers(ModelAndView modelAndView) {
        modelAndView.setViewName("offers");
        return modelAndView;
    }

    @GetMapping("/details")
    public ModelAndView getOfferDetails(ModelAndView modelAndView) {
        modelAndView.setViewName("details");
        return modelAndView;
    }


    @GetMapping("/update")
    public ModelAndView getUpdateOffer(ModelAndView modelAndView) {
        modelAndView.setViewName("update");
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateOffer(ModelAndView modelAndView) {
        modelAndView.setViewName("update");
        //todo update offer
        return modelAndView;
    }

    @DeleteMapping("/delete")
    public ModelAndView deleteOffer(ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:/offers/all");
        //todo delete offer
        return modelAndView;
    }


}

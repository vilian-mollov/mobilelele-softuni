package com.softuni.mobilelelesoftuni.web;


import com.softuni.mobilelelesoftuni.exception.ObjectNotFoundException;
import com.softuni.mobilelelesoftuni.models.dtos.OfferDetailDTO;
import com.softuni.mobilelelesoftuni.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/offer")
public class SingleOfferController {

    private final OfferService offerService;

    @Autowired
    public SingleOfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/{uuid}")
    public ModelAndView details(@PathVariable("uuid") UUID uuid, ModelAndView modelAndView) {

        OfferDetailDTO offerDetailDTO = offerService
                .getOfferDetail(uuid)
                .orElseThrow(() -> new ObjectNotFoundException("Offer with uuid " + uuid + " not found!",""));

        modelAndView.setViewName("details");
        modelAndView.addObject("offer", offerDetailDTO);

        return modelAndView;
    }

    @DeleteMapping("single/{uuid}")
    public ModelAndView delete(@PathVariable("uuid") UUID uuid, ModelAndView modelAndView) {

        modelAndView.setViewName("redirect:/offers/all");
        offerService.deleteOffer(uuid);

        return modelAndView;
    }



}

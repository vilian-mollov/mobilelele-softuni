package com.softuni.mobilelelesoftuni.web;

import com.softuni.mobilelelesoftuni.models.dtos.CreateOfferDTO;
import com.softuni.mobilelelesoftuni.models.entities.enums.Engine;
import com.softuni.mobilelelesoftuni.services.BrandService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {


    private final BrandService brandService;

    public OfferController(BrandService brandService) {
        this.brandService = brandService;
    }


    @ModelAttribute("engines")
    public Engine[] engines() {
        return Engine.values();
    }

    @GetMapping("/add")
    public String add(Model model) {

        if (!model.containsAttribute("createOfferDTO")) {
            model.addAttribute("createOfferDTO", new CreateOfferDTO());
        }

        model.addAttribute("brands", brandService.getAllBrands() );

        return "offer-add";
    }

    @PostMapping("/add")
    public String add(
            @Valid CreateOfferDTO createOfferDTO,
            BindingResult bindingResult,
            RedirectAttributes rAtt) {

        if(bindingResult.hasErrors()){
            rAtt.addFlashAttribute("createOfferDTO", createOfferDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.createOfferDTO", bindingResult);
            return "redirect:/offers/add";
        }


//        UUID newOfferUUID = offerService.createOffer(createOfferDTO);

        return "redirect:/offer/";
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

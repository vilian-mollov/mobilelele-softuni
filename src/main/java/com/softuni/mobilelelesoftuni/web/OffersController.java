package com.softuni.mobilelelesoftuni.web;

import com.softuni.mobilelelesoftuni.models.dtos.CreateOfferDTO;
import com.softuni.mobilelelesoftuni.models.dtos.OfferSummaryDTO;
import com.softuni.mobilelelesoftuni.models.entities.enums.Engine;
import com.softuni.mobilelelesoftuni.services.BrandService;
import com.softuni.mobilelelesoftuni.services.OfferService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.data.domain.Pageable;

@Controller
@RequestMapping("/offers")
public class OffersController {


    private final BrandService brandService;
    private final OfferService offerService;

    @Autowired
    public OffersController(BrandService brandService,
                            OfferService offerService) {
        this.brandService = brandService;
        this.offerService = offerService;
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

        model.addAttribute("brands", brandService.getAllBrands());

        return "offer-add";
    }

    @PostMapping("/add")
    public String add(
            @Valid CreateOfferDTO createOfferDTO,
            BindingResult bindingResult,
            RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("createOfferDTO", createOfferDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.createOfferDTO", bindingResult);
            return "redirect:/offers/add";
        }


//        UUID newOfferUUID = offerService.createOffer(createOfferDTO);

        return "redirect:/offer/";
    }

    @GetMapping("/all")
    public ModelAndView getAllOffers(ModelAndView modelAndView, @PageableDefault(size = 3, sort = "uuid") Pageable pageable) {

        Page<OfferSummaryDTO> allOffers = offerService.getAllOffers(pageable);

        modelAndView.setViewName("offers");
        modelAndView.addObject("offers", allOffers);
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

package com.softuni.mobilelelesoftuni.web;

import com.softuni.mobilelelesoftuni.exception.ObjectNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalNotFoundExceptionHandler {


    @ExceptionHandler(ObjectNotFoundException.class)
    public ModelAndView handleNotFound(ObjectNotFoundException exception) {
        ModelAndView modelAndView = new ModelAndView("not-found-global");
        modelAndView.addObject("id", exception.getId());
        return modelAndView;
    }


}

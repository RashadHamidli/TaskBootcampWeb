package com.company.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleException(Exception e, Model model) {
        log.error("An unexpected error occurred", e);

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        modelAndView.addObject("errorName", "ServerError");
        modelAndView.addObject("errorMessage", "An unexpected error occurred.");

        return modelAndView;
    }
}

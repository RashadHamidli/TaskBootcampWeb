package com.company.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error")
public class ErrorHandlingController implements ErrorController {

    @GetMapping
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping()
    public ModelAndView handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            String errorName = (String) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
            String errorMessage = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("status", statusCode);
            modelAndView.addObject("errorName", errorName);
            modelAndView.addObject("errorMessage", errorMessage);
//            modelAndView.addObject("log", logMessage);
            return modelAndView;
        }

        return new ModelAndView("redirect:/login");
    }
}

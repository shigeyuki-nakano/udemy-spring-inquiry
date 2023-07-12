package com.example.demo.presentation.config;

import com.example.demo.domain.exception.ResourceNotFoundException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class WebMvcControllerAdvice {

    /*
     * This method changes empty character to null
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleException(ResourceNotFoundException e, Model model) {
        model.addAttribute("message", e);
        return "error/404";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("message", e);
        return "error/CustomPage";
    }
}

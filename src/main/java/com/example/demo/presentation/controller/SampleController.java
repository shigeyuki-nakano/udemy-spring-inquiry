package com.example.demo.presentation.controller;

import com.example.demo.domain.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @GetMapping
    public String test(Model model) {

        model.addAttribute("sampleList", sampleService.findAll());
        return "test";
    }

}

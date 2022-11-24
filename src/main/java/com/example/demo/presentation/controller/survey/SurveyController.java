package com.example.demo.presentation.controller.survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(SurveyController.BASE_PATH)
public class SurveyController {

    public static final String BASE_PATH = "/survey";

    @GetMapping
    public String index(Model model) {

        //hands-on

        return "survey/index";
    }

    @GetMapping("/form")
    public String form(/*Add parameters.*/) {

        //hands-on

        return "survey/form";
    }

    @PostMapping("/form")
    public String form(SurveyForm surveyForm, Model model) {

        //hands-on

        return "survey/form";
    }


    @PostMapping("/confirm")
    public String confirm(/*Add parameters.*/) {

        //hands-on

        return "survey/confirm";
    }

    @PostMapping("/complete")
    public String complete(/*Add parameters.*/) {

        //hands-on

        return "";
    }

}

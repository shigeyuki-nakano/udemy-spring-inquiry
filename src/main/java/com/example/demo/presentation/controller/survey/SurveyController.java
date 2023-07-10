package com.example.demo.presentation.controller.survey;

import com.example.demo.domain.service.SurveyService;
import com.example.demo.presentation.entity.request.SurveyAddRequest;
import com.example.demo.presentation.entity.request.SurveyUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.PositiveOrZero;

@Controller
@RequestMapping(SurveyController.BASE_PATH)
@RequiredArgsConstructor
public class SurveyController {

    public static final String BASE_PATH = "/survey";
    private final SurveyService surveyService;

    @GetMapping
    public String index(Model model) {
        final var surveyList = surveyService.getAll();
        final var satisfactionAverage = surveyService.getSatisfactionAverage();

        model
                .addAttribute("surveyList", surveyList)
                .addAttribute("title", "アンケートページ")
                .addAttribute("average", satisfactionAverage);

        return "survey/index";
    }

    @GetMapping("/form")
    public String form(@ModelAttribute SurveyAddRequest surveyAddRequest, Model model) {

        model
                .addAttribute("title", "アンケート記入ページ")
                .addAttribute("isComplete", false);

        return "survey/form/index";
    }

    @PostMapping("/form")
    public String formGoBack(
            @ModelAttribute SurveyAddRequest surveyAddRequest,
            Model model) {

        return form(surveyAddRequest, model);
    }

    @GetMapping("/form/{id}")
    public String updateForm(
            @PathVariable @PositiveOrZero Integer id,
            Model model) {

        final var survey = surveyService.getById(id);
        final var surveyUpdateRequest = SurveyUpdateRequest.of(survey);

        model
                .addAttribute("title", "アンケート記入ページ")
                .addAttribute("isComplete", false)
                .addAttribute("surveyUpdateRequest", surveyUpdateRequest);

        return "survey/form/update";
    }


    @PostMapping("/confirm")
    public String confirm(
            @ModelAttribute @Validated SurveyAddRequest surveyAddRequest,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "error/CustomPage";
        }

        return "survey/confirm";
    }

    @PostMapping("/confirm/update")
    public String confirm(
            @ModelAttribute @Validated SurveyUpdateRequest surveyUpdateRequest,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "error/CustomPage";
        }

        return "survey/confirm";
    }

    @PostMapping("/complete")
    public String complete(SurveyAddRequest surveyAddRequest, Model model) {
        surveyService.register(surveyAddRequest.convert());

        model.addAttribute("isComplete", true);

        return "redirect:/survey";
    }

    @PutMapping("/complete")
    public String complete(SurveyUpdateRequest surveyUpdateRequest, Model model) {
        surveyService.update(surveyUpdateRequest.convert());

        model.addAttribute("isComplete", true);

        return "redirect:/survey";
    }
}

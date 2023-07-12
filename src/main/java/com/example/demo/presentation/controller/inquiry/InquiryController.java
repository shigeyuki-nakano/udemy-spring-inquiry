package com.example.demo.presentation.controller.inquiry;

import com.example.demo.domain.model.inquiry.AddInquiry;
import com.example.demo.domain.model.inquiry.UpdateInquiry;
import com.example.demo.domain.service.InquiryService;
import com.example.demo.presentation.entity.request.InquiryAddRequest;
import com.example.demo.presentation.entity.request.InquiryUpdateRequest;
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
@RequiredArgsConstructor
@RequestMapping(InquiryController.BASE_PATH)
public class InquiryController {

    private final InquiryService inquiryService;
    public static final String BASE_PATH = "/inquiry";

    @GetMapping
    public String index(Model model) {
        final var inquiryList = inquiryService.findAll();

        model
                .addAttribute("title", "お問合せ")
                .addAttribute("inquiryList", inquiryList);

        return "inquiry/index";
    }

    @GetMapping("/form")
    public String form(@ModelAttribute InquiryAddRequest inquiryAddRequest, Model model) {

        model
                .addAttribute("title", "お問合せ");
        return "inquiry/form/index";
    }

    @GetMapping("/form/{id}")
    public String updateForm(
            @PathVariable("id")
            @PositiveOrZero Integer id,
            Model model) {
        final var inquiry = inquiryService.findById(id);

        model
                .addAttribute("title", "お問合せ")
                .addAttribute("inquiryUpdateRequest", UpdateInquiry.of(inquiry));
        return "inquiry/form/update";
    }

    @PostMapping("/form")
    public String formGoBack(@ModelAttribute InquiryAddRequest inquiryAddRequest, Model model) {
        model
                .addAttribute("title", "お問合せ")
                .addAttribute("inquiryAddRequest", inquiryAddRequest);
        return "inquiry/form/index";
    }


    @PostMapping("/confirm")
    public String confirm(
            @ModelAttribute @Validated InquiryAddRequest inquiryAddRequest,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return form(inquiryAddRequest, model);
        }

        model
                .addAttribute("inquiryAddRequest", inquiryAddRequest);

        return "inquiry/confirm";
    }

    @PostMapping("/complete")
    public String complete(InquiryAddRequest inquiryAddRequest, Model model) {
        inquiryService.register(AddInquiry.of(inquiryAddRequest));

        model
                .addAttribute("isComplete", true);

        return "redirect:/inquiry";
    }

    @PutMapping("/complete")
    public String updateComplete(InquiryUpdateRequest inquiryUpdateRequest, Model model) {
        inquiryService.update(UpdateInquiry.of(inquiryUpdateRequest));

        model
                .addAttribute("isComplete", true);

        return "redirect:/inquiry";
    }

}

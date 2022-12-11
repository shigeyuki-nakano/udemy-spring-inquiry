package com.example.demo.domain.model.survey;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Builder
public class AddSurvey {

    @NotNull
    int age;

    @NotNull
    SatisfactionLevels satisfaction;

    String comment;
}

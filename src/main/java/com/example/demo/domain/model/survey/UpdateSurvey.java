package com.example.demo.domain.model.survey;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Builder
public class UpdateSurvey {

    @NotNull
    int id;

    int age;

    int satisfaction;

    String comment;
}

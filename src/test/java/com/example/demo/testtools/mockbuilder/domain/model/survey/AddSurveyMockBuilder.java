package com.example.demo.testtools.mockbuilder.domain.model.survey;

import com.example.demo.domain.model.survey.AddSurvey;
import com.example.demo.domain.model.survey.SatisfactionLevels;

public class AddSurveyMockBuilder {

    public static AddSurvey build() {
        return AddSurvey.builder()
                .age(20)
                .satisfaction(SatisfactionLevels.EXTREMELY_WELL)
                .comment("comment")
                .build();
    }
}

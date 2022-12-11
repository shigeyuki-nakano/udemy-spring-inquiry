package com.example.demo.testtools.mockbuilder.domain.model.survey;

import com.example.demo.domain.model.survey.SatisfactionLevels;
import com.example.demo.domain.model.survey.UpdateSurvey;

public class UpdateSurveyMockBuilder {

    public static UpdateSurvey build() {
        return UpdateSurvey.builder()
                .id(1)
                .age(20)
                .satisfaction(SatisfactionLevels.EXTREMELY_WELL)
                .comment("comment")
                .build();
    }
}

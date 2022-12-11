package com.example.demo.testtools.mockbuilder.domain.model.survey;

import com.example.demo.domain.model.survey.SatisfactionLevels;
import com.example.demo.domain.model.survey.Survey;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class SurveyMockBuilder {

    public static Survey build() {
        return Survey.builder()
                .id(1)
                .age(20)
                .satisfaction(SatisfactionLevels.EXTREMELY_WELL)
                .comment("comment")
                .created(LocalDateTime.of(2022, 11, 11, 0, 0, 0))
                .build();
    }

    public static Survey buildByIndex(int index) {
        return Survey.builder()
                .id(index)
                .age(20)
                .satisfaction(SatisfactionLevels.EXTREMELY_WELL)
                .comment("comment")
                .created(LocalDateTime.of(2022, 11, 11, 0, 0, 0))
                .build();
    }

    public static List<Survey> buildOfList() {
        return Arrays.asList(buildByIndex(1), buildByIndex(2), buildByIndex(3));
    }
}

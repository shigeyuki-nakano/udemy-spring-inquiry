package com.example.demo.presentation.entity.request;

import com.example.demo.domain.model.survey.SatisfactionLevels;
import com.example.demo.domain.model.survey.Survey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveyAddRequest {

    @NotNull
    @Min(0)
    @Max(150)
    int age;

    @NotNull
    @Min(1)
    @Max(5)
    int satisfaction;

    @Size(max = 200, message = "200文字以内で入力してください")
    String comment;

    public Survey convert() {
        return Survey.builder()
                .age(age)
                .satisfaction(SatisfactionLevels.of(satisfaction))
                .comment(comment)
                .build();
    }
}

package com.example.demo.infrastructure.entity;

import com.example.demo.domain.model.survey.SatisfactionLevels;
import com.example.demo.domain.model.survey.Survey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "survey")
public class SurveyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private int age;
    @NotNull
    private int satisfaction;
    private String comment;
    private LocalDateTime created;

    public Survey convert() {
        return Survey.builder()
                .id(id)
                .age(age)
                .satisfaction(SatisfactionLevels.of(id))
                .comment(comment)
                .created(created)
                .build();
    }

    public static SurveyEntity of(Survey survey) {
        return SurveyEntity.builder()
                .age(survey.getAge())
                .satisfaction(survey.getSatisfaction().getId())
                .comment(survey.getComment())
                .build();
    }
}

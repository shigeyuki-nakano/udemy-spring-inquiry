package com.example.demo.domain.repository;

import com.example.demo.infrastructure.entity.Survey;

import java.util.List;

public interface SurveyDao {

    void insertSurvey(Survey survey);

    List<Survey> getAll();

}

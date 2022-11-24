package com.example.demo.domain.service;

import com.example.demo.infrastructure.entity.Survey;

import java.util.List;

public interface SurveyService {

    void save(Survey survey);

    List<Survey> getAll();

}

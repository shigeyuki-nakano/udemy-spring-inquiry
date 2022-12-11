package com.example.demo.domain.service;

import com.example.demo.domain.model.survey.AddSurvey;
import com.example.demo.domain.model.survey.Survey;
import com.example.demo.domain.model.survey.UpdateSurvey;
import com.example.demo.domain.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;

    /**
     * {@inheritDoc}
     */
    public List<Survey> getAll() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Survey getById(int id) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean register(AddSurvey survey) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(UpdateSurvey survey) {
        return false;
    }
}

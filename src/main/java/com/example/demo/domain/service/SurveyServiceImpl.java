package com.example.demo.domain.service;

import com.example.demo.domain.exception.ResourceNotFoundException;
import com.example.demo.domain.model.survey.AddSurvey;
import com.example.demo.domain.model.survey.SatisfactionLevels;
import com.example.demo.domain.model.survey.Survey;
import com.example.demo.domain.model.survey.UpdateSurvey;
import com.example.demo.domain.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;

    /**
     * {@inheritDoc}
     */
    public List<Survey> getAll() {
        return surveyRepository.getAll();
    }

    /**
     * {@inheritDoc}
     */
    public Survey getById(int id) {
        final var survey = surveyRepository.getById(id);

        if (Objects.isNull(survey)) {
            throw new ResourceNotFoundException("指定されたIDをもつアンケートが見つかりませんでした。 id : " + id);
        }

        return survey;
    }

    /**
     * {@inheritDoc}
     */
    public int getSatisfactionAverage() {
        final var surveyList = surveyRepository.getAll();

        if (surveyList.isEmpty()) {
            return 0;
        }

        final var average = surveyList.stream()
                .map(Survey::getSatisfaction)
                .mapToInt(SatisfactionLevels::getId)
                .average()
                .orElseThrow();

        return (int) Math.floor(average);
    }

    /**
     * {@inheritDoc}
     */
    public boolean register(AddSurvey survey) {
        return surveyRepository.register(survey);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(UpdateSurvey survey) {
        return surveyRepository.update(survey);
    }
}

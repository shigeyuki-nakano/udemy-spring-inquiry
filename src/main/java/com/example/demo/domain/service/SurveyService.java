package com.example.demo.domain.service;

import com.example.demo.domain.model.survey.SatisfactionLevels;
import com.example.demo.domain.model.survey.Survey;
import com.example.demo.domain.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyService {

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
        return surveyRepository.getById(id);
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
                // 満足度UNKNOWNのアンケートを平均算から除外
                .filter(satisfactionLevels -> !SatisfactionLevels.UNKNOWN.equals(satisfactionLevels))
                .mapToInt(SatisfactionLevels::getId)
                .average()
                .orElseThrow();

        return (int) Math.floor(average);
    }

    /**
     * {@inheritDoc}
     */
    public void register(Survey survey) {
        surveyRepository.register(survey);
    }

    /**
     * {@inheritDoc}
     */
    public void update(Survey survey) {
        surveyRepository.update(survey);
    }
}

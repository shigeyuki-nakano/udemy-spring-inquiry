package com.example.demo.domain.service;

import com.example.demo.domain.exception.InternalServerErrorException;
import com.example.demo.domain.model.survey.SatisfactionLevels;
import com.example.demo.domain.model.survey.Survey;
import com.example.demo.domain.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyService {

    private final SurveyRepository surveyRepository;

    /**
     * {@inheritDoc}
     */
    public List<Survey> findAll() {
        return surveyRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    public Survey findById(int id) {
        return surveyRepository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    public int getSatisfactionAverage() {
        final var surveyList = surveyRepository.findAll();

        if (surveyList.isEmpty()) {
            return 0;
        }

        final var average = surveyList.stream()
                .map(Survey::getSatisfaction)
                // 満足度UNKNOWNのアンケートを平均算から除外
                .filter(satisfactionLevels -> !SatisfactionLevels.UNKNOWN.equals(satisfactionLevels))
                .mapToInt(SatisfactionLevels::getId)
                .average()
                .orElseThrow(() -> new InternalServerErrorException("満足度の平均算出に失敗しました"));

        // 少数を切り捨てて返却
        return (int) Math.floor(average);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public void register(Survey survey) {
        surveyRepository.register(survey);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public void update(Survey survey) {
        surveyRepository.update(survey);
    }
}

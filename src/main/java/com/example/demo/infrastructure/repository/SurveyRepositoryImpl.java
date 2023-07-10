package com.example.demo.infrastructure.repository;

import com.example.demo.domain.model.survey.Survey;
import com.example.demo.domain.repository.SurveyRepository;
import com.example.demo.infrastructure.entity.SurveyEntity;
import com.example.demo.infrastructure.repository.jpa.SurveyJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class SurveyRepositoryImpl implements SurveyRepository {

    private final SurveyJpaRepository surveyJpaRepository;

    /**
     * {@inheritDoc}
     */
    public List<Survey> getAll() {
        final var surveyList = surveyJpaRepository.findAll();

        return surveyList.stream()
                .map(SurveyEntity::convert)
                .collect(Collectors.toList());
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
    public void register(Survey survey) {
        surveyJpaRepository.save(SurveyEntity.of(survey));
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(Survey survey) {
        return false;
    }
}

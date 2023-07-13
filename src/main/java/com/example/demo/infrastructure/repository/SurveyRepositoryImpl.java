package com.example.demo.infrastructure.repository;

import com.example.demo.domain.exception.ResourceNotFoundException;
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
    public List<Survey> findAll() {
        final var surveyList = surveyJpaRepository.findAll();

        return surveyList.stream()
                .map(SurveyEntity::convert)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    public Survey findById(int id) {
        final var survey = surveyJpaRepository.findById(id);
        return survey
                .orElseThrow(() -> new ResourceNotFoundException("指定されたIDをもつアンケートが見つかりませんでした。 id : " + id))
                .convert();
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
    public void update(Survey survey) {
        surveyJpaRepository.findById(survey.getId())
                .orElseThrow(() -> new ResourceNotFoundException("更新対象のアンケートが見つかりませんでした。"));

        surveyJpaRepository.save(SurveyEntity.of(survey));
    }
}

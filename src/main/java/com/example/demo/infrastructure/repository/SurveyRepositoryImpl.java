package com.example.demo.infrastructure.repository;

import com.example.demo.domain.model.survey.AddSurvey;
import com.example.demo.domain.model.survey.Survey;
import com.example.demo.domain.model.survey.UpdateSurvey;
import com.example.demo.domain.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SurveyRepositoryImpl implements SurveyRepository {

    private final JdbcTemplate jdbcTemplate;

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

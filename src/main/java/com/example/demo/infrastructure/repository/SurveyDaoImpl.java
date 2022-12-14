package com.example.demo.infrastructure.repository;

import com.example.demo.domain.repository.SurveyDao;
import com.example.demo.infrastructure.entity.Survey;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SurveyDaoImpl implements SurveyDao {

    private final JdbcTemplate jdbcTemplate;


    public SurveyDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertSurvey(Survey survey) {

        //hands-on

    }

    @Override
    public List<Survey> getAll() {
        //make SQL
        List<Map<String, Object>> resultList = null;
        List<Survey> list = null;

        //Set the data form database into Survey instance

        return list;
    }


}

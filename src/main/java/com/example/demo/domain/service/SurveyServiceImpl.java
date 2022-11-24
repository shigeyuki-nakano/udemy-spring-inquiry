package com.example.demo.domain.service;

import com.example.demo.domain.exception.InquiryNotFoundException;
import com.example.demo.infrastructure.entity.Survey;
import com.example.demo.infrastructure.repository.SurveyDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyDao dao;

    SurveyServiceImpl(SurveyDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Survey survey) {
        //hands-on
    }

    @Override
    public List<Survey> getAll() {
        if (dao.getAll().isEmpty()) {
            throw new InquiryNotFoundException("SQL error");
        }
        return dao.getAll();
    }

}

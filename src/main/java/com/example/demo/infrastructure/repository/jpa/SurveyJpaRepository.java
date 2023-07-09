package com.example.demo.infrastructure.repository.jpa;

import com.example.demo.infrastructure.entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyJpaRepository extends JpaRepository<SurveyEntity, String> {

}

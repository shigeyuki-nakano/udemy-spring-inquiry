package com.example.demo.infrastructure.repository.jpa;

import com.example.demo.infrastructure.entity.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleJpaRepository extends JpaRepository<SampleEntity, String> {

}

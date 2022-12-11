package com.example.demo.infrastructure.repository.jpa;

import com.example.demo.infrastructure.entity.InquiryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryJpaRepository extends JpaRepository<InquiryEntity, Integer> {

}

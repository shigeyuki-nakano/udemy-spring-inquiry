package com.example.demo.infrastructure.repository.jpa;

import com.example.demo.infrastructure.entity.InquiryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryJpaRepository extends JpaRepository<InquiryEntity, String> {

}

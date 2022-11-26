package com.example.demo.infrastructure.repository;

import com.example.demo.domain.model.Inquiry;
import com.example.demo.infrastructure.entity.InquiryEntity;
import com.example.demo.infrastructure.repository.jpa.InquiryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class InquiryRepositoryImpl implements InquiryRepository {

    private final InquiryJpaRepository inquiryJpaRepository;

    @Override
    public void insertInquiry(Inquiry inquiry) {
        final var inquiryEntity = InquiryEntity.of(inquiry);
        inquiryJpaRepository.save(inquiryEntity);
    }

    @Override
    public int updateInquiry(Inquiry inquiry) {
        final var inquiryEntity = InquiryEntity.of(inquiry);
        final var isExists = inquiryJpaRepository.existsById(String.valueOf(inquiryEntity.getId()));

        if (isExists) {
            return 0;
        }

        inquiryJpaRepository.save(inquiryEntity);
        final var isSuccess = inquiryJpaRepository.existsById(String.valueOf(inquiryEntity.getId()));

        return isSuccess ? 1 : 0;
    }

    @Override
    public List<Inquiry> getAll() {
        final var result = inquiryJpaRepository.findAll();

        return result.stream()
                .map(InquiryEntity::convert)
                .collect(Collectors.toList());
    }

}

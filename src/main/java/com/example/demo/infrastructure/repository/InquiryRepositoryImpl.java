package com.example.demo.infrastructure.repository;

import com.example.demo.domain.model.inquiry.AddInquiry;
import com.example.demo.domain.model.inquiry.Inquiry;
import com.example.demo.domain.model.inquiry.UpdateInquiry;
import com.example.demo.domain.repository.InquiryRepository;
import com.example.demo.infrastructure.entity.InquiryEntity;
import com.example.demo.infrastructure.repository.jpa.InquiryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class InquiryRepositoryImpl implements InquiryRepository {

    private final InquiryJpaRepository inquiryJpaRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertInquiry(AddInquiry inquiry) {
        final var inquiryEntity = InquiryEntity.of(inquiry);
        inquiryJpaRepository.save(inquiryEntity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int updateInquiry(UpdateInquiry inquiry) {
        final var inquiryEntity = InquiryEntity.of(inquiry);

        inquiryJpaRepository.save(inquiryEntity);
        final var isSuccess = inquiryJpaRepository.existsById(inquiryEntity.getId());

        return isSuccess ? 1 : 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Inquiry> getAll() {
        final var result = inquiryJpaRepository.findAll();

        return result.stream()
                .map(InquiryEntity::convert)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    public Optional<Inquiry> getById(int id) {
        final var result = inquiryJpaRepository.findById(id);

        return result.map(InquiryEntity::convert);
    }
}

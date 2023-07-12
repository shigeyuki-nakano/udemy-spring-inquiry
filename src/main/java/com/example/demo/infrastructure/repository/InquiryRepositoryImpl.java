package com.example.demo.infrastructure.repository;

import com.example.demo.domain.exception.ResourceNotFoundException;
import com.example.demo.domain.model.inquiry.Inquiry;
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
    public void register(Inquiry inquiry) {
        final var inquiryEntity = InquiryEntity.of(inquiry);
        inquiryJpaRepository.save(inquiryEntity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Inquiry inquiry) {
        inquiryJpaRepository.findById(inquiry.getId())
                .orElseThrow(() -> new ResourceNotFoundException("更新対象のお問合せが見つかりませんでした。"));

        inquiryJpaRepository.save(InquiryEntity.of(inquiry));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Inquiry> findAll() {
        final var result = inquiryJpaRepository.findAll();

        return result.stream()
                .map(InquiryEntity::convert)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    public Optional<Inquiry> findById(int id) {
        final var result = inquiryJpaRepository.findById(id);

        return result.map(InquiryEntity::convert);
    }
}

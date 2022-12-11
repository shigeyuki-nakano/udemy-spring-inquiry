package com.example.demo.infrastructure.repository;

import com.example.demo.domain.model.Sample;
import com.example.demo.domain.repository.SampleRepository;
import com.example.demo.infrastructure.repository.jpa.SampleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Repository
@RequiredArgsConstructor
public class SampleRepositoryImpl implements SampleRepository {

    private final SampleJpaRepository sampleJpaRepository;

    /**
     * {@inheritDoc}
     */
    public List<Sample> findAll() {
        final var result = sampleJpaRepository.findAll();

        return result.stream()
                .map(Sample::of)
                .collect(Collectors.toList());
    }
}

package com.example.demo.domain.service;

import com.example.demo.domain.model.Sample;
import com.example.demo.domain.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {

    private final SampleRepository sampleRepository;

    /**
     * {@inheritDoc}
     */
    public List<Sample> findAll() {
        return sampleRepository.findAll();
    }
}

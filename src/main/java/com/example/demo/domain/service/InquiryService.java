package com.example.demo.domain.service;

import com.example.demo.domain.exception.ResourceNotFoundException;
import com.example.demo.domain.model.inquiry.Inquiry;
import com.example.demo.domain.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
@RequiredArgsConstructor
public class InquiryService {

    private final InquiryRepository repository;

    /**
     * {@inheritDoc}
     */
    @Transactional
    public void register(Inquiry inquiry) {
        repository.register(inquiry);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public void update(Inquiry inquiry) {
        repository.update(inquiry);
    }

    /**
     * {@inheritDoc}
     */
    public List<Inquiry> findAll() {
        return repository.findAll();
    }

    public Inquiry findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("指定されたお問い合わせが見つかりませんでした"));
    }
}

package com.example.demo.domain.service;

import com.example.demo.domain.exception.ResourceNotFoundException;
import com.example.demo.domain.model.inquiry.AddInquiry;
import com.example.demo.domain.model.inquiry.Inquiry;
import com.example.demo.domain.model.inquiry.UpdateInquiry;
import com.example.demo.infrastructure.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
@RequiredArgsConstructor
public class InquiryServiceImpl implements InquiryService {

    private final InquiryRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(AddInquiry inquiry) {
        repository.insertInquiry(inquiry);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(UpdateInquiry inquiry) {
        final var resultCount = repository.updateInquiry(inquiry);

        if (resultCount == 0) {
            throw new ResourceNotFoundException("更新対象のお問合せ内容が見つかりませんでした。");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Inquiry> getAll() {
        return repository.getAll();
    }

    public Inquiry get(int id) {
        return repository.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("指定されたお問い合わせが見つかりませんでした"));
    }
}

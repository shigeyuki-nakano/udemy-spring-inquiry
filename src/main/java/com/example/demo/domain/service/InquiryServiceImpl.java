package com.example.demo.domain.service;

import com.example.demo.domain.exception.ResourceNotFoundException;
import com.example.demo.domain.model.Inquiry;
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

    private final InquiryRepository dao;

    @Override
    @Transactional
    public void save(Inquiry inquiry) {
        dao.insertInquiry(inquiry);
    }

    @Override
    @Transactional
    public void update(Inquiry inquiry) {
        final var resultCount = dao.updateInquiry(inquiry);

        if (resultCount == 0) {
            throw new ResourceNotFoundException("更新対象のお問合せ内容が見つかりませんでした。");
        }
    }

    @Override
    public List<Inquiry> getAll() {
        return dao.getAll();
    }
}

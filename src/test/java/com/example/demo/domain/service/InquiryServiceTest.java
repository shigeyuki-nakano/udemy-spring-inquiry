package com.example.demo.domain.service;

import com.example.demo.domain.exception.ResourceNotFoundException;
import com.example.demo.domain.model.inquiry.Inquiry;
import com.example.demo.domain.repository.InquiryRepository;
import com.example.demo.testtools.mockbuilder.domain.model.inquiry.InquiryMockBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class InquiryServiceTest {

    private InquiryService inquiryService;
    private InquiryRepository inquiryRepository;

    @BeforeEach
    void setup() {
        inquiryRepository = mock(InquiryRepository.class);
        inquiryService = new InquiryService(inquiryRepository);
    }

    @Nested
    @DisplayName("method : register")
    class Register {

        private final Inquiry inquiry = InquiryMockBuilder.build();

        @Test
        @DisplayName("正常系: 例外なく処理が終了すること")
        void case1() {
            // テスト準備

            // 実施
            inquiryService.register(inquiry);

            // 検証
            verify(inquiryRepository, times(1)).register(inquiry);
        }
    }

    @Nested
    @DisplayName("method : update")
    class Update {

        private final Inquiry inquiry = InquiryMockBuilder.build();

        @Test
        @DisplayName("正常系: 例外なく処理が終了すること")
        void case1() {
            // テスト準備
            when(inquiryRepository.findById(inquiry.getId()))
                    .thenReturn(Optional.of(inquiry));

            // 実施
            inquiryService.update(inquiry);

            // 検証
            verify(inquiryRepository, times(1)).update(inquiry);
        }
    }

    @Nested
    @DisplayName("method : findAll")
    class FindAll {

        private final List<Inquiry> inquiryList = InquiryMockBuilder.buildOfList();

        @Test
        @DisplayName("正常系: お問合せリストが取得できること")
        void case1() {
            // テスト準備
            when(inquiryRepository.findAll())
                    .thenReturn(inquiryList);

            // 実施
            final var actual = inquiryService.findAll();

            // 検証
            Assertions.assertEquals(inquiryList, actual);
        }
    }

    @Nested
    @DisplayName("method : findById")
    class FindById {

        private final int index = 1;
        private final Inquiry inquiry = InquiryMockBuilder.buildByIndex(index);

        @Test
        @DisplayName("正常系: お問合せ内容が取得できること")
        void case1() {
            // テスト準備
            when(inquiryRepository.findById(index))
                    .thenReturn(Optional.of(inquiry));

            // 実施
            final var actual = inquiryService.findById(index);

            // 検証
            Assertions.assertEquals(inquiry, actual);
        }

        @Test
        @DisplayName("正常系: 結果が存在しなかった場合は、ResourceNotFoundExceptionがスローされること")
        void case2() {
            // テスト準備
            when(inquiryRepository.findById(index))
                    .thenReturn(Optional.empty());

            // 実施 & 検証
            Assertions.assertThrows(ResourceNotFoundException.class,
                    () -> inquiryService.findById(index));
        }
    }
}

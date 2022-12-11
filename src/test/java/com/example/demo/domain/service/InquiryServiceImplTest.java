package com.example.demo.domain.service;

import com.example.demo.domain.exception.ResourceNotFoundException;
import com.example.demo.domain.model.inquiry.AddInquiry;
import com.example.demo.domain.model.inquiry.Inquiry;
import com.example.demo.domain.model.inquiry.UpdateInquiry;
import com.example.demo.domain.repository.InquiryRepository;
import com.example.demo.testtools.mockbuilder.domain.model.inquiry.AddInquiryMockBuilder;
import com.example.demo.testtools.mockbuilder.domain.model.inquiry.InquiryMockBuilder;
import com.example.demo.testtools.mockbuilder.domain.model.inquiry.UpdateInquiryMockBuilder;
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

public class InquiryServiceImplTest {

    private InquiryService inquiryService;
    private InquiryRepository inquiryRepository;

    @BeforeEach
    void setup() {
        inquiryRepository = mock(InquiryRepository.class);
        inquiryService = new InquiryServiceImpl(inquiryRepository);
    }

    @Nested
    @DisplayName("method : save")
    class Save {

        private final AddInquiry addInquiry = AddInquiryMockBuilder.build();

        @Test
        @DisplayName("正常系: 例外なく処理が終了すること")
        void case1() {
            // テスト準備

            // 実施
            inquiryService.save(addInquiry);

            // 検証
            verify(inquiryRepository, times(1)).insertInquiry(addInquiry);
        }
    }

    @Nested
    @DisplayName("method : update")
    class Update {

        private final Inquiry inquiry = InquiryMockBuilder.build();
        private final UpdateInquiry updateInquiry = UpdateInquiryMockBuilder.build();

        @Test
        @DisplayName("正常系: 例外なく処理が終了すること")
        void case1() {
            // テスト準備
            when(inquiryRepository.getById(updateInquiry.getId()))
                    .thenReturn(Optional.of(inquiry));
            when(inquiryRepository.updateInquiry(updateInquiry))
                    .thenReturn(1);

            // 実施
            inquiryService.update(updateInquiry);

            // 検証
            verify(inquiryRepository, times(1)).updateInquiry(updateInquiry);
        }

        @Test
        @DisplayName("異常系: 更新対象が見つからない場合は、ResourceNotFoundExceptionがスローされること")
        void case2() {
            // テスト準備
            when(inquiryRepository.getById(inquiry.getId()))
                    .thenReturn(Optional.empty());
            when(inquiryRepository.updateInquiry(updateInquiry))
                    .thenReturn(0);

            // 実施 & 検証
            Assertions.assertThrows(ResourceNotFoundException.class,
                    () -> inquiryService.update(updateInquiry));
        }
    }

    @Nested
    @DisplayName("method : getAll")
    class GetAll {

        private final List<Inquiry> inquiryList = InquiryMockBuilder.buildOfList();

        @Test
        @DisplayName("正常系: お問合せリストが取得できること")
        void case1() {
            // テスト準備
            when(inquiryRepository.getAll())
                    .thenReturn(inquiryList);

            // 実施
            final var actual = inquiryService.getAll();

            // 検証
            Assertions.assertEquals(inquiryList, actual);
        }
    }

    @Nested
    @DisplayName("method : get")
    class Get {

        private final int index = 1;
        private final Inquiry inquiry = InquiryMockBuilder.buildByIndex(index);

        @Test
        @DisplayName("正常系: お問合せ内容が取得できること")
        void case1() {
            // テスト準備
            when(inquiryRepository.getById(index))
                    .thenReturn(Optional.of(inquiry));

            // 実施
            final var actual = inquiryService.get(index);

            // 検証
            Assertions.assertEquals(inquiry, actual);
        }

        @Test
        @DisplayName("正常系: 結果が存在しなかった場合は、ResourceNotFoundExceptionがスローされること")
        void case2() {
            // テスト準備
            when(inquiryRepository.getById(index))
                    .thenReturn(Optional.empty());

            // 実施 & 検証
            Assertions.assertThrows(ResourceNotFoundException.class,
                    () -> inquiryService.get(index));
        }
    }
}

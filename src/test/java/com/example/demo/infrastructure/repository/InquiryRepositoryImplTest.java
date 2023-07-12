package com.example.demo.infrastructure.repository;

import com.example.demo.domain.exception.ResourceNotFoundException;
import com.example.demo.domain.model.inquiry.AddInquiry;
import com.example.demo.domain.model.inquiry.Inquiry;
import com.example.demo.domain.model.inquiry.UpdateInquiry;
import com.example.demo.domain.repository.InquiryRepository;
import com.example.demo.infrastructure.entity.InquiryEntity;
import com.example.demo.infrastructure.repository.jpa.InquiryJpaRepository;
import com.example.demo.testtools.mockbuilder.domain.model.inquiry.AddInquiryMockBuilder;
import com.example.demo.testtools.mockbuilder.domain.model.inquiry.InquiryMockBuilder;
import com.example.demo.testtools.mockbuilder.domain.model.inquiry.UpdateInquiryMockBuilder;
import com.example.demo.testtools.mockbuilder.infrastructure.entity.InquiryEntityMockBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class InquiryRepositoryImplTest {

    private InquiryRepository inquiryRepository;
    private InquiryJpaRepository inquiryJpaRepository;

    @BeforeEach
    void setup() {
        inquiryJpaRepository = mock(InquiryJpaRepository.class);
        inquiryRepository = new InquiryRepositoryImpl(inquiryJpaRepository);
    }

    @Nested
    @DisplayName("method : register")
    class Register {

        @Test
        @DisplayName("正常系: 例外なく処理が終了すること")
        void case1() {
            // テスト準備
            final AddInquiry addInquiry = AddInquiryMockBuilder.build();

            // 実施
            inquiryRepository.register(addInquiry);

            // 検証
            verify(inquiryJpaRepository, times(1))
                    .save(any(InquiryEntity.class));
        }
    }

    @Nested
    @DisplayName("method : update")
    class Update {

        private final UpdateInquiry updateInquiry = UpdateInquiryMockBuilder.build();
        private final InquiryEntity inquiryEntity = InquiryEntity.of(updateInquiry);

        @Test
        @DisplayName("正常系: 更新結果が存在する場合は1を返すこと")
        void case1() {
            // テスト準備
            final var entity = InquiryEntityMockBuilder.build();
            when(inquiryJpaRepository.findById(updateInquiry.getId()))
                    .thenReturn(Optional.of(entity));

            // 実施
            inquiryRepository.update(updateInquiry);

            // 検証
            verify(inquiryJpaRepository, times(1))
                    .save(inquiryEntity);
        }

        @Test
        @DisplayName("異常系: 更新結果が存在しない場合は例外が発生すること")
        void case2() {
            // テスト準備
            when(inquiryJpaRepository.findById(updateInquiry.getId()))
                    .thenReturn(Optional.empty());

            // 実施 & 検証
            Assertions.assertThrows(ResourceNotFoundException.class,
                    () -> inquiryRepository.update(updateInquiry));
        }
    }

    @Nested
    @DisplayName("method : findAll")
    class FindAll {

        private final List<Inquiry> inquiryList = InquiryMockBuilder.buildOfList();
        private final List<InquiryEntity> inquiryEntityList = inquiryList.stream()
                .map(InquiryEntity::of)
                .collect(Collectors.toList());

        @Test
        @DisplayName("正常系: お問合せリストが取得できること")
        void case1() {
            // テスト準備
            when(inquiryJpaRepository.findAll())
                    .thenReturn(inquiryEntityList);

            // 実施
            final var actual = inquiryRepository.findAll();

            // 検証
            Assertions.assertEquals(inquiryList, actual);
        }
    }

    @Nested
    @DisplayName("method : findById")
    class FindById {

        private final int id = 1;
        private final Inquiry inquiry = InquiryMockBuilder.build();
        private final InquiryEntity inquiryEntity = InquiryEntity.of(inquiry);

        @Test
        @DisplayName("正常系: IDを指定するとお問合せが取得できること")
        void case1() {
            // テスト準備
            when(inquiryJpaRepository.findById(id))
                    .thenReturn(Optional.of(inquiryEntity));

            // 実施
            final var actual = inquiryRepository.findById(id);

            // 検証
            Assertions.assertEquals(Optional.of(inquiry), actual);
        }
    }
}

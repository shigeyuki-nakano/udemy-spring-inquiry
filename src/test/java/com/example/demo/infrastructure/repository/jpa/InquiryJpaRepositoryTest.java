package com.example.demo.infrastructure.repository.jpa;

import com.example.demo.infrastructure.entity.InquiryEntity;
import com.example.demo.testtools.mockbuilder.domain.model.inquiry.AddInquiryMockBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class InquiryJpaRepositoryTest {

    @Nested
    @DataJpaTest
    @DisplayName("method : findById")
    class FindById {

        @Autowired
        private TestEntityManager entityManager;
        @Autowired
        private InquiryJpaRepository inquiryJpaRepository;

        @Test
        @DisplayName("正常系: 指定したIDを所有するレコードを取得できること")
        void case1() {
            // テスト準備
            final var id = 1;
            final var inquiryEntity = InquiryEntity.of(AddInquiryMockBuilder.build());
            entityManager.persist(inquiryEntity);

            // 実施
            final var actual = inquiryJpaRepository.findById(id).orElseThrow();

            // 検証
            Assertions.assertEquals(id, actual.getId());
            Assertions.assertEquals(inquiryEntity.getName(), actual.getName());
            Assertions.assertEquals(inquiryEntity.getEmail(), actual.getEmail());
            Assertions.assertEquals(inquiryEntity.getCreated(), actual.getCreated());
            Assertions.assertEquals(inquiryEntity.getContents(), actual.getContents());
        }
    }
}

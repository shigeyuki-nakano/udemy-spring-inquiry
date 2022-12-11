package com.example.demo.domain.model.inquiry;

import com.example.demo.presentation.entity.request.InquiryAddRequest;
import com.example.demo.testtools.mockbuilder.domain.model.inquiry.InquiryMockBuilder;
import com.example.demo.testtools.mockbuilder.presentation.entity.request.InquiryAddRequestMockBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class AddInquiryTest {

    @Nested
    @DisplayName("method : of")
    class Of {

        @Test
        @DisplayName("正常系: InquiryモデルからAddInquiryモデルに変換されること")
        void case1() {
            // テスト準備
            final var inquiry = InquiryMockBuilder.build();

            // 実施
            final var actual = AddInquiry.of(inquiry);

            // 検証
            verifyIfEquals(inquiry, actual);
        }

        @Test
        @DisplayName("正常系: InquiryAddRequestモデルからAddInquiryモデルに変換されること")
        void case2() {
            // テスト準備
            final var inquiryAddRequest = InquiryAddRequestMockBuilder.build();

            // 実施
            final var actual = AddInquiry.of(inquiryAddRequest);

            // 検証
            verifyIfEquals(inquiryAddRequest, actual);
        }

        /**
         * InquiryモデルとAddInquiryモデルの比較
         *
         * @param expected Inquiry
         * @param actual   AddInquiry
         */
        private void verifyIfEquals(Inquiry expected, AddInquiry actual) {
            Assertions.assertEquals(expected.getName(), actual.getName());
            Assertions.assertEquals(expected.getEmail(), actual.getEmail());
            Assertions.assertEquals(expected.getContents(), actual.getContents());
        }

        /**
         * InquiryAddRequestモデルとAddInquiryモデルの比較
         *
         * @param expected InquiryAddRequest
         * @param actual   AddInquiry
         */
        private void verifyIfEquals(InquiryAddRequest expected, AddInquiry actual) {
            Assertions.assertEquals(expected.getName(), actual.getName());
            Assertions.assertEquals(expected.getEmail(), actual.getEmail());
            Assertions.assertEquals(expected.getContents(), actual.getContents());
        }
    }
}

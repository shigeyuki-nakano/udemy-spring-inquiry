package com.example.demo.domain.model.inquiry;

import com.example.demo.presentation.entity.request.InquiryUpdateRequest;
import com.example.demo.testtools.mockbuilder.domain.model.inquiry.InquiryMockBuilder;
import com.example.demo.testtools.mockbuilder.presentation.entity.request.InquiryUpdateRequestMockBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class UpdateInquiryTest {

    @Nested
    @DisplayName("method : of")
    class Of {

        @Test
        @DisplayName("正常系: InquiryモデルからUpdateInquiryモデルに変換されること")
        void case1() {
            // テスト準備
            final var inquiry = InquiryMockBuilder.build();

            // 実施
            final var actual = UpdateInquiry.of(inquiry);

            // 検証
            verifyIfEquals(inquiry, actual);
        }

        @Test
        @DisplayName("正常系: InquiryAddRequestモデルからUpdateInquiryモデルに変換されること")
        void case2() {
            // テスト準備
            final var inquiryUpdateRequest = InquiryUpdateRequestMockBuilder.build();

            // 実施
            final var actual = UpdateInquiry.of(inquiryUpdateRequest);

            // 検証
            verifyIfEquals(inquiryUpdateRequest, actual);
        }

        /**
         * InquiryモデルとAddInquiryモデルの比較
         *
         * @param expected Inquiry
         * @param actual   AddInquiry
         */
        private void verifyIfEquals(Inquiry expected, UpdateInquiry actual) {
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
        private void verifyIfEquals(InquiryUpdateRequest expected, UpdateInquiry actual) {
            Assertions.assertEquals(expected.getName(), actual.getName());
            Assertions.assertEquals(expected.getEmail(), actual.getEmail());
            Assertions.assertEquals(expected.getContents(), actual.getContents());
        }
    }
}

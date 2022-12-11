package com.example.demo.testtools.mockbuilder.domain.model.inquiry;

import com.example.demo.domain.model.inquiry.UpdateInquiry;

public class UpdateInquiryMockBuilder {

    public static UpdateInquiry build() {
        return UpdateInquiry.builder()
                .id(1)
                .name("test")
                .email("test@test.com")
                .contents("contents")
                .build();
    }
}

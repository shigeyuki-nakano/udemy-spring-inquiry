package com.example.demo.testtools.mockbuilder.domain.model.inquiry;

import com.example.demo.domain.model.inquiry.AddInquiry;

public class AddInquiryMockBuilder {

    public static AddInquiry build() {
        return AddInquiry.builder()
                .name("test")
                .email("test@test.com")
                .contents("contents")
                .build();
    }
}

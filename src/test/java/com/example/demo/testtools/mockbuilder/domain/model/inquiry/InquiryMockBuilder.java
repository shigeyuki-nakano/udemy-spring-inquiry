package com.example.demo.testtools.mockbuilder.domain.model.inquiry;

import com.example.demo.domain.model.inquiry.Inquiry;

import java.time.LocalDateTime;

public class InquiryMockBuilder {

    public static Inquiry build() {
        return Inquiry.builder()
                .id(1)
                .name("test")
                .email("test@test.com")
                .contents("contents")
                .created(LocalDateTime.of(2022, 11, 11, 0, 0, 0))
                .build();
    }
}

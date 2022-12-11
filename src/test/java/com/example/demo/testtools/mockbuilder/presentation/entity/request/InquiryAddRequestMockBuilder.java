package com.example.demo.testtools.mockbuilder.presentation.entity.request;

import com.example.demo.presentation.entity.request.InquiryAddRequest;

public class InquiryAddRequestMockBuilder {

    public static InquiryAddRequest build() {
        return InquiryAddRequest.builder()
                .name("name")
                .email("email")
                .contents("contents")
                .build();
    }

    public static InquiryAddRequest buildEmpty() {
        return InquiryAddRequest.builder().build();
    }
}

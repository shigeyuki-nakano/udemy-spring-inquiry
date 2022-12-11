package com.example.demo.testtools.mockbuilder.presentation.entity.request;

import com.example.demo.presentation.entity.request.InquiryUpdateRequest;

public class InquiryUpdateRequestMockBuilder {

    public static InquiryUpdateRequest build() {
        return InquiryUpdateRequest.builder()
                .id(1)
                .name("name")
                .email("email")
                .contents("contents")
                .build();
    }

    public static InquiryUpdateRequest buildByIndex(int index) {
        return InquiryUpdateRequest.builder()
                .id(index)
                .name("name" + index)
                .email("email")
                .contents("contents")
                .build();
    }
}

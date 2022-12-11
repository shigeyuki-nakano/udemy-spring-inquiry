package com.example.demo.testtools.mockbuilder.infrastructure.entity;

import com.example.demo.infrastructure.entity.InquiryEntity;

import java.time.LocalDateTime;

public class InquiryEntityMockBuilder {

    public static InquiryEntity build() {
        return InquiryEntity.builder()
                .id(1)
                .name("mock name")
                .email("mock@test.com")
                .contents("mock contents")
                .created(LocalDateTime.of(2022, 11, 11, 0, 0, 0))
                .build();
    }
}

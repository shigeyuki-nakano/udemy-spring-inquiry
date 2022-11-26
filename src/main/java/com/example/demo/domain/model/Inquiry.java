package com.example.demo.domain.model;

import com.example.demo.presentation.entity.request.InquiryAddRequest;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

/**
 * お問合せモデル
 */
@Value
@Builder
public class Inquiry {

    int id;
    String name;
    String email;
    String contents;
    LocalDateTime created;

    public static Inquiry of(InquiryAddRequest inquiryAddRequest) {
        return Inquiry.builder()
                .name(inquiryAddRequest.getName())
                .email(inquiryAddRequest.getEmail())
                .contents(inquiryAddRequest.getContents())
                .build();
    }
}

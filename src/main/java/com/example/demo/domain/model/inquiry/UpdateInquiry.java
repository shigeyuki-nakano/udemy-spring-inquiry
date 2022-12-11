package com.example.demo.domain.model.inquiry;

import com.example.demo.presentation.entity.request.InquiryUpdateRequest;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateInquiry {

    int id;
    String name;
    String email;
    String contents;

    public static UpdateInquiry of(Inquiry inquiry) {
        return UpdateInquiry.builder()
                .id(inquiry.getId())
                .name(inquiry.getName())
                .email(inquiry.getEmail())
                .contents(inquiry.getContents())
                .build();
    }

    public static UpdateInquiry of(InquiryUpdateRequest inquiry) {
        return UpdateInquiry.builder()
                .id(inquiry.getId())
                .name(inquiry.getName())
                .email(inquiry.getEmail())
                .contents(inquiry.getContents())
                .build();
    }
}

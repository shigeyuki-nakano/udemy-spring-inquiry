package com.example.demo.domain.model.inquiry;

import com.example.demo.presentation.entity.request.InquiryAddRequest;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AddInquiry {

    String name;
    String email;
    String contents;

    public static AddInquiry of(Inquiry inquiry) {
        return AddInquiry.builder()
                .name(inquiry.getName())
                .email(inquiry.getEmail())
                .contents(inquiry.getContents())
                .build();
    }
    
    public static AddInquiry of(InquiryAddRequest inquiry) {
        return AddInquiry.builder()
                .name(inquiry.getName())
                .email(inquiry.getEmail())
                .contents(inquiry.getContents())
                .build();
    }
}

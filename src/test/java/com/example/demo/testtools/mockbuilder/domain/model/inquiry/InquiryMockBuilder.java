package com.example.demo.testtools.mockbuilder.domain.model.inquiry;

import com.example.demo.domain.model.inquiry.Inquiry;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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

    public static List<Inquiry> buildOfList() {
        return Arrays.asList(
                buildByIndex(1),
                buildByIndex(2),
                buildByIndex(3)
        );
    }

    public static Inquiry buildByIndex(int index) {
        return Inquiry.builder()
                .id(index)
                .name("test" + index)
                .email("test" + index + "@test.com")
                .contents("contents" + index)
                .created(LocalDateTime.of(2022, 11, 11, 0, 0, 0))
                .build();
    }
}

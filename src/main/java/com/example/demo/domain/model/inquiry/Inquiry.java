package com.example.demo.domain.model.inquiry;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;

/**
 * お問合せモデル
 */
@Value
@Builder
public class Inquiry {

    int id;
    @NonNull
    String name;
    @NonNull
    String email;
    @NonNull
    String contents;
    LocalDateTime created;
}

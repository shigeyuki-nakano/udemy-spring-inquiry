package com.example.demo.domain.model.inquiry;

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
}

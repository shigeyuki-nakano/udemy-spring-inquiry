package com.example.demo.domain.model.inquiry;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * お問合せモデル
 */
@Value
@Builder
public class Inquiry {

    int id;
    @NotNull
    String name;
    @NotNull
    String email;
    @NotNull
    String contents;
    LocalDateTime created;
}

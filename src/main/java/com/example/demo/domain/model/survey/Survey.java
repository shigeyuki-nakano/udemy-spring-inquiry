package com.example.demo.domain.model.survey;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * アンケートモデル
 */
@Value
@Builder
public class Survey {

    @NotNull
    int id;

    @NotNull
    int age;

    @NotNull
    int satisfaction;

    String comment;

    @NotNull
    LocalDateTime created;
}

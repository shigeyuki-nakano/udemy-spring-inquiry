package com.example.demo.domain.model.survey;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;

/**
 * アンケートモデル
 */
@Value
@Builder
public class Survey {

    Integer id;

    @NonNull int age;

    @NonNull SatisfactionLevels satisfaction;

    String comment;

    LocalDateTime created;
}

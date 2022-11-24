package com.example.demo.domain.model;

import com.example.demo.infrastructure.entity.SampleEntity;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Sample {

    Integer id;
    String name;

    public static Sample of(SampleEntity sampleEntity) {
        return Sample.builder()
                .id(sampleEntity.getId())
                .name(sampleEntity.getUsername())
                .build();
    }
}

package com.example.demo.infrastructure.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "TEST_TBL")
public class SampleEntity {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String username;
}

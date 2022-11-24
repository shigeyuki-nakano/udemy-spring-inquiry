package com.example.demo.infrastructure.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "TEST_TBL")
public class SampleEntity {

    @Id
    private Integer id;

    private String username;
}

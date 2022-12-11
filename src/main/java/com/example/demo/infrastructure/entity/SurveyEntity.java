package com.example.demo.infrastructure.entity;

import java.time.LocalDateTime;

public class SurveyEntity {

    private int id;
    private int age;
    private int satisfaction;
    private String comment;
    private LocalDateTime created;

    public SurveyEntity() {
    }

    public SurveyEntity(int id, int age, int satisfaction, String comment, LocalDateTime created) {
        super();
        this.id = id;
        this.age = age;
        this.satisfaction = satisfaction;
        this.comment = comment;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }


}

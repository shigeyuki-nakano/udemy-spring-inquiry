package com.example.demo.infrastructure.entity;

import com.example.demo.domain.model.Inquiry;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inquiry")
public class InquiryEntity {

    @Id
    private int id;
    private String name;
    private String email;
    private String contents;
    private LocalDateTime created;

    public Inquiry convert() {
        return Inquiry.builder()
                .id(id)
                .name(name)
                .contents(contents)
                .created(created)
                .build();
    }

    public static InquiryEntity of(Inquiry inquiry) {
        return InquiryEntity.builder()
                .id(inquiry.getId())
                .name(inquiry.getName())
                .contents(inquiry.getContents())
                .created(inquiry.getCreated())
                .email(inquiry.getEmail())
                .build();
    }
}

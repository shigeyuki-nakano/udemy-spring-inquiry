package com.example.demo.infrastructure.entity;

import com.example.demo.domain.model.inquiry.AddInquiry;
import com.example.demo.domain.model.inquiry.Inquiry;
import com.example.demo.domain.model.inquiry.UpdateInquiry;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String contents;
    private LocalDateTime created;

    public Inquiry convert() {
        return Inquiry.builder()
                .id(id)
                .name(name)
                .email(email)
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

    public static InquiryEntity of(AddInquiry inquiry) {
        return InquiryEntity.builder()
                .name(inquiry.getName())
                .email(inquiry.getEmail())
                .contents(inquiry.getContents())
                .build();
    }

    public static InquiryEntity of(UpdateInquiry inquiry) {
        return InquiryEntity.builder()
                .id(inquiry.getId())
                .name(inquiry.getName())
                .email(inquiry.getEmail())
                .contents(inquiry.getContents())
                .build();
    }
}

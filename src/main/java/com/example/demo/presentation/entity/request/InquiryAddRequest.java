package com.example.demo.presentation.entity.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InquiryAddRequest {

    @Size(min = 1, max = 20, message = "Please input 20 characters or less")
    private String name;
    @NotNull
    @Email(message = "Invalid E-mail Format")
    private String email;
    @NotNull
    private String contents;
}

package com.example.demo.domain.service;

import com.example.demo.infrastructure.entity.Inquiry;

import java.util.List;

public interface InquiryService {

    void save(Inquiry inquiry);

//  This is used in the latter chapter
//  こちらは後で使用
//	void update(Inquiry inquiry);

    List<Inquiry> getAll();

}

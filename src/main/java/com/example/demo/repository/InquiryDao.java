package com.example.demo.repository;

import com.example.demo.entity.Inquiry;

import java.util.List;

public interface InquiryDao {

    void insertInquiry(Inquiry inquiry);

//  This is used in the latter chapter
//  こちらは後で使用
//	int updateInquiry(Inquiry inquiry);

    List<Inquiry> getAll();
}
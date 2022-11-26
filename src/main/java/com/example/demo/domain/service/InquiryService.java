package com.example.demo.domain.service;

import com.example.demo.domain.model.Inquiry;

import java.util.List;

public interface InquiryService {

    /**
     * お問合せの保存を行う
     *
     * @param inquiry お問合せ内容
     */
    void save(Inquiry inquiry);

    /**
     * お問合せ内容の更新を行う
     *
     * @param inquiry お問合せ内容
     */
    void update(Inquiry inquiry);

    /**
     * 全お問合せ内容を取得する
     *
     * @return 前お問合せ内容
     */
    List<Inquiry> getAll();

}

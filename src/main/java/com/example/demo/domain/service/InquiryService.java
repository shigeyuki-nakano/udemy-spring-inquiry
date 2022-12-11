package com.example.demo.domain.service;

import com.example.demo.domain.model.inquiry.AddInquiry;
import com.example.demo.domain.model.inquiry.Inquiry;
import com.example.demo.domain.model.inquiry.UpdateInquiry;

import java.util.List;

/**
 * お問合せ関連ビジネスロジッククラス
 */
public interface InquiryService {

    /**
     * お問合せの保存を行う
     *
     * @param inquiry お問合せ内容
     */
    void save(AddInquiry inquiry);

    /**
     * お問合せ内容の更新を行う
     *
     * @param inquiry お問合せ内容
     */
    void update(UpdateInquiry inquiry);

    /**
     * 全お問合せ内容を取得する
     *
     * @return 全お問合せ内容
     */
    List<Inquiry> getAll();

    /**
     * 指定したIDのお問合せ内容を取得する
     *
     * @param id 取得したいお問合せ内容のID
     * @return お問合せ内容
     */
    Inquiry get(int id);

}

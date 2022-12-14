package com.example.demo.domain.repository;

import com.example.demo.domain.model.inquiry.AddInquiry;
import com.example.demo.domain.model.inquiry.Inquiry;
import com.example.demo.domain.model.inquiry.UpdateInquiry;

import java.util.List;
import java.util.Optional;

/**
 * お問合せデータ関連
 */
public interface InquiryRepository {

    /**
     * お問合せ内容の追加
     *
     * @param inquiry 対象のお問合せ内容
     */
    void insertInquiry(AddInquiry inquiry);

    /**
     * お問合せ内容の更新
     *
     * @param inquiry 対象のお問合せ内容
     * @return 更新した数
     */
    int updateInquiry(UpdateInquiry inquiry);

    /**
     * 保存してある全てのお問合せ内容を取得する
     *
     * @return 全てのお問合せ内容
     */
    List<Inquiry> getAll();

    /**
     * 指定されたIDのお問合せ内容を取得する
     *
     * @param id 取得したいお問合せ内容のID
     * @return お問合せ内容
     */
    Optional<Inquiry> getById(int id);
}

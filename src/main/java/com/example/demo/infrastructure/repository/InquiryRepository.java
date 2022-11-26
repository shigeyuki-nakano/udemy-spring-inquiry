package com.example.demo.infrastructure.repository;

import com.example.demo.domain.model.Inquiry;

import java.util.List;

/**
 * お問合せデータ関連
 */
public interface InquiryRepository {

    /**
     * お問合せ内容の追加
     *
     * @param inquiry 対象のお問合せ内容
     */
    void insertInquiry(Inquiry inquiry);

    /**
     * お問合せ内容の更新
     *
     * @param inquiry 対象のお問合せ内容
     * @return 更新した数
     */
    int updateInquiry(Inquiry inquiry);

    /**
     * 保存してある全てのお問合せ内容を取得する
     *
     * @return 全てのお問合せ内容
     */
    List<Inquiry> getAll();
}

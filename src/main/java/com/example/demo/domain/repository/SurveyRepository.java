package com.example.demo.domain.repository;

import com.example.demo.domain.model.survey.Survey;

import java.util.List;

public interface SurveyRepository {

    /**
     * アンケート一覧を取得する
     *
     * @return アンケート一覧
     */
    List<Survey> findAll();

    /**
     * 指定されたIDのアンケートを取得する
     *
     * @param id 取得したいアンケートのID
     * @return アンケート
     */
    Survey findById(int id);

    /**
     * 指定したアンケートを登録する
     *
     * @param survey 登録したいアンケート
     * @return 登録結果
     */
    void register(Survey survey);

    /**
     * 指定したアンケートを更新する
     *
     * @param survey 更新したいアンケート
     * @return 更新結果
     */
    void update(Survey survey);
}

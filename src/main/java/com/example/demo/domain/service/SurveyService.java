package com.example.demo.domain.service;

import com.example.demo.domain.model.survey.AddSurvey;
import com.example.demo.domain.model.survey.Survey;
import com.example.demo.domain.model.survey.UpdateSurvey;

import java.util.List;

public interface SurveyService {

    /**
     * アンケート一覧を取得する
     *
     * @return アンケート一覧
     */
    List<Survey> getAll();

    /**
     * 指定されたIDのアンケートを取得する
     *
     * @param id 取得したいアンケートのID
     * @return アンケート
     */
    Survey getById(int id);

    /**
     * 満足度の平均値を取得する
     *
     * @return 満足度平均値
     */
    int getSatisfactionAverage();

    /**
     * 指定したアンケートを登録する
     *
     * @param survey 登録したいアンケート
     * @return 登録結果
     */
    boolean register(AddSurvey survey);

    /**
     * 指定したアンケートを更新する
     *
     * @param survey 更新したいアンケート
     * @return 更新結果
     */
    boolean update(UpdateSurvey survey);
}

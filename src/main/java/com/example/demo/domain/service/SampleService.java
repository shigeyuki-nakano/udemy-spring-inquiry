package com.example.demo.domain.service;

import com.example.demo.domain.model.Sample;

import java.util.List;

/**
 * Sampleに関する処理を行うサービス
 */
public interface SampleService {

    /**
     * Sample一覧を取得する
     *
     * @return Sample一覧
     */
    public List<Sample> findAll();
}

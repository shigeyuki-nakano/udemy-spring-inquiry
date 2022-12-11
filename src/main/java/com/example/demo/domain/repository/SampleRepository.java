package com.example.demo.domain.repository;

import com.example.demo.domain.model.Sample;

import java.util.List;

/**
 * Sampleに関するDAO
 */
public interface SampleRepository {

    /**
     * Sample一覧を取得する
     *
     * @return Sample一覧
     */
    public List<Sample> findAll();
}

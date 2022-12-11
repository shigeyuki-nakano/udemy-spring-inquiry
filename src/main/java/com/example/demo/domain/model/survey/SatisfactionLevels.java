package com.example.demo.domain.model.survey;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 満足度モデル
 */
@Getter
@RequiredArgsConstructor
public enum SatisfactionLevels {

    // 少しも良くない
    NOT_AT_ALL_WELL(1),
    // 少し良い
    SLIGHTLY_WELL(2),
    // そこそこ良い
    MODERATELY_WELL(3),
    // とても良い
    VERY_WELL(4),
    // 極めて良い
    EXTREMELY_WELL(5);

    private final int id;

    @Override
    public String toString() {
        if (id == NOT_AT_ALL_WELL.id) {
            return "少しも良くない";
        } else if (id == SLIGHTLY_WELL.id) {
            return "少し良い";
        } else if (id == MODERATELY_WELL.id) {
            return "そこそこ良い";
        } else if (id == VERY_WELL.id) {
            return "とても良い";
        } else if (id == EXTREMELY_WELL.id) {
            return "極めて良い";
        }

        return "不明";
    }
}

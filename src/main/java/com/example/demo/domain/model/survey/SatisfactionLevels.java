package com.example.demo.domain.model.survey;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

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
    EXTREMELY_WELL(5),
    // 不明
    UNKNOWN(6);

    private final int id;

    public static SatisfactionLevels of(int id) {
        return Arrays.stream(SatisfactionLevels.values())
                .filter(satisfactionLevels -> satisfactionLevels.id == id)
                .findFirst()
                .orElse(SatisfactionLevels.UNKNOWN);
    }

    @Override
    public String toString() {
        final var idStr = "(" + id + ")";

        if (id == NOT_AT_ALL_WELL.id) {
            return "少しも良くない" + idStr;
        } else if (id == SLIGHTLY_WELL.id) {
            return "少し良い" + idStr;
        } else if (id == MODERATELY_WELL.id) {
            return "そこそこ良い" + idStr;
        } else if (id == VERY_WELL.id) {
            return "とても良い" + idStr;
        } else if (id == EXTREMELY_WELL.id) {
            return "極めて良い" + idStr;
        }

        return "不明";
    }
}

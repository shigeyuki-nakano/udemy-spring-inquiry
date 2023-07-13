package com.example.demo.infrastructure.repository;

import com.example.demo.domain.exception.ResourceNotFoundException;
import com.example.demo.domain.model.survey.SatisfactionLevels;
import com.example.demo.domain.model.survey.Survey;
import com.example.demo.infrastructure.entity.SurveyEntity;
import com.example.demo.infrastructure.repository.jpa.SurveyJpaRepository;
import com.example.demo.testtools.mockbuilder.domain.model.survey.SurveyMockBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SurveyRepositoryImplTest {

    private SurveyRepositoryImpl surveyRepository;
    private SurveyJpaRepository surveyJpaRepository;

    @BeforeEach
    void setup() {
        surveyJpaRepository = mock(SurveyJpaRepository.class);
        surveyRepository = new SurveyRepositoryImpl(surveyJpaRepository);
    }

    @Nested
    @DisplayName("method : register")
    class Register {

        @Test
        @DisplayName("正常系: 例外なく処理が終了すること")
        void case1() {
            // テスト準備
            final var survey = Survey.builder()
                    .age(20)
                    .satisfaction(SatisfactionLevels.EXTREMELY_WELL)
                    .comment("test")
                    .build();

            // 実施
            surveyRepository.register(survey);

            // 検証
            verify(surveyJpaRepository, times(1))
                    .save(any(SurveyEntity.class));
        }
    }

    @Nested
    @DisplayName("method : update")
    class Update {

        @Test
        @DisplayName("正常系: 更新結果が存在する場合は1を返すこと")
        void case1() {
            // テスト準備
            final var survey = build();
            when(surveyJpaRepository.findById(survey.getId()))
                    .thenReturn(Optional.of(SurveyEntity.of(survey)));

            // 実施
            surveyRepository.update(survey);

            // 検証
            verify(surveyJpaRepository, times(1))
                    .save(any(SurveyEntity.class));
        }

        @Test
        @DisplayName("異常系: 更新結果が存在しない場合は例外が発生すること")
        void case2() {
            // テスト準備
            final var survey = build();
            when(surveyJpaRepository.findById(survey.getId()))
                    .thenReturn(Optional.empty());

            // 実施 & 検証
            Assertions.assertThrows(ResourceNotFoundException.class,
                    () -> surveyRepository.update(survey));
        }

        private Survey build() {
            return Survey.builder()
                    .id(1)
                    .age(20)
                    .satisfaction(SatisfactionLevels.EXTREMELY_WELL)
                    .comment("test")
                    .build();
        }
    }

    @Nested
    @DisplayName("method : findAll")
    class FindAll {

        @Test
        @DisplayName("正常系: お問合せリストが取得できること")
        void case1() {
            // テスト準備
            final var surveyList = SurveyMockBuilder.buildOfList();
            final var surveyEntityList = surveyList.stream()
                    .map(survey -> SurveyEntity.builder()
                            .id(survey.getId())
                            .satisfaction(survey.getSatisfaction().getId())
                            .age(survey.getAge())
                            .comment(survey.getComment())
                            .created(survey.getCreated())
                            .build())
                    .collect(Collectors.toList());
            when(surveyJpaRepository.findAll())
                    .thenReturn(surveyEntityList);

            // 実施
            final var actual = surveyRepository.findAll();

            // 検証
            Assertions.assertEquals(surveyList, actual);
        }
    }

    @Nested
    @DisplayName("method : findById")
    class FindById {

        @Test
        @DisplayName("正常系: IDを指定するとお問合せが取得できること")
        void case1() {
            // テスト準備
            final var id = 1;
            final var survey = SurveyMockBuilder.build();
            final var surveyEntity = SurveyEntity.builder()
                    .id(survey.getId())
                    .age(survey.getAge())
                    .satisfaction(survey.getSatisfaction().getId())
                    .comment(survey.getComment())
                    .created(survey.getCreated())
                    .build();
            when(surveyJpaRepository.findById(id))
                    .thenReturn(Optional.of(surveyEntity));

            // 実施
            final var actual = surveyRepository.findById(id);

            // 検証
            Assertions.assertEquals(survey, actual);
        }

        @Test
        @DisplayName("異常系: 対象が見つからない場合、例外が発生すること")
        void case2() {
            // テスト準備
            final var id = 1;
            when(surveyJpaRepository.findById(id))
                    .thenReturn(Optional.empty());

            // 実施 & 検証
            Assertions.assertThrows(ResourceNotFoundException.class,
                    () -> surveyRepository.findById(id));
        }
    }
}

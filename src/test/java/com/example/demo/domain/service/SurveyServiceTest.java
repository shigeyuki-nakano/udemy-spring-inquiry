package com.example.demo.domain.service;

import com.example.demo.domain.model.survey.SatisfactionLevels;
import com.example.demo.domain.model.survey.Survey;
import com.example.demo.domain.repository.SurveyRepository;
import com.example.demo.testtools.mockbuilder.domain.model.survey.SurveyMockBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SurveyServiceTest {

    private SurveyService surveyService;
    private SurveyRepository surveyRepository;

    @BeforeEach
    void setUp() {
        surveyRepository = mock(SurveyRepository.class);
        surveyService = new SurveyService(surveyRepository);
    }

    @Nested
    @DisplayName("method : findAll")
    class FindAll {

        private List<Survey> surveyList;
        private List<Survey> emptySurveyList;

        @BeforeEach
        void setUp() {
            final var survey = SurveyMockBuilder.build();
            surveyList = Collections.singletonList(survey);
            emptySurveyList = Collections.emptyList();
        }

        @Test
        @DisplayName("正常系: " +
                "アンケート一覧取得処理が行われ、アンケート一覧を返却すること")
        void case1() {
            // テスト準備
            when(surveyRepository.findAll())
                    .thenReturn(surveyList);
            final var expected = surveyList;

            // 実施
            final var actual = surveyService.findAll();

            // 検証
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("method : findById")
    class FindById {

        private int id;
        private Survey survey;

        @BeforeEach
        void setUp() {
            id = 1;
            survey = SurveyMockBuilder.build();
        }

        @Test
        @DisplayName("正常系: " +
                "IDを指定し実行した場合、" +
                "IDを元にアンケート検索・取得処理が行われ、アンケートが返却されること")
        void case1() {
            // テスト準備
            when(surveyRepository.findById(id))
                    .thenReturn(survey);
            final var expected = survey;

            // 実施
            final var actual = surveyService.findById(id);

            // 検証
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("method : getSatisfactionAverage")
    class GetSatisfactionAverage {

        private List<Survey> surveyList;
        private List<Survey> emptySurveyList;

        @BeforeEach
        void setUp() {
            surveyList = SurveyMockBuilder.buildOfList();
            emptySurveyList = Collections.emptyList();
        }

        @Test
        @DisplayName("正常系: アンケート一覧取得処理が行われ、それを元に集計した平均満足度が返却されること")
        void case1() {
            // テスト準備
            when(surveyRepository.findAll())
                    .thenReturn(surveyList);
            final var expected = surveyList.stream()
                    .map(Survey::getSatisfaction)
                    .filter(satisfactionLevels -> !SatisfactionLevels.UNKNOWN.equals(satisfactionLevels))
                    .mapToInt(SatisfactionLevels::getId)
                    .average()
                    .orElse(0);

            // 実施
            final var actual = surveyService.getSatisfactionAverage();

            // 検証
            Assertions.assertEquals(expected, actual);
        }

        @Test
        @DisplayName("準正常系: アンケート一覧取得結果が空であった場合、0が返却されること")
        void case2() {
            // テスト準備
            when(surveyRepository.findAll())
                    .thenReturn(emptySurveyList);
            final var expected = 0;

            // 実施
            final var actual = surveyService.getSatisfactionAverage();

            // 検証
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("method : register")
    class Register {

        @Test
        @DisplayName("正常系: " +
                "登録対象のアンケートを指定し実行した場合、" +
                "アンケート登録処理が行われ、trueが返却されること")
        void case1() {
            // テスト準備
            final var survey = Survey.builder()
                    .age(20)
                    .satisfaction(SatisfactionLevels.EXTREMELY_WELL)
                    .comment("test")
                    .build();

            // 実施
            surveyService.register(survey);

            // 検証
            verify(surveyRepository, times(1))
                    .register(survey);
        }
    }

    @Nested
    @DisplayName("method : update")
    class Update {

        @Test
        @DisplayName("正常系: " +
                "更新対象のアンケートを指定しアンケート更新を実行した場合、" +
                "アンケート更新処理が行われ、trueが返却されること")
        void case1() {
            // テスト準備
            final var survey = Survey.builder()
                    .id(1)
                    .age(20)
                    .satisfaction(SatisfactionLevels.EXTREMELY_WELL)
                    .comment("test")
                    .build();

            // 実施
            surveyService.update(survey);

            // 検証
            verify(surveyRepository, times(1))
                    .update(survey);
        }
    }
}

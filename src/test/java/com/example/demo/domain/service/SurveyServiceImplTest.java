package com.example.demo.domain.service;

import com.example.demo.domain.exception.ResourceNotFoundException;
import com.example.demo.domain.model.survey.AddSurvey;
import com.example.demo.domain.model.survey.SatisfactionLevels;
import com.example.demo.domain.model.survey.Survey;
import com.example.demo.domain.model.survey.UpdateSurvey;
import com.example.demo.domain.repository.SurveyRepository;
import com.example.demo.testtools.mockbuilder.domain.model.survey.AddSurveyMockBuilder;
import com.example.demo.testtools.mockbuilder.domain.model.survey.SurveyMockBuilder;
import com.example.demo.testtools.mockbuilder.domain.model.survey.UpdateSurveyMockBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SurveyServiceImplTest {

    private SurveyService surveyService;
    private SurveyRepository surveyRepository;

    @BeforeEach
    void setUp() {
        surveyRepository = mock(SurveyRepository.class);
        surveyService = new SurveyServiceImpl(surveyRepository);
    }

    @Nested
    @DisplayName("method : getAll")
    class GetAll {

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
            when(surveyRepository.getAll())
                    .thenReturn(surveyList);
            final var expected = surveyList;

            // 実施
            final var actual = surveyService.getAll();

            // 検証
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("method : getById")
    class GetById {

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
            when(surveyRepository.getById(id))
                    .thenReturn(survey);
            final var expected = survey;

            // 実施
            final var actual = surveyService.getById(id);

            // 検証
            Assertions.assertEquals(expected, actual);
        }

        @Test
        @DisplayName("異常系: " +
                "指定したIDをもつアンケートが存在しなかった場合、" +
                "ResourceNotFoundExceptionが投げられること")
        void case2() {
            // テスト準備
            when(surveyRepository.getById(id))
                    .thenReturn(null);
            final var expectedMessage = "指定されたIDをもつアンケートが見つかりませんでした。 id : " + id;

            // 実施 & 検証
            final var actual = Assertions.assertThrows(ResourceNotFoundException.class,
                    () -> surveyService.getById(id));
            Assertions.assertEquals(expectedMessage, actual.getMessage());
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
            when(surveyRepository.getAll())
                    .thenReturn(surveyList);
            final var expected = SatisfactionLevels.EXTREMELY_WELL.getId();

            // 実施
            final var actual = surveyService.getSatisfactionAverage();

            // 検証
            Assertions.assertEquals(expected, actual);
        }

        @Test
        @DisplayName("準正常系: アンケート一覧取得結果が空であった場合、0が返却されること")
        void case2() {
            // テスト準備
            when(surveyRepository.getAll())
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

        private AddSurvey addSurvey;

        @BeforeEach
        void setUp() {
            addSurvey = AddSurveyMockBuilder.build();
        }

        @Test
        @DisplayName("正常系: " +
                "登録対象のアンケートを指定し実行した場合、" +
                "アンケート登録処理が行われ、trueが返却されること")
        void case1() {
            // テスト準備
            when(surveyRepository.register(addSurvey))
                    .thenReturn(true);

            // 実施
            final var actual = surveyService.register(addSurvey);

            // 検証
            Assertions.assertTrue(actual);
        }
    }

    @Nested
    @DisplayName("method : update")
    class Update {

        private UpdateSurvey updateSurvey;

        @BeforeEach
        void setUp() {
            updateSurvey = UpdateSurveyMockBuilder.build();
        }

        @Test
        @DisplayName("正常系: " +
                "更新対象のアンケートを指定しアンケート更新を実行した場合、" +
                "アンケート更新処理が行われ、trueが返却されること")
        void case1() {
            // テスト準備
            when(surveyRepository.update(updateSurvey))
                    .thenReturn(true);

            // 実施
            final var actual = surveyService.update(updateSurvey);

            // 検証
            Assertions.assertTrue(actual);
        }
    }
}

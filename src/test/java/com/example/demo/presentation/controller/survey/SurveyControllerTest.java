package com.example.demo.presentation.controller.survey;

import com.example.demo.domain.exception.ResourceNotFoundException;
import com.example.demo.domain.model.survey.SatisfactionLevels;
import com.example.demo.domain.model.survey.Survey;
import com.example.demo.domain.service.SurveyService;
import com.example.demo.presentation.config.WebMvcControllerAdvice;
import com.example.demo.presentation.entity.request.SurveyAddRequest;
import com.example.demo.presentation.entity.request.SurveyUpdateRequest;
import com.example.demo.testtools.mockbuilder.domain.model.survey.SurveyMockBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles({"test"})
class SurveyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SurveyService surveyService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        final var surveyController = new SurveyController(surveyService);
        mockMvc = MockMvcBuilders.standaloneSetup(surveyController)
                .setControllerAdvice(new WebMvcControllerAdvice())
                .build();
    }

    @Nested
    @DisplayName("method : index")
    class Index {

        private List<Survey> surveyList;
        private int satisfactionAverage;

        @BeforeEach
        void setUp() {
            surveyList = SurveyMockBuilder.buildOfList();
            satisfactionAverage = 5;
        }

        @Test
        @DisplayName("正常系: " +
                "GETアクセスした場合、" +
                "アンケート一覧取得結果を格納したモデルと満足度平均取得結果を格納したモデルが作成され、" +
                "アンケート一覧ページが返却されること")
        void case1() throws Exception {
            // テスト準備
            when(surveyService.getAll())
                    .thenReturn(surveyList);
            when(surveyService.getSatisfactionAverage())
                    .thenReturn(satisfactionAverage);

            // 実施
            final var actual = mockMvc.perform(MockMvcRequestBuilders.get("/survey"));

            // 検証
            actual
                    .andExpect(status().isOk())
                    .andExpect(view().name("survey/index"))
                    .andExpect(model().attribute("surveyList", surveyList))
                    .andExpect(model().attribute("title", "アンケートページ"))
                    .andExpect(model().attribute("average", satisfactionAverage));
        }
    }

    @Nested
    @DisplayName("method : form")
    class Form {

        private String templatePath;
        private String basePath;

        @BeforeEach
        void setUp() {
            templatePath = "survey/form/index";
            basePath = "/survey/form";
        }

        @Test
        @DisplayName("正常系: GETアクセスした場合、アンケート登録ページの取得ができること")
        void case1() throws Exception {
            // テスト準備
            final var surveyAddRequest = new SurveyAddRequest();

            // 実施
            final var actual = mockMvc.perform(MockMvcRequestBuilders.get(basePath));

            // 検証
            actual
                    .andExpect(status().isOk())
                    .andExpect(view().name(templatePath))
                    .andExpect(model().attribute("title", "アンケート記入ページ"))
                    .andExpect(model().attribute("isComplete", false))
                    .andExpect(model().attribute("surveyAddRequest", surveyAddRequest));
        }
    }

    @Nested
    @DisplayName("method : formGoBack")
    class FormGoBack {

        private String templatePath;
        private String basePath;

        @BeforeEach
        void setUp() {
            templatePath = "survey/form/index";
            basePath = "/survey/form";
        }

        @Test
        @DisplayName("正常系: " +
                "アンケートデータをPOSTした場合、" +
                "アンケート登録内容を格納したモデルが作成され、アンケート登録ページの取得ができること")
        void case1() throws Exception {
            // テスト準備
            final var surveyAddRequest = SurveyAddRequest.builder()
                    .age(20)
                    .satisfaction(SatisfactionLevels.MODERATELY_WELL.getId())
                    .comment("comment")
                    .build();

            // 実施
            final var actual = mockMvc.perform(
                    MockMvcRequestBuilders.post(basePath)
                            .param("age", String.valueOf(surveyAddRequest.getAge()))
                            .param("satisfaction", String.valueOf(surveyAddRequest.getSatisfaction()))
                            .param("comment", surveyAddRequest.getComment()));

            // 検証
            actual
                    .andExpect(status().isOk())
                    .andExpect(view().name(templatePath))
                    .andExpect(model().attribute("title", "アンケート記入ページ"))
                    .andExpect(model().attribute("isComplete", false))
                    .andExpect(model().attribute("surveyAddRequest", surveyAddRequest));
        }

    }

    @Nested
    @DisplayName("method : updateForm")
    class UpdateForm {

        private String templatePath;
        private String errorTemplatePath;
        private String basePath;
        private int id;
        private String path;

        @BeforeEach
        void setUp() {
            templatePath = "survey/form/update";
            errorTemplatePath = "error/404";
            basePath = "/survey/form";
            id = 1;
            path = basePath + "/" + id;
        }

        @Test
        @DisplayName("正常系: " +
                "IDを含んだパスにGETした場合、" +
                "IDを元に取得されたアンケートを格納したモデルが作成され、" +
                "アンケート登録ページの取得ができること")
        void case1() throws Exception {
            // テスト準備
            final var survey = SurveyMockBuilder.buildByIndex(id);
            when(surveyService.getById(id))
                    .thenReturn(survey);
            final var surveyUpdateRequest = SurveyUpdateRequest.of(survey);

            // 実施
            final var actual = mockMvc.perform(MockMvcRequestBuilders.get(path));

            // 検証
            actual
                    .andExpect(status().isOk())
                    .andExpect(view().name(templatePath))
                    .andExpect(model().attribute("title", "アンケート記入ページ"))
                    .andExpect(model().attribute("isComplete", false))
                    .andExpect(model().attribute("surveyUpdateRequest", surveyUpdateRequest));
        }

        @Test
        @DisplayName("異常系: " +
                "IDを含んだパスにGETしたがアンケートが見つからなかった場合、404ページを返却すること")
        void case2() throws Exception {
            // テスト準備
            when(surveyService.getById(id))
                    .thenThrow(ResourceNotFoundException.class);

            // 実施
            final var actual = mockMvc.perform(MockMvcRequestBuilders.get(path));

            // 検証
            actual
                    .andExpect(status().isOk())
                    .andExpect(view().name(errorTemplatePath));
        }
    }
}

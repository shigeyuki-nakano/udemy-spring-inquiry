package com.example.demo.presentation.controller.inquiry;

import com.example.demo.domain.service.InquiryService;
import com.example.demo.presentation.config.WebMvcControllerAdvice;
import com.example.demo.testtools.mockbuilder.domain.model.inquiry.InquiryMockBuilder;
import com.example.demo.testtools.mockbuilder.presentation.entity.request.InquiryAddRequestMockBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class InquiryControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private InquiryService inquiryService;

    @BeforeEach
    void setup() {
        final var inquiryController = new InquiryController(inquiryService);
        mockMvc = MockMvcBuilders.standaloneSetup(inquiryController)
                .setControllerAdvice(new WebMvcControllerAdvice())
                .build();
    }

    @Nested
    @DisplayName("method : index")
    class Index {

        @Test
        @DisplayName("?????????: " +
                "????????????????????????????????????????????????get???????????????????????????" +
                "????????????????????????????????????????????????")
        void case1() throws Exception {
            // ???????????????
            final var inquiryList = Collections.singletonList(InquiryMockBuilder.build());
            when(inquiryService.getAll())
                    .thenReturn(inquiryList);


            // ??????
            final var actual = mockMvc.perform(MockMvcRequestBuilders.get("/inquiry"));

            // ??????
            actual
                    .andExpect(status().isOk())
                    .andExpect(view().name("inquiry/index"))
                    .andExpect(model().attribute("title", "????????????"))
                    .andExpect(model().attribute("inquiryList", inquiryList));
        }
    }

    @Nested
    @DisplayName("method : form")
    class Form {

        @Test
        @DisplayName("?????????: " +
                "????????????????????????????????????????????????get???????????????????????????" +
                "??????????????????????????????????????????????????????")
        void case1() throws Exception {
            // ???????????????
            final var inquiryAddRequest = InquiryAddRequestMockBuilder.buildEmpty();

            // ??????
            final var actual = mockMvc.perform(MockMvcRequestBuilders.get("/inquiry/form"));

            // ??????
            actual
                    .andExpect(status().isOk())
                    .andExpect(view().name("inquiry/form/index"))
                    .andExpect(model().attribute("inquiryAddRequest", inquiryAddRequest))
                    .andExpect(model().attribute("title", "????????????"));
        }
    }
}

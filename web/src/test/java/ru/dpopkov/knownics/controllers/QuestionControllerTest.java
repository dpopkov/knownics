package ru.dpopkov.knownics.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.dpopkov.knownics.services.QuestionService;

import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class QuestionControllerTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    QuestionController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testList() throws Exception {
        mockMvc.perform(get("/question/list"))
                .andExpect(model().attributeExists("questions"))
                .andExpect(view().name("questions/list"))
                .andExpect(status().isOk());
        then(questionService).should().findAll();
    }
}

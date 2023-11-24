package com.bysix.labseq.controller;

import com.bysix.labseq.service.LabseqService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LabseqController.class)
class LabseqControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LabseqService labseqService;

    @Test
    @DisplayName("getLabseq should return ok when input is zero")
    void getLabseq_ShouldReturnOk_WhenInputIsZero() throws Exception {
        mockMvc.perform(get("/labseq/0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
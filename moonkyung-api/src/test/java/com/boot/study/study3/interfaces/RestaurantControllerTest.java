package com.boot.study.study3.interfaces;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest
class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void 리스트읽기() {
        try {
            mvc.perform(get("/restaurants"))
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("\"id\":109")))
                    .andExpect(content().string(containsString("\"name\":\"충내")))
                    .andExpect(content().string(containsString("\"address\":\"서초구")))
                    .andExpect(content().string(containsString("\"information\":\"커염둥이임")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void detail() {
        try {
            mvc.perform(get("/restaurants/109"))
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("\"id\":109")))
                    .andExpect(content().string(containsString("\"name\":\"충내")));
            mvc.perform(get("/restaurants/101"))
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("\"id\":101")))
                    .andExpect(content().string(containsString("\"name\":\"승균")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
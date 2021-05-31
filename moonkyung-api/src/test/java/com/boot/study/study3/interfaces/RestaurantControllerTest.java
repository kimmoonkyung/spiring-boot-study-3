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
                    .andExpect(content().string(containsString("커염둥이승내")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
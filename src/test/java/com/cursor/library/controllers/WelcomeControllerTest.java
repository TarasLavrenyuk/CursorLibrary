package com.cursor.library.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class WelcomeControllerTest extends BaseControllerTest {

    @Test
    public void test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/helloworld"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }
}

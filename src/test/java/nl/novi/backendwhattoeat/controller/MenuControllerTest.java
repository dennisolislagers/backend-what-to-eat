package nl.novi.backendwhattoeat.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class MenuControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldRetrieveCorrectOrder() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/menus/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("menu" + 1)));
    }

    private String containsString(String s) {
        return null;
    }
}

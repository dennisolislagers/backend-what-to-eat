package nl.novi.backendwhattoeat.controller;

import nl.novi.backendwhattoeat.controllers.MenuController;
import nl.novi.backendwhattoeat.dtos.MenuDto;
import nl.novi.backendwhattoeat.security.JwtService;
import nl.novi.backendwhattoeat.services.MenuService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static java.lang.Boolean.*;
import static org.hamcrest.Matchers.is;

@WebMvcTest (MenuController.class)
class MenuControllerMvcTest {
    
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    MenuService menuService;
//
//    @MockBean
//    JwtService jwtService;
//
//    @Test
//    @WithMockUser(roles="ADMIN")
//    void getMenu() throws Exception {

//        MenuDto md = new MenuDto();
//                md.id =  1L;
//                md.title = "sajoer boontjes";
//                md.portions = 4;
//                md.calories = 850;
//                md.cuisineType = "asian";
//                md.mealType = "dinner";
//                md.dishType = "side dish";
//                md.vegan = TRUE;
//                md.peanutAllergy = FALSE;
//                md.cowmilkAllergy = FALSE;
//                md.glutenAllergy = FALSE;
//
//                Mockito.when(menuService.getMenuById(1L)).thenReturn(md);
//
//
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders.get("/menus/1"))
//                        .andDo(MockMvcResultHandlers.print())
//                        .andExpect(MockMvcResultMatchers.status().isOk())
//                        .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
//                        .andExpect(MockMvcResultMatchers.jsonPath("$.title", is("sajoer boontjes")))
//                        .andExpect(MockMvcResultMatchers.jsonPath("$.portions", is(4)))
//                        .andExpect(MockMvcResultMatchers.jsonPath("$.calories", is(850)))
//                        .andExpect(MockMvcResultMatchers.jsonPath("$.cuisineType", is("asian")))
//                        .andExpect(MockMvcResultMatchers.jsonPath("$.mealType", is("dinner")))
//                        .andExpect(MockMvcResultMatchers.jsonPath("$.dishType", is("side dish")))
//                        .andExpect(MockMvcResultMatchers.jsonPath("$.vegan", is(TRUE)))
//                        .andExpect(MockMvcResultMatchers.jsonPath("$.peanutAllergy", is(TRUE)))
//                        .andExpect(MockMvcResultMatchers.jsonPath("$.cowmilkAllergy", is(TRUE)))
//                        .andExpect(MockMvcResultMatchers.jsonPath("$.glutenAlleregy", is(TRUE)));
//    }
}
package com.spider.vote.web;

import com.spider.vote.repository.AbstractTestClass;
import org.junit.Test;
import org.springframework.http.MediaType;

import static com.spider.vote.repository.testdata.RestaurantTestData.JSON_LIST_RESTAURANT;
import static com.spider.vote.web.AdminRestController.ADMIN_REST_URL;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AdminRestControllerTest extends AbstractTestClass {

    /*@Test
    public void getAllRestaurants() throws Exception {
        mockMvc.perform(get(ADMIN_REST_URL+"/restaurants"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(JSON_LIST_RESTAURANT));
    }*/

    @Test
    public void saveUser() throws Exception {



    }

    @Test
    public void getAllUsers() throws Exception {
    }

    @Test
    public void getByEmail() throws Exception {
    }

    @Test
    public void deleteUserWithId() throws Exception {
    }

    @Test
    public void updateUser() throws Exception {
    }

    @Test
    public void saveMenu() throws Exception {
    }

    @Test
    public void deleteMenu() throws Exception {
    }

    @Test
    public void findMenusByRestaurant() throws Exception {
    }

    @Test
    public void getMenuByDate() throws Exception {
    }

    @Test
    public void getAllMenus() throws Exception {
    }

    @Test
    public void saveMeal() throws Exception {
    }

    @Test
    public void deleteMeal() throws Exception {
    }

    @Test
    public void getAllMealsInMenu() throws Exception {
    }

    @Test
    public void updateMeal() throws Exception {
    }

    @Test
    public void saveMeal1() throws Exception {
    }

    @Test
    public void updateVote() throws Exception {
    }

    @Test
    public void getVoteByUserAndDate() throws Exception {
    }

}
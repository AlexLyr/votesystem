package com.spider.vote.repository;


import com.spider.vote.domain.entity.Menu;
import com.spider.vote.service.interfaces.MenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static com.spider.vote.repository.testdata.MenuTestData.*;
import static com.spider.vote.repository.testdata.RestaurantTestData.RESTAURANT_102;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class MenuServiceTest extends AbstractTestClass {

    @Autowired
    private MenuService service;

    @Test
    public void testDeleteById() {
        service.deleteMenuById(107);
        assertThat(service.getAllMenu(), hasSize(5));
    }

    @Test
    public void testSaveMenu() {
        Menu menu = service.saveMenu(NEW_MENU);
        List<Menu> menus = service.getAllMenu();
        menus.forEach(System.out::println);
        List<Menu> list = Arrays.asList(MENU_1, MENU_2, MENU_3, MENU_4, MENU_5, MENU_6, NEW_MENU);
        for (int i = 0; i < list.size(); i++) {
            assertThat(list.get(i), samePropertyValuesAs(menus.get(i)));
        }
    }

    @Test
    public void testGetMenuByRest() {
        List<Menu> menus = service.findMenuByRestaurant(RESTAURANT_102);
        List<Menu> list = Arrays.asList(MENU_2, MENU_1);
        for (int i = 0; i < list.size(); i++) {
            assertThat(list.get(i), samePropertyValuesAs(menus.get(i)));
        }
    }

    @Test
    public void testGetMenuByDate() {
        List<Menu> menus = service.findMenuByDate(LocalDate.of(2017, 10, 23));
        List<Menu> list = Arrays.asList(MENU_1, MENU_3, MENU_5);
        for (int i = 0; i < list.size(); i++) {
            assertThat(list.get(i), samePropertyValuesAs(menus.get(i)));
        }
    }
}

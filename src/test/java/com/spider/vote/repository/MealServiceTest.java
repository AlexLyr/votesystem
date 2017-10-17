package com.spider.vote.repository;


import com.spider.vote.domain.base.NamedEntity;
import com.spider.vote.domain.entity.Meal;
import com.spider.vote.service.interfaces.MealService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.spider.vote.repository.testdata.MealTestData.*;
import static com.spider.vote.repository.testdata.MenuTestData.MENU_1;
import static com.spider.vote.repository.testdata.MenuTestData.MENU_2;
import static com.spider.vote.repository.testdata.MenuTestData.MENU_6;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class MealServiceTest extends AbstractTestClass {

    @Autowired
    private MealService service;

    @Test
    public void testGetAllMealInMenu(){
        List<Meal> meals= service.getAllMealInMenu(MENU_1);
        for (int i = 0; i < 2; i++) {
            assertThat(MEAL_LIST.get(i), samePropertyValuesAs(meals.get(i)));
        }
    }

    @Test
    public void deleteMeal(){
         service.deleteMeal(112);
        List<Meal> meals= service.getAllMealInMenu(MENU_1);
        assertThat(meals, hasSize(1));
    }

    @Test
    public void saveMeal(){
        service.saveMeal(NEW_MEAL);
        List<Meal> meals= service.getAllMealInMenu(MENU_1);
        meals.forEach(System.out::println);
        List<Meal> list=Arrays.asList(NEW_MEAL, MEAL_2, MEAL_1).stream()
                .sorted(Comparator.comparing(NamedEntity::getName))
                .collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            assertThat(list.get(i), samePropertyValuesAs(meals.get(i)));
        }
    }

    @Test
    public void updateMeal(){
        service.update(UPD_MEAL);
        List<Meal> meals= service.getAllMealInMenu(MENU_6);
        meals.forEach(System.out::println);
        List<Meal> list=Arrays.asList(MEAL_11,MEAL_12,UPD_MEAL).stream()
                .sorted(Comparator.comparing(NamedEntity::getName))
                .collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            assertThat(list.get(i), samePropertyValuesAs(meals.get(i)));
        }
    }
}

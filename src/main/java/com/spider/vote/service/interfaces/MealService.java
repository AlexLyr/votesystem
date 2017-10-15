package com.spider.vote.service.interfaces;


import com.spider.vote.domain.entity.Meal;
import com.spider.vote.domain.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MealService {

     void deleteMeal(int id);

    Meal saveMeal(Meal meal);

    void update(Meal meal);

    List<Meal> getAllMealInMenu(Menu menu);

}

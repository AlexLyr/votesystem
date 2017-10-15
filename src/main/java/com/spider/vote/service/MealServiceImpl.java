package com.spider.vote.service;


import com.spider.vote.domain.entity.Meal;
import com.spider.vote.domain.entity.Menu;
import com.spider.vote.repository.MealRepository;
import com.spider.vote.service.interfaces.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class MealServiceImpl implements MealService{

    @Autowired
    private MealRepository repository;

    @Override
    public void deleteMeal(int id) {
        repository.delete(id);
    }

    @Override
    public Meal saveMeal(Meal meal) {
        Assert.notNull(meal, "user must not be null");
        return repository.save(meal);
    }

    @Override
    public void update(Meal meal) {
        Assert.notNull(meal, "user must not be null");
        repository.save(meal);
    }

    @Override
    public List<Meal> getAllMealInMenu(Menu menu) {
        return repository.getAllMealsInMenu(menu);
    }
}

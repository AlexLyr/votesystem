package com.spider.vote.repository;


import com.spider.vote.domain.entity.Meal;
import com.spider.vote.domain.entity.Menu;
import com.spider.vote.repository.crudrepositories.CrudMealDataJpa;
import com.spider.vote.utils.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.spider.vote.utils.ValidationUtil.checkNotFoundWithId;

@Repository
public class MealRepository {

    @Autowired
   private CrudMealDataJpa crudRepository;

    public List<Meal> getAllMealsInMenu(Menu menu) {
        return crudRepository.findAllMealsByMenu(menu);
    }

   /* public Meal getMealById(int id) {
        return crudRepository.findMealById(id);
    }*/


    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(crudRepository.deleteMealById(id), id);
    }
    public Meal save(Meal meal) {
        return crudRepository.save(meal);
    }
}

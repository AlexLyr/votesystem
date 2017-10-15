package com.spider.vote.repository.crudrepositories;


import com.spider.vote.domain.entity.Meal;
import com.spider.vote.domain.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Transactional(readOnly = true)
public interface CrudMealDataJpa extends JpaRepository<Meal, Integer> {


    @Transactional
    @Modifying
    int deleteMealById(int id);

    @Transactional
    Meal save(Meal meal);

    Meal findMealById(int id);

    List<Meal> findAllMealsByMenu(Menu menu);
}

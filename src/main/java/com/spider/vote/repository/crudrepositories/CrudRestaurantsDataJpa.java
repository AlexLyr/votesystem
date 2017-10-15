package com.spider.vote.repository.crudrepositories;


import com.spider.vote.domain.entity.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;



@Transactional(readOnly = true)
public interface CrudRestaurantsDataJpa extends JpaRepository<Restaurant, Integer> {

    @Transactional
    @Modifying
    int deleteRestaurantById(int id);

    Restaurant getRestaurantByName(String name);

    @Transactional
    Restaurant save(Restaurant restaurant);

    Restaurant getRestaurantById(int id);

}

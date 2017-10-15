package com.spider.vote.repository;


import com.spider.vote.domain.entity.Restaurant;
import com.spider.vote.repository.crudrepositories.CrudRestaurantsDataJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.spider.vote.utils.ValidationUtil.checkNotFound;
import static com.spider.vote.utils.ValidationUtil.checkNotFoundWithId;


@Repository
public class RestaurantRepository {

    @Autowired
    private CrudRestaurantsDataJpa crudRepository;

    public void deleteRestaurant(int id){
        checkNotFoundWithId(crudRepository.deleteRestaurantById(id),id);
    }

    public Restaurant getRestarauntByName(String name){
        return checkNotFound(crudRepository.getRestaurantByName(name),name);
    }

    public Restaurant getRestarauntById(int id){
        return checkNotFoundWithId(crudRepository.getRestaurantById(id),id);
    }

    public Restaurant saveRestaurant(Restaurant restaurant){
        return crudRepository.save(restaurant);
    }

}

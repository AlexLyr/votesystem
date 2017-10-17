package com.spider.vote.service.interfaces;


import com.spider.vote.domain.entity.Restaurant;

import java.util.List;

public interface RestaurantService {

    void deleteRestaurantById(int id);

    Restaurant getRestaurantByName(String name);

    Restaurant getRestaurantById(int id);

    Restaurant saveRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();
}

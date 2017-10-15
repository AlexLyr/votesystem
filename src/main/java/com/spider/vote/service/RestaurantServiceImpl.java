package com.spider.vote.service;


import com.spider.vote.domain.entity.Restaurant;
import com.spider.vote.repository.RestaurantRepository;
import com.spider.vote.service.interfaces.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    RestaurantRepository repository;

    @Override
    public void deleteRestaurantById(int id) {
        repository.deleteRestaurant(id);
    }

    @Override
    public Restaurant getRestaurantByName(String name) {
        Assert.notNull(name,"name must be not null");
        return repository.getRestarauntByName(name);
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        Assert.notNull(id,"id must be not null");
        return repository.getRestarauntById(id);
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return repository.saveRestaurant(restaurant);
    }
}

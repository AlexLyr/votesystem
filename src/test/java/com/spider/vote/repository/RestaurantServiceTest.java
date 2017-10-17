package com.spider.vote.repository;


import com.spider.vote.domain.entity.Restaurant;
import com.spider.vote.service.interfaces.RestaurantService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static com.spider.vote.repository.testdata.RestaurantTestData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class RestaurantServiceTest extends AbstractTestClass {

    @Autowired
    private RestaurantService service;

    @Test
    public void testGetAllRestaurants(){
        List<Restaurant> restaurants = service.getAllRestaurants();
        restaurants.forEach(System.out::println);
        List<Restaurant> list= Arrays.asList(RESTAURANT_102,RESTAURANT_103,RESTAURANT_104);
        for(int i=0;i<list.size();i++){
            assertThat(list.get(i), samePropertyValuesAs(restaurants.get(i)));
        }
    }

    @Test
    public void testGetRestByName(){
        Restaurant restaurant=service.getRestaurantByName("KFC");
        assertThat(restaurant,samePropertyValuesAs(RESTAURANT_102));
    }

    @Test
    public void testDeleteRest(){
        service.deleteRestaurantById(102);
        assertThat(service.getAllRestaurants(), hasSize(2));
    }

    @Test
    public void testSaveRest(){
        service.saveRestaurant(NEW_RESTAURANT);
        List<Restaurant> restaurants = service.getAllRestaurants();
        restaurants.forEach(System.out::println);
        List<Restaurant> list= Arrays.asList(RESTAURANT_102,RESTAURANT_103,RESTAURANT_104,NEW_RESTAURANT);
        for(int i=0;i<list.size();i++){
            assertThat(list.get(i), samePropertyValuesAs(restaurants.get(i)));
        }
    }

    @Test
    public void testGetRestById(){
        Restaurant restaurant=service.getRestaurantById(102);
        assertThat(restaurant,samePropertyValuesAs(RESTAURANT_102));
    }


}

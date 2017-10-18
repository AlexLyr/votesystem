package com.spider.vote.repository.testdata;


import com.spider.vote.domain.entity.Restaurant;
import com.spider.vote.utils.json.JsonUtil;

import java.util.Arrays;

public class RestaurantTestData {

    public static final Restaurant RESTAURANT_102=new Restaurant(102,"KFC");
    public static final Restaurant RESTAURANT_103=new Restaurant(103,"Баклажан");
    public static final Restaurant RESTAURANT_104=new Restaurant(104,"Столовая");
    public static final Restaurant NEW_RESTAURANT=new Restaurant("McDonalds");
    public static final String JSON_RESTAURANT= JsonUtil.writeValue(NEW_RESTAURANT);

    public static final String JSON_LIST_RESTAURANT=JsonUtil.writeValue(Arrays.asList(RESTAURANT_102,RESTAURANT_103,RESTAURANT_104));
}

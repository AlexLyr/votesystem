package com.spider.vote.to;

import com.spider.vote.web.HasId;

import java.io.Serializable;

public class MealTo implements Serializable, HasId {

    private static final long serialVersionUID = 1L;

    private Integer id;


    private String name;


    private Integer price;


    private Integer restaurantId;

    public MealTo() {

    }

    public MealTo(Integer id, String name, int price, int restaurantId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "MealTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", restaurantId=" + restaurantId +
                '}';
    }
}

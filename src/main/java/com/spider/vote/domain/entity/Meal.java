package com.spider.vote.domain.entity;


import com.spider.vote.domain.base.NamedEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="meals",uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_id", "name"}, name = "unique_meal")})
public class Meal extends NamedEntity {

    @Column(name = "price",nullable = false)
    private double price;


    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "menu_id", nullable = false)
    @NotNull
    private Menu menu;

    public Meal() {
    }

    public Meal(String description, double price){
        this(null,description,price);
    }

    public Meal(Integer id, String description, double price) {
        super(id,description);
        this.price = price;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Lunch (" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", price=" + price +
                ')';
    }
}

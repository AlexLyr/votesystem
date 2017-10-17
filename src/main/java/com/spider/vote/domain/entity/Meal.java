package com.spider.vote.domain.entity;


import com.spider.vote.domain.base.NamedEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@NamedEntityGraph(name = "meals_graph",
        attributeNodes = {@NamedAttributeNode(value = "menu", subgraph = "menus")},
        subgraphs = @NamedSubgraph(name = "menus", attributeNodes = @NamedAttributeNode("restaurant")))
@Table(name = "meals", uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_id", "name"}, name = "unique_meal")})
public class Meal extends NamedEntity {

    @Column(name = "price", nullable = false)
    private double price;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Menu menu;

    public Meal() {
    }

    public Meal(String description, double price,Menu menu) {
        this(null, description, price,menu);
    }


    public Meal(Integer id, String description, double price) {
        super(id, description);
        this.price = price;
    }

    public Meal(Integer id, String description, double price, Menu menu) {
        super(id, description);
        this.price = price;
        this.menu = menu;
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
        return "Meal{" +
                "id"+getId()+'\''+
                "name='" + name + '\'' +
                ", price=" + price +
                ", menu=" + menu +
                '}';
    }
}

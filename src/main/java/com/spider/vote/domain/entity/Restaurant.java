package com.spider.vote.domain.entity;

import com.spider.vote.domain.base.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "unique_restaurant")})
public class Restaurant extends NamedEntity {


    public Restaurant(){}

    public Restaurant(String name){
        this(null,name);
    }

    public Restaurant(Integer id, String name){
        super(id,name);
    }

    @Override
    public String toString() {
        return "Restaurant (" +
                "id=" + getId() +
                ", name=" + name +
                ')';
    }

}

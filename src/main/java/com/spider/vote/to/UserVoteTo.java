package com.spider.vote.to;

import com.spider.vote.domain.entity.Restaurant;
import com.spider.vote.domain.entity.User;
import com.spider.vote.web.HasId;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class UserVoteTo implements Serializable, HasId {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private LocalDateTime dateTime;

    public Restaurant getChosenRestaurant() {
        return chosenRestaurant;
    }

    public void setChosenRestaurant(Restaurant chosenRestaurant) {
        this.chosenRestaurant = chosenRestaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private Restaurant chosenRestaurant;


    private User user;

    public UserVoteTo(LocalDateTime dateTime, Restaurant chosenRestaurant, User user) {
        this(null, dateTime, chosenRestaurant, user);
    }

    public UserVoteTo() {

    }

    public UserVoteTo(Integer id, LocalDateTime dateTime, Restaurant chosenRestaurant, User user) {
        this.id = id;
        this.dateTime = dateTime;
        this.chosenRestaurant = chosenRestaurant;
        this.user = user;
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {

    }

    @Override
    public String toString() {
        return "UserVoteTo{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", chosenRestaurant=" + chosenRestaurant +
                ", user=" + user +
                '}';
    }
}

package com.spider.vote.to;

import com.spider.vote.web.HasId;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class UserVoteTo implements Serializable, HasId {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private LocalDate date;


    private LocalTime time;


    private Integer chosenRestaurantId;


    private Integer userId;

    public UserVoteTo() {

    }

    public UserVoteTo(Integer id, LocalDate date, LocalTime time, Integer chosenRestaurantId, Integer userId) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.chosenRestaurantId = chosenRestaurantId;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getChosenRestaurantId() {
        return chosenRestaurantId;
    }

    public void setChosenRestaurantId(Integer chosenRestaurantId) {
        this.chosenRestaurantId = chosenRestaurantId;
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}

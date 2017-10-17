package com.spider.vote.domain.entity;

import com.spider.vote.domain.base.BaseEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Table(name = "user_votes", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "date"}, name = "unique_vote")})
public class Vote extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Restaurant restaurant;

    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDate date;

    public Vote() {
    }

    public Vote(User user, Restaurant restaurant, LocalDate date) {
        this(null,user,restaurant,date);
    }

    public Vote(Integer id, @NotNull User user, @NotNull Restaurant restaurant, @NotNull LocalDate date) {
        super(id);
        this.user = user;
        this.restaurant = restaurant;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setMenu(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Vote{" +
                "id="+getId()+", "+
                "user=" + user +
                ", restaurant=" + restaurant +
                ", date=" + date +
                '}';
    }
}

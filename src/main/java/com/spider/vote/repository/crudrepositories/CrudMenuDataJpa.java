package com.spider.vote.repository.crudrepositories;


import com.spider.vote.domain.entity.Menu;
import com.spider.vote.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudMenuDataJpa extends JpaRepository<Menu, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT m FROM Menu m WHERE m.date=:date")
    List<Menu> findByDate(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);

    @Transactional(readOnly = true)
    @Query("SELECT m FROM Menu m WHERE m.restaurant=:restaurant")
    List<Menu> findByRestaurant(@Param("restaurant") Restaurant restaurant);

    @Transactional
    Menu save(Menu entity);

    @Transactional
    @Modifying
    int deleteById(Integer id);

    @Transactional(readOnly = true)
    @Query("SELECT m from Menu m")
    List<Menu> getAllMenus();

}

package com.spider.vote.service.interfaces;


import com.spider.vote.domain.entity.Menu;
import com.spider.vote.domain.entity.Restaurant;

import java.time.LocalDate;
import java.util.List;

public interface MenuService {

    void deleteMenuById(int id);

    List<Menu> findMenuByDate(LocalDate date);

    List<Menu> findMenuByRestaurant(Restaurant restaurant);

    Menu saveMenu(Menu menu);

    List<Menu> getAllMenu();
}

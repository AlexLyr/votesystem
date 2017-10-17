package com.spider.vote.service;


import com.spider.vote.domain.entity.Menu;
import com.spider.vote.domain.entity.Restaurant;
import com.spider.vote.repository.MenuRepository;
import com.spider.vote.service.interfaces.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public void deleteMenuById(int id) {
        repository.deleteMenu(id);
    }

    @Override
    public List<Menu> findMenuByDate(LocalDate date) {
        Assert.notNull(date,"date must be not null");
      return repository.findMenuByDate(date);
    }

    @Override
    public List<Menu> findMenuByRestaurant(Restaurant restaurant) {
        Assert.notNull(restaurant,"restaurant must be not null");
        return repository.findMenuByRestaurant(restaurant);
    }

    @Override
    public Menu saveMenu(Menu menu) {
        Assert.notNull(menu, "menu must be not null");
        return repository.saveMenu(menu);
    }

    @Override
    public List<Menu> getAllMenu() {
        return repository.findAll();
    }
}

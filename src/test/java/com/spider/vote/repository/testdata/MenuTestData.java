package com.spider.vote.repository.testdata;


import com.spider.vote.domain.entity.Menu;

import java.time.LocalDate;

import static com.spider.vote.repository.testdata.RestaurantTestData.RESTAURANT_102;
import static com.spider.vote.repository.testdata.RestaurantTestData.RESTAURANT_103;
import static com.spider.vote.repository.testdata.RestaurantTestData.RESTAURANT_104;

public class MenuTestData {

    public static final Menu MENU_1 = new Menu(105, RESTAURANT_102, LocalDate.of(2017, 10, 23));

    public static final Menu MENU_2 = new Menu(106, RESTAURANT_102, LocalDate.of(2017, 10, 22));

    public static final Menu MENU_3 = new Menu(107, RESTAURANT_103, LocalDate.of(2017, 10, 23));

    public static final Menu MENU_4 = new Menu(108, RESTAURANT_103, LocalDate.of(2017, 10, 22));

    public static final Menu MENU_5 = new Menu(109, RESTAURANT_104, LocalDate.of(2017, 10, 23));

    public static final Menu MENU_6 = new Menu(110, RESTAURANT_104, LocalDate.of(2017, 10, 22));

    public static final Menu NEW_MENU = new Menu(RESTAURANT_104, LocalDate.of(2015, 11, 3));

}

package com.spider.vote.repository.testdata;


import com.spider.vote.domain.entity.Meal;
import com.spider.vote.utils.json.JsonUtil;

import java.util.Arrays;
import java.util.List;

import static com.spider.vote.repository.testdata.MenuTestData.*;

public class MealTestData {

    public static final Meal MEAL_1=new Meal(111,"Стрипсы",100.1,MENU_1);
    public static final Meal MEAL_2=new Meal(112,"Фри",74.5,MENU_1);
    public static final Meal MEAL_3=new Meal(113,"Старые стрипсы",90,MENU_2);
    public static final Meal MEAL_4=new Meal(114,"Несвежая картошка",50,MENU_2);
    public static final Meal MEAL_5=new Meal(115,"Хачапури",450,MENU_3);
    public static final Meal MEAL_6=new Meal(116,"Борщ",90.6,MENU_3);
    public static final Meal MEAL_7=new Meal(117,"Старое Хачапури",300,MENU_4);
    public static final Meal MEAL_8=new Meal(118,"Несвежий суп",60,MENU_4);
    public static final Meal MEAL_9=new Meal(119,"Гречка",20.2,MENU_5);
    public static final Meal MEAL_10=new Meal(120,"Курица",80.3,MENU_5);
    public static final Meal MEAL_11=new Meal(121,"Вчерашняя гречка",20,MENU_6);
    public static final Meal MEAL_12=new Meal(122,"Несвежая курица",50,MENU_6);
    public static final Meal NEW_MEAL=new Meal("Несвежая курица",50,MENU_1);
    public static final Meal UPD_MEAL=new Meal(113,"Несвежая курица111",100,MENU_6);
    public static final String JSON_NEW_MEAL= JsonUtil.writeValue(NEW_MEAL);
    public static final String JSON_UPD_MEAL= JsonUtil.writeValue(UPD_MEAL);

    public static final List<Meal> MEAL_LIST=
            Arrays.asList(MEAL_1,MEAL_2,MEAL_3,MEAL_4,MEAL_4,MEAL_5,MEAL_6,MEAL_7,MEAL_8,MEAL_9,MEAL_10,MEAL_11,MEAL_12);


}

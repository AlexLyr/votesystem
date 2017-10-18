package com.spider.vote.utils.json;

import com.spider.vote.domain.entity.Meal;
import com.spider.vote.to.UserVoteTo;
import com.spider.vote.utils.datetimeutils.DateTimeFormat;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static com.spider.vote.repository.testdata.MealTestData.JSON_NEW_MEAL;
import static com.spider.vote.repository.testdata.MealTestData.JSON_UPD_MEAL;
import static com.spider.vote.repository.testdata.MealTestData.MEAL_LIST;
import static com.spider.vote.repository.testdata.MenuTestData.JSON_NEW_MENU;
import static com.spider.vote.repository.testdata.RestaurantTestData.JSON_RESTAURANT;
import static com.spider.vote.repository.testdata.RestaurantTestData.RESTAURANT_102;
import static com.spider.vote.repository.testdata.UserTestData.NEW_USER_JSON;
import static com.spider.vote.repository.testdata.UserTestData.UPD_USER_JSON;
import static com.spider.vote.repository.testdata.VoteTestData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;



public class JsonUtilTest {

    @Test
    public void testParseDate(){
        LocalDate date= DateTimeFormat.parseLocalDate("2017-10-23");
        System.out.println(date);
    }

    @Test
    public void readValues() throws Exception {
        String jsonList=JsonUtil.writeValue(MEAL_LIST);
        List<Meal> list=JsonUtil.readValues(jsonList,Meal.class);
        System.out.println(list);
        for (int i = 0; i < MEAL_LIST.size(); i++) {
            assertThat(MEAL_LIST.get(i), samePropertyValuesAs(list.get(i)));
        }
    }

    @Test
    public void readValue() throws Exception {
       UserVoteTo voteTo=JsonUtil.readValue(JSON_VOTE_USER,UserVoteTo.class);
        System.out.println(voteTo);
        assertThat(VOTE_TO_USER,samePropertyValuesAs(voteTo));
    }

    @Test
    public void writeValue() throws Exception {
        String json=JsonUtil.writeValue(RESTAURANT_102);
        System.out.println(json);
        String jsonList=JsonUtil.writeValue(MEAL_LIST);
        System.out.println(jsonList);
    }

    @Test
    public void StringsForSOAP(){
        System.out.println(JSON_NEW_MEAL);
        System.out.println(JSON_UPD_MEAL);
        System.out.println(JSON_NEW_MENU);
        System.out.println(JSON_RESTAURANT);
        System.out.println(NEW_USER_JSON);
        System.out.println(UPD_USER_JSON);
        System.out.println(JSON_VOTE_USER);
        System.out.println(JSON_VOTE_ADMIN);
        System.out.println(JSON_VOTE_ADMIN_UPD);
        System.out.println(JSON_VOTE_ADMIN_UPD_LATE);
    }



}
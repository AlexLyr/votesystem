package com.spider.vote.repository;

import com.spider.vote.domain.entity.User;
import com.spider.vote.service.interfaces.UserService;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.Arrays;
import java.util.List;

import static com.spider.vote.repository.testdata.UserTestData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.samePropertyValuesAs;



public class UserServiceTest extends AbstractTestClass{


    @Autowired
    private UserService service;


    @Test
    public void getAllUsersTest() throws Exception {
        List<User> users = service.getAll();
        users.forEach(System.out::println);
        List<User> list=Arrays.asList(ADMIN,USER);
       for(int i=0;i<list.size();i++){
           assertThat(list.get(i), samePropertyValuesAs(users.get(i)));
       }
    }

    @Test
    public void testGetUserByEmail() {
        User user = service.getUserByEmail("user@yandex.ru");
        System.out.println(user);
        System.out.println(USER);
       assertThat(user, samePropertyValuesAs(USER));
    }

    @Test
    public void testDeleteUserById(){
        List<User> users = service.getAll();
        service.delete(USER_ID);
        assertThat(service.getAll(),hasSize(users.size()-1));
    }

    @Test
    public void testUserCreate(){
        service.create(newUser);
        User user=service.getUserByEmail(newUser.getEmail());
        assertThat(user, samePropertyValuesAs(newUser));
    }

    @Test
    public void testUserUpdate(){
        service.update(UPDATED_USER);
        User user=service.getUserByEmail(UPDATED_USER.getEmail());
        assertThat(user, samePropertyValuesAs(UPDATED_USER));
    }

}
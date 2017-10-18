package com.spider.vote.repository.crudrepositories;


import com.spider.vote.domain.entity.User;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
public interface CrudUserDataJpa extends JpaRepository<User, Integer> {

    @Override
    List<User> findAll(Sort sort);

    User findUserByEmail(String email);

    @Transactional
    @Modifying
    int deleteUserById(int id);

    @Override
    @Transactional
    User save(User user);

    User findUserById(int id);
}

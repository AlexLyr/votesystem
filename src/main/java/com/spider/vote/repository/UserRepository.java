package com.spider.vote.repository;


import com.spider.vote.domain.entity.User;
import com.spider.vote.repository.crudrepositories.CrudUserDataJpa;
import com.spider.vote.utils.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.spider.vote.utils.ValidationUtil.*;

@Repository
public class UserRepository {
    private static final Sort SORT_NAME_EMAIL = new Sort("name", "email");

    @Autowired
    private CrudUserDataJpa crudRepository;


    public List<User> getAll() {
        return crudRepository.findAll(SORT_NAME_EMAIL);
    }


    public User getUserByEmail(String email) {
        return crudRepository.findUserByEmail(email);
    }


    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(crudRepository.deleteUserById(id), id);
    }


    public User save(User user) {
        return crudRepository.save(user);
    }


    public User getUserById(int user_id){
        return crudRepository.findUserById(user_id);
    }
}

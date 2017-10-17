package com.spider.vote.service.interfaces;


import com.spider.vote.domain.entity.User;
import com.spider.vote.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    User getUserByEmail(String email) throws NotFoundException;
    List<User> getAll();
    void delete(int id);
    void update(User user);
    User create(User user);
    void evictCache();
}

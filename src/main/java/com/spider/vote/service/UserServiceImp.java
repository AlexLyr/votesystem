package com.spider.vote.service;

import com.spider.vote.domain.entity.User;
import com.spider.vote.repository.UserRepository;
import com.spider.vote.service.interfaces.UserService;
import com.spider.vote.utils.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional
    public User getUserByEmail(String email) throws NotFoundException {
        Assert.notNull(email, "email must be not null");
        User user= repository.getUserByEmail(email);
        if (user==null){
            throw new NotFoundException("User: " + email + " was not found");
        }
        if (!user.isEnabled()){
            throw new DisabledException("User: " + email + " is banned");
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public void update(User user) {
        Assert.notNull(user,"User must be not null ");
      repository.save(user);
    }

    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

}

package com.turkmen.spaceship.battle.service.impl;

import com.turkmen.spaceship.battle.model.User;
import com.turkmen.spaceship.battle.dao.UserDao;
import com.turkmen.spaceship.battle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    @Override
    public List<User> getUsers() {
        return this.userDao.getUsers();
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserFromGameItem(long gameItemId) {
        return userDao.getUserFromGameItem(gameItemId);
    }
}

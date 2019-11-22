package com.turkmen.xebialabs.xlspaceship.dao.impl;

import com.turkmen.xebialabs.xlspaceship.dao.UserDao;
import com.turkmen.xebialabs.xlspaceship.model.GameItem;
import com.turkmen.xebialabs.xlspaceship.model.User;
import com.turkmen.xebialabs.xlspaceship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getUserFromGameItem(long gameItemId) {
        return userRepository.getUserFromGameItem(gameItemId);
    }
}

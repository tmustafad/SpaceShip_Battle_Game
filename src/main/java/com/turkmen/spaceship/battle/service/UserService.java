package com.turkmen.spaceship.battle.service;

import com.turkmen.spaceship.battle.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */

@Service
public interface UserService {

    List<User> getUsers();
    User save(User user);
    User getUserById(long id);
    User getUserFromGameItem(long gameItemId);
}

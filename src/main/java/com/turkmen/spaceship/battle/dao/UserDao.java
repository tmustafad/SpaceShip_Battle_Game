package com.turkmen.spaceship.battle.dao;

import com.turkmen.spaceship.battle.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */

@Repository
public interface UserDao {

    List<User> getUsers();
    User save(User user);

    User getUserById(long id);

    User getUserFromGameItem(long gameItemId);
}

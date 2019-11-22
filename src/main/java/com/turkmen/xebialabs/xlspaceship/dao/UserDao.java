package com.turkmen.xebialabs.xlspaceship.dao;

import com.turkmen.xebialabs.xlspaceship.model.GameItem;
import com.turkmen.xebialabs.xlspaceship.model.User;
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

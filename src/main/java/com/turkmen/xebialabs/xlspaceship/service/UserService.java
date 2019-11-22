package com.turkmen.xebialabs.xlspaceship.service;

import com.turkmen.xebialabs.xlspaceship.model.User;
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

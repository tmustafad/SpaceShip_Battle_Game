package com.turkmen.spaceship.battle.mapper;

import com.turkmen.spaceship.battle.dto.UserDto;
import com.turkmen.spaceship.battle.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by turkmenmustafademirci on 11/10/19.
 */

@Component
public class UserMapper {

    @Autowired
    ModelMapper modelMapper;

    public User convertToEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }

    public UserDto convertToDto(User user)  {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }
}

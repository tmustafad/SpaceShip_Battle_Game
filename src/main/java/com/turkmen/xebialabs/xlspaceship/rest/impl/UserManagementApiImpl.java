package com.turkmen.xebialabs.xlspaceship.rest.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.turkmen.xebialabs.xlspaceship.dto.SalvoRequestDto;
import com.turkmen.xebialabs.xlspaceship.dto.SalvoResponseDto;
import com.turkmen.xebialabs.xlspaceship.dto.UserDto;
import com.turkmen.xebialabs.xlspaceship.helper.GameSalvoHelper;
import com.turkmen.xebialabs.xlspaceship.mapper.BoardMapper;
import com.turkmen.xebialabs.xlspaceship.mapper.GameItemMapper;
import com.turkmen.xebialabs.xlspaceship.mapper.UserMapper;
import com.turkmen.xebialabs.xlspaceship.model.Game;
import com.turkmen.xebialabs.xlspaceship.model.User;
import com.turkmen.xebialabs.xlspaceship.rest.UserManagementApi;
import com.turkmen.xebialabs.xlspaceship.service.GameService;
import com.turkmen.xebialabs.xlspaceship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */

@Component
public class UserManagementApiImpl implements UserManagementApi {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    GameService gameService;

    @Autowired
    GameItemMapper gameItemMapper;

    @Autowired
    BoardMapper boardMapper;

    @Autowired
    GameSalvoHelper gameSalvoHelper;

    @Override
    public ResponseEntity getUsers() {
        List<User> users =this.userService.getUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }


    @Override
    public ResponseEntity createUser(UserDto userDto) {
        return new ResponseEntity(userService.save(userMapper.convertToEntity(userDto)),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity getGameById(long id)  {
        return new ResponseEntity(boardMapper.convertToGameStatusDto(gameService.getGameById(id).getGameItems()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity attackToOpponent(long gameId, SalvoRequestDto salvoRequestDto) {
        Game game=gameService.getGameById(gameId);
        SalvoResponseDto responseDto=gameSalvoHelper.generateSalvoResponse(salvoRequestDto,game,"player-1");
        return new ResponseEntity(responseDto,responseDto == null ?HttpStatus.NOT_FOUND:HttpStatus.OK);

    }
}

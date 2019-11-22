package com.turkmen.spaceship.battle.mapper;

import com.turkmen.spaceship.battle.builder.GenericBuilder;
import com.turkmen.spaceship.battle.dto.GameDto;
import com.turkmen.spaceship.battle.dto.GameDtoRequest;
import com.turkmen.spaceship.battle.dto.GameDtoResponse;
import com.turkmen.spaceship.battle.model.User;
import com.turkmen.spaceship.battle.service.UserService;
import com.turkmen.spaceship.battle.model.Game;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by turkmenmustafademirci on 11/10/19.
 */

@Component
public class GameMapper {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserService userService;

    public Game convertToEntity(GameDto gameDto) {
        Game game = modelMapper.map(gameDto, Game.class);
        return game;
    }

    public GameDto convertToDto(Game game)  {
        GameDto gameDto = modelMapper.map(game, GameDto.class);
        return gameDto;
    }

    public GameDtoResponse convertToGameDtoResponse(Game game){
        GameDtoResponse gameDtoResponse= GenericBuilder.of(GameDtoResponse::new)
                .with(GameDtoResponse::setFullName,"Assessment Player")
                .with(GameDtoResponse::setGame_id,game.getId())
                .with(GameDtoResponse::setStarting,"xebialabs-1")
                .with(GameDtoResponse::setUser_id,"player")
                .build();
        return  gameDtoResponse;
    }


    public GameDto convertToGameDto(GameDtoRequest gameDtoRequest){
        GameDto gameDto =GenericBuilder.of(GameDto::new).build();

        Set<User> users=new HashSet();
        User userSelf=GenericBuilder.of(User::new)
                .with(User::setName,"player-1")
                .build();
        userService.save(userSelf);
        User userOpponent=GenericBuilder.of(User::new)
                .with(User::setName,"xebialabs-1")
                .build();
        userService.save(userOpponent);
        users.add(userSelf);
        users.add(userOpponent);
        gameDto.setUsers(users);

        return  gameDto;
    }
}

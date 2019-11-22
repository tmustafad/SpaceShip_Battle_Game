package com.turkmen.spaceship.battle.helper;

import com.turkmen.spaceship.battle.builder.GenericBuilder;
import com.turkmen.spaceship.battle.dto.GameDto;
import com.turkmen.spaceship.battle.mapper.GameMapper;
import com.turkmen.spaceship.battle.model.Game;
import com.turkmen.spaceship.battle.model.GameItem;
import com.turkmen.spaceship.battle.model.User;
import com.turkmen.spaceship.battle.rest.impl.GameManagementApiImpl;
import com.turkmen.spaceship.battle.service.GameService;
import com.turkmen.spaceship.battle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by turkmenmustafademirci on 11/10/19.
 * This is the helper class for Game Management Api
 * @see GameManagementApiImpl
 */
@Component
public class GameCreationHelper {

    @Autowired
    GameService gameService;

    @Autowired
    GameMapper gameMapper;

    @Autowired
    UserService userService;

    @Autowired
    SpaceshipCreationHelper spaceshipCreationHelper;

    public Game initiateGame(GameDto gameDto){
        List<GameItem> items=new ArrayList();
        Set<User> users=new HashSet();

        for(int i=0; i<16; i++){
            for(int j=0; j<16; j++){
                GameItem gameItem= GenericBuilder.of(GameItem::new)
                        .with(GameItem::setCol,j)
                        .with(GameItem::setRow,i)
                        .build();
                items.add(gameItem);
            }
        }


            gameDto.getUsers().stream().forEach(i->{
                if(i.getId() != 0)
                    users.add(userService.getUserById(i.getId()));
                else
                    users.add(i);
            });

        Game game =GenericBuilder.of(Game::new)
                .with(Game::setGameItems,items)
                .with(Game::setUsers,users)
                .with(Game::setPlayerTurn,"xebialabs-1")
                .build();

        return gameService.save(game);
    }
}

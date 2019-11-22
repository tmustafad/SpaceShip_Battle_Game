package com.turkmen.spaceship.battle.rest.impl;

import com.turkmen.spaceship.battle.mapper.GameItemMapper;
import com.turkmen.spaceship.battle.service.GameItemService;
import com.turkmen.spaceship.battle.rest.GameItemManagementApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Created by turkmenmustafademirci on 11/15/19.
 */
@Component
public class GameItemManagementApiImpl implements GameItemManagementApi {


    @Autowired
    GameItemService gameItemService;

    @Autowired
    GameItemMapper gameItemMapper;





    @Override
    public ResponseEntity getValues() {
        return   new ResponseEntity(gameItemMapper.convertToBoardDto(gameItemService.getGameItems()), HttpStatus.CREATED);
    }
}

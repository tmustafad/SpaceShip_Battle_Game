package com.turkmen.xebialabs.xlspaceship.rest.impl;

import com.turkmen.xebialabs.xlspaceship.dto.GameDto;
import com.turkmen.xebialabs.xlspaceship.dto.GameDtoRequest;
import com.turkmen.xebialabs.xlspaceship.dto.SalvoRequestDto;
import com.turkmen.xebialabs.xlspaceship.dto.SalvoResponseDto;
import com.turkmen.xebialabs.xlspaceship.helper.GameSalvoHelper;
import com.turkmen.xebialabs.xlspaceship.helper.SpaceshipCreationHelper;
import com.turkmen.xebialabs.xlspaceship.mapper.GameMapper;
import com.turkmen.xebialabs.xlspaceship.model.Game;
import com.turkmen.xebialabs.xlspaceship.rest.GameManagementApi;
import com.turkmen.xebialabs.xlspaceship.helper.GameCreationHelper;
import com.turkmen.xebialabs.xlspaceship.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */

@Component
public class GameManagementApiImpl implements GameManagementApi {

    @Autowired
    GameService gameService;

    @Autowired
    GameMapper gameMapper;

    @Autowired
    GameCreationHelper gameCreationHelper;

    @Autowired
    SpaceshipCreationHelper spaceshipCreationHelper;

    @Autowired
    GameSalvoHelper gameSalvoHelper;


    @Override
    public ResponseEntity getGames() {

        List<GameDto> boards = this.gameService.getGames()
                .stream().map(i -> gameMapper.convertToDto(i))
                .collect(Collectors.toList());

        return new ResponseEntity(boards, HttpStatus.OK);
    }

    @Override
    public ResponseEntity createGame(GameDtoRequest gameDtoRequest) {
        Game game = this.gameCreationHelper.initiateGame(gameMapper.convertToGameDto(gameDtoRequest));
        spaceshipCreationHelper.createSpaceships(game);
        gameService.getGameById(game.getId());

        return new ResponseEntity(gameMapper.convertToGameDtoResponse(game), HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity attackFromOpponent(long gameId, SalvoRequestDto salvoRequestDto) {
        Game game = gameService.getGameById(gameId);
        SalvoResponseDto responseDto = gameSalvoHelper.generateSalvoResponse(salvoRequestDto, game, "xebialabs-1");
        return new ResponseEntity(responseDto, responseDto == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);


    }
}

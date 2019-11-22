package com.turkmen.spaceship.battle.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.turkmen.spaceship.battle.dto.GameDtoRequest;
import com.turkmen.spaceship.battle.dto.GameDtoResponse;
import com.turkmen.spaceship.battle.dto.SalvoRequestDto;
import com.turkmen.spaceship.battle.dto.SalvoResponseDto;
import com.turkmen.spaceship.battle.model.Game;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */

@RestController
public interface GameManagementApi {


    @GetMapping(value = "/xl-spaceship/protocol/games", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Return all Boards", notes = "The public API for Boards", response = Game.class)
    @ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity getGames() throws JsonProcessingException;


    @PostMapping(value = "/xl-spaceship/protocol/game/new", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Add a new Game with details", notes = "This is a public API for adding Game", response = GameDtoResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_CREATED, message = "A new game has been created successfully"),
    })
    ResponseEntity createGame(@RequestBody GameDtoRequest gameDtoRequest);



    @PutMapping(value = "/xl-spaceship/protocol/game/{gameId}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Attacks from the opponent  with relevant salvos", notes = "This is a public API for making a list of salvos from opponent ", response = SalvoResponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "A game with the given id is updated"),
    })
    ResponseEntity attackFromOpponent(@PathVariable long gameId,@RequestBody SalvoRequestDto salvoRequestDto);


}

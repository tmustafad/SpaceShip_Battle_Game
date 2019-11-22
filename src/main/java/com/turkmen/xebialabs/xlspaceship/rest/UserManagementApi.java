package com.turkmen.xebialabs.xlspaceship.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.turkmen.xebialabs.xlspaceship.dto.BoardDto;
import com.turkmen.xebialabs.xlspaceship.dto.SalvoRequestDto;
import com.turkmen.xebialabs.xlspaceship.dto.SalvoResponseDto;
import com.turkmen.xebialabs.xlspaceship.dto.UserDto;
import com.turkmen.xebialabs.xlspaceship.model.Game;
import com.turkmen.xebialabs.xlspaceship.model.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */

@RestController
public interface UserManagementApi {

    @GetMapping(value = "/xl-spaceship/user/" , produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Return all Players" , notes = "The public API for Players" ,response = User.class)
    @ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
    ResponseEntity getUsers();

    @PostMapping(value = "/xl-spaceship/user/new", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Save the user" , notes = "The public API for User" ,response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_CREATED, message = "A new user has been created successfully"),
    })
    ResponseEntity createUser(@RequestBody UserDto userDto);


    @GetMapping(value = "/xl-spaceship/user/game/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Return the game status by given Id", notes = "The public API for getting a particular game by its id", response = BoardDto.class)
    @ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity getGameById(@PathVariable long id) ;





    @PutMapping(value = "/xl-spaceship/user/game/{gameId}/fire", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Attack to opponent with   relevant salvos", notes = "This is a public API for  attacking the opponent", response = SalvoResponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "A game with the given id is updated"),
    })
    ResponseEntity attackToOpponent(@PathVariable long gameId,@RequestBody SalvoRequestDto salvoRequestDto);

}




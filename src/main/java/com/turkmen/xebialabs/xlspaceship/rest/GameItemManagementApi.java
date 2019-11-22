package com.turkmen.xebialabs.xlspaceship.rest;

import com.turkmen.xebialabs.xlspaceship.model.GameItem;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by turkmenmustafademirci on 11/15/19.
 */

@RestController
public interface GameItemManagementApi {

    @GetMapping(value = "/xl-spaceship/protocol/monitor" , produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Return allocated GameItems with populated values" , notes = "The public API for GameItems with populated values" ,response = GameItem.class)
    @ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity getValues();
}

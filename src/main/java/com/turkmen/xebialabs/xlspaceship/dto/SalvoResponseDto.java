package com.turkmen.xebialabs.xlspaceship.dto;

import com.turkmen.xebialabs.xlspaceship.model.Game;

import java.util.Map;

/**
 * Created by turkmenmustafademirci on 11/20/19.
 */
public class SalvoResponseDto {

    private Map<String, String> salvo;


    private PlayerTurnDto game;

    public Map<String, String> getSalvo() {
        return salvo;
    }

    public void setSalvo(Map<String, String> salvo) {
        this.salvo = salvo;
    }

    public PlayerTurnDto getGame() {
        return game;
    }

    public void setGame(PlayerTurnDto game) {
        this.game = game;
    }




}

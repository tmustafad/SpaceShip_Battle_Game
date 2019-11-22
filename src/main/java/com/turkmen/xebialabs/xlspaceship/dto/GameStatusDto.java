package com.turkmen.xebialabs.xlspaceship.dto;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 11/21/19.
 */
public class GameStatusDto {


    private PlayerInfoDto self;

    private PlayerInfoDto opponent;

    private PlayerTurnDto game;


    public PlayerTurnDto getGame() {
        return game;
    }

    public void setGame(PlayerTurnDto game) {
        this.game = game;
    }

    public PlayerInfoDto getSelf() {
        return self;
    }

    public void setSelf(PlayerInfoDto self) {
        this.self = self;
    }

    public PlayerInfoDto getOpponent() {
        return opponent;
    }

    public void setOpponent(PlayerInfoDto opponent) {
        this.opponent = opponent;
    }
}


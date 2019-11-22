package com.turkmen.spaceship.battle.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by turkmenmustafademirci on 11/21/19.
 */
public class PlayerTurnDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String player_turn;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String won;

    public String getWon() {
        return won;
    }

    public void setWon(String won) {
        this.won = won;
    }

    public String getPlayer_turn() {
        return player_turn;
    }

    public void setPlayer_turn(String player_turn) {
        this.player_turn = player_turn;
    }
}

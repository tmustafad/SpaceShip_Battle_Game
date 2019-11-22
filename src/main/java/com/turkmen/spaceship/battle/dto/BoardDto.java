package com.turkmen.spaceship.battle.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;
import java.util.Map;

/**
 * Created by turkmenmustafademirci on 11/15/19.
 */
public class BoardDto {

    private String won;

    private String playerTurn;

    public String getWon() {
        return won;
    }

    public void setWon(String won) {
        this.won = won;
    }

    public String getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(String playerTurn) {
        this.playerTurn = playerTurn;
    }

    private Map<String,List<List<String>>> valueList;

    public Map<String, List<List<String>>> getValueList() {
        return valueList;
    }

    public void setValueList(Map<String, List<List<String>>> valueList) {
        this.valueList = valueList;
    }
}

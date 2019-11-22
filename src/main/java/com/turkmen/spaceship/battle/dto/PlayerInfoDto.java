package com.turkmen.spaceship.battle.dto;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 11/21/19.
 */
public class PlayerInfoDto {

    private String user_id;

    List<String> board;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public List<String> getBoard() {
        return board;
    }

    public void setBoard(List<String> board) {
        this.board = board;
    }
}

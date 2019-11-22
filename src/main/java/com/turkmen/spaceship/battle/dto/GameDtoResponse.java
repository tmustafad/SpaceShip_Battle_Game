package com.turkmen.spaceship.battle.dto;

/**
 * Created by turkmenmustafademirci on 11/10/19.
 */
public class GameDtoResponse {

    private String user_id;

    private String full_Name;

    private long game_id;

    private String starting;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFullName() {
        return full_Name;
    }

    public void setFullName(String fullName) {
        this.full_Name = fullName;
    }

    public long getGame_id() {
        return game_id;
    }

    public void setGame_id(long game_id) {
        this.game_id = game_id;
    }

    public String getStarting() {
        return starting;
    }

    public void setStarting(String starting) {
        this.starting = starting;
    }
}

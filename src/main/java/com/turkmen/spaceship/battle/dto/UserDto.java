package com.turkmen.spaceship.battle.dto;

import com.turkmen.spaceship.battle.model.Game;

/**
 * Created by turkmenmustafademirci on 11/10/19.
 */
public class UserDto {

    private long id;

    private String name;

    private Game game;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

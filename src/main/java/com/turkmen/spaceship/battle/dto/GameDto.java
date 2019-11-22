package com.turkmen.spaceship.battle.dto;

import com.turkmen.spaceship.battle.model.User;
import com.turkmen.spaceship.battle.model.GameItem;

import java.util.List;
import java.util.Set;

/**
 * Created by turkmenmustafademirci on 11/10/19.
 */
public class GameDto {

    private long id;

    private List<GameItem> gameItems;

   private Set<User> users;

    private String playerTurn;

    private String winner;


    public String getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(String playerTurn) {
        this.playerTurn = playerTurn;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<GameItem> getGameItems() {
        return gameItems;
    }

    public void setGameItems(List<GameItem> gameItems) {
        this.gameItems = gameItems;
    }
}

package com.turkmen.spaceship.battle.model;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */

@Entity
@Table(name = "Game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id")
    private List<GameItem> gameItems;



    @OneToMany( cascade={CascadeType.ALL})
    @JoinColumn(name = "game_id")
    private Set<User> users;

    @Column(name = "player_turn")
    private String playerTurn;

    @Column(name = "winner")
    private String winner;

    public Game() {
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(String playerTurn) {
        this.playerTurn = playerTurn;
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

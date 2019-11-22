package com.turkmen.spaceship.battle.model;

import javax.persistence.*;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "PLAYER_NAME" , nullable = false)
    private String name;


    @Transient
    @ManyToOne(fetch = FetchType.LAZY)
    private Game game;

    @Transient
    @OneToOne(mappedBy = "user")
    private GameItem gameItem;

    public GameItem getGameItem() {
        return gameItem;
    }

    public void setGameItem(GameItem gameItem) {
        this.gameItem = gameItem;
    }

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

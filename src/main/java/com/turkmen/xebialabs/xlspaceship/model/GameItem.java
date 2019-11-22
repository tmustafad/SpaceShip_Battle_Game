package com.turkmen.xebialabs.xlspaceship.model;

import javax.persistence.*;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */

@Entity
@Table(name = "Game_Item")
public class GameItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "ROW_" , nullable = false)
    private Integer row;

    @Column(name = "COL" , nullable = false)
    private Integer col;

    @Column(name = "VALUE" , nullable = true)
    private String value;

    @Column(name = "ALLOCATED")
    private boolean allocated;

    @Transient
    @ManyToOne(fetch = FetchType.LAZY)
    private Game game;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" ,referencedColumnName = "id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAllocated() {
        return allocated;
    }

    public void setAllocated(boolean allocated) {
        this.allocated = allocated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}

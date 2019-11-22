package com.turkmen.spaceship.battle.service.impl;

import com.turkmen.spaceship.battle.dao.GameDao;
import com.turkmen.spaceship.battle.model.Game;
import com.turkmen.spaceship.battle.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */

@Component
public class GameServiceImpl implements GameService {

    @Autowired
    GameDao gameDao;


    @Override
    public Game getGameById(long id) {
        return this.gameDao.getByGameId(id);
    }

    @Override
    public List<Game> getGames() {
        return this.gameDao.getGames();
    }

    @Override
    public Game save(Game game) {
        return this.gameDao.save(game);
    }

    @Override
    public void update(Game game) {
        gameDao.update(game);
    }
}

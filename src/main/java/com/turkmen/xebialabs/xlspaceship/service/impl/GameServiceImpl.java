package com.turkmen.xebialabs.xlspaceship.service.impl;

import com.turkmen.xebialabs.xlspaceship.dao.GameDao;
import com.turkmen.xebialabs.xlspaceship.model.Game;
import com.turkmen.xebialabs.xlspaceship.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

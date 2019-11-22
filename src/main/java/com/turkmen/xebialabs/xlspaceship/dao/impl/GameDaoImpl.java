package com.turkmen.xebialabs.xlspaceship.dao.impl;

import com.turkmen.xebialabs.xlspaceship.dao.GameDao;
import com.turkmen.xebialabs.xlspaceship.model.Game;
import com.turkmen.xebialabs.xlspaceship.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */


@Component
public class GameDaoImpl implements GameDao {

    @Autowired
    GameRepository gameRepository;

    @Override
    public List<Game> getGames() {
        return this.gameRepository.findAll();
    }

    @Override
    public Game getByGameId(long id) {
        return this.gameRepository.searchBoardById(id);
    }

    @Override
    public Game save(Game game) {
        return this.gameRepository.save(game);
    }

    @Override
    public void update(Game game) {
        gameRepository.save(game);//this save method checks if the entity is new or already exists ,based on this it either saves or merges
    }
}

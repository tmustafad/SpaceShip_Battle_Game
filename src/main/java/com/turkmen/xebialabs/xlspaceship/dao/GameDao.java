package com.turkmen.xebialabs.xlspaceship.dao;

import com.turkmen.xebialabs.xlspaceship.model.Game;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */

@Repository
public interface GameDao {


    List<Game> getGames();

    Game getByGameId(long id);

    Game save(Game game);

    void update(Game game);
}

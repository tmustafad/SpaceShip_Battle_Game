package com.turkmen.xebialabs.xlspaceship.service;

import com.turkmen.xebialabs.xlspaceship.model.Game;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */

@Service
public interface GameService {

    Game getGameById(long id);

    List<Game> getGames();

    Game save(Game game);

    void update(Game game);
}

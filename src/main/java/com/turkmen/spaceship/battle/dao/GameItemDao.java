package com.turkmen.spaceship.battle.dao;

import com.turkmen.spaceship.battle.model.GameItem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */

@Repository
public interface GameItemDao {


    List<GameItem> getGameItems();

    GameItem getByGameItemId(long id);

    void update(String row,String col,String val,boolean allocated);

    GameItem getByRowAndColNo( String row,  String col , long game_id);

    GameItem save(GameItem game);

    List<GameItem> getGameItemsOrdered();

}

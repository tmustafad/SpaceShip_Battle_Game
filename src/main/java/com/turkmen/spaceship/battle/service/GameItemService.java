package com.turkmen.spaceship.battle.service;

import com.turkmen.spaceship.battle.model.GameItem;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */

@Service
public interface GameItemService {

    List<GameItem> getGameItems();

    GameItem getByGameItemId(long id);

    void update(String row,String col,String val,boolean allocated);

    GameItem getByRowAndColNo( String row,  String col, long game_id);

    GameItem save(GameItem gameItem);

    List<GameItem> getGameItemsOrdered();
}

package com.turkmen.spaceship.battle.dao.impl;

import com.turkmen.spaceship.battle.dao.GameItemDao;
import com.turkmen.spaceship.battle.model.GameItem;
import com.turkmen.spaceship.battle.repository.GameItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 11/14/19.
 */
@Component
public class GameItemDaoImpl implements GameItemDao {

    @Autowired
    GameItemRepository gameItemRepository;

    @Override
    public List<GameItem> getGameItems() {
        return gameItemRepository.findAll();
    }

    @Override
    public GameItem getByGameItemId(long id) {
        return gameItemRepository.findById(id).get();
    }

    @Override
    public void update(String row, String col, String val,boolean allocated) {
        gameItemRepository.updateGameItem(row,col,val,allocated);
    }

    @Override
    public GameItem getByRowAndColNo(String row, String col,long game_id) {
        return gameItemRepository.getByRowAndColNo(row,col,game_id);
    }

    @Override
    public GameItem save(GameItem gameItem) {
        return gameItemRepository.save(gameItem);
    }

    @Override
    public List<GameItem> getGameItemsOrdered() {
        return gameItemRepository.getGameItemsOrdered();
    }
}

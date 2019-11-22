package com.turkmen.xebialabs.xlspaceship.service.impl;

import com.turkmen.xebialabs.xlspaceship.dao.GameItemDao;
import com.turkmen.xebialabs.xlspaceship.model.GameItem;
import com.turkmen.xebialabs.xlspaceship.service.GameItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */

@Component
public class GameItemServiceImpl implements GameItemService {

    @Autowired
    GameItemDao gameItemDao;

    @Override
    public List<GameItem> getGameItems() {
        return gameItemDao.getGameItems();
    }

    @Override
    public GameItem getByGameItemId(long id) {
        return gameItemDao.getByGameItemId(id);
    }

    @Transactional
    @Override
    public void update(String row, String col, String val,boolean allocated) {
        gameItemDao.update(row,col,val,allocated);
    }

    @Override
    public GameItem getByRowAndColNo(String row, String col,long game_id) {
        return gameItemDao.getByRowAndColNo(row,col,game_id);
    }

    @Override
    public GameItem save(GameItem gameItem) {
        return gameItemDao.save(gameItem);
    }

    @Override
    public List<GameItem> getGameItemsOrdered() {
        return gameItemDao.getGameItemsOrdered();
    }
}

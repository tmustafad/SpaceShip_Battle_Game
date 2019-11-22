package com.turkmen.spaceship.battle.repository;

import com.turkmen.spaceship.battle.model.User;
import com.turkmen.spaceship.battle.model.GameItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */
public interface UserRepository extends JpaRepository<User,Long> {


    /**
     * To fetch User by name
     * @param name
     * @return
     */
    @Query("SELECT u from User u WHERE u.name =:name")
    List<User> searchUserByName(@Param("name") String name);

    @Query(value = "SELECT * from USER u inner join GAME_ITEM g on u.id=g.user_id where g.id=:gameItemId" ,nativeQuery = true)
    User getUserFromGameItem(@Param("gameItemId") long gameItemId);


    @Query(value = "SELECT * from Game_Item g WHERE g.row_ =:row and g.col=:col and g.game_id=:game_id",nativeQuery = true)
    GameItem getByRowAndColNo(@Param("row") String row,@Param("col") String col,@Param("game_id") long game_id);

}

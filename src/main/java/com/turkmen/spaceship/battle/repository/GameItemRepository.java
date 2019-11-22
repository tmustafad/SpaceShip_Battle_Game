package com.turkmen.spaceship.battle.repository;

import com.turkmen.spaceship.battle.model.GameItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by turkmenmustafademirci on 11/14/19.
 */
public interface GameItemRepository extends JpaRepository<GameItem,Long> {

    @Modifying(clearAutomatically = true)
    @Query("update GameItem g set g.value = :val,g.allocated=:allocated where g.col = :col and g.row=:row")
    void updateGameItem(@Param("row") String row, @Param("col")  String col, @Param("val") String value,
                        @Param("allocated") boolean allocated);

    @Query(value = "SELECT * from Game_Item g WHERE g.row_ =:row and g.col=:col and g.game_id=:game_id",nativeQuery = true)
    GameItem getByRowAndColNo(@Param("row") String row,@Param("col") String col,@Param("game_id") long game_id);

    @Query(value = "SELECT g from GameItem g  order by row asc")
    List<GameItem> getGameItemsOrdered();
}

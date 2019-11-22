package com.turkmen.xebialabs.xlspaceship.repository;

import com.turkmen.xebialabs.xlspaceship.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by turkmenmustafademirci on 11/9/19.
 */


public interface GameRepository extends JpaRepository<Game,Long> {


    /**
     * To fetch Game by name
     * @param id
     * @return
     */
    @Query("SELECT g from Game g WHERE g.id =:id")
    Game searchBoardById(@Param("id") long id);



}

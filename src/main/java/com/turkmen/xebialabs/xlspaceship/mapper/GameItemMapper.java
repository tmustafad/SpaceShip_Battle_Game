package com.turkmen.xebialabs.xlspaceship.mapper;

import com.turkmen.xebialabs.xlspaceship.builder.GenericBuilder;
import com.turkmen.xebialabs.xlspaceship.dto.BoardDto;
import com.turkmen.xebialabs.xlspaceship.model.Game;
import com.turkmen.xebialabs.xlspaceship.model.GameItem;
import com.turkmen.xebialabs.xlspaceship.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by turkmenmustafademirci on 11/15/19.
 */

@Component
public class GameItemMapper {

    @Autowired
    GameService gameService;

    private static final String SELF_USER_NAME = "player-1";
    private static final String OPPONENT_NAME = "xebialabs-1";

    public BoardDto convertToBoardDto(List<GameItem> gameItemList) {

        BoardDto boardDto = GenericBuilder.of(BoardDto::new).build();

        Game game=gameService.getGames().stream().findAny().get();


        boardDto.setPlayerTurn(game.getPlayerTurn());



        Map<String, List<List<String>>> items = new HashMap();
        List<List<String>> selfList = new ArrayList();
        List<List<String>> opponentList = new ArrayList();
        IntStream.range(0, 16).forEach(i -> {

            List<String> tmpList = new ArrayList();
            List<String> tmpOppList = new ArrayList();



            gameItemList.stream().forEach(j -> {


                if (j.getRow() == i) {

                    if (j.getValue() != null) {
                        tmpList.add(j.getValue());
                        if(j.getUser() != null && j.getUser().getName().equals(SELF_USER_NAME)){
                            selfList.add(tmpList);
                            items.put(SELF_USER_NAME,selfList);
                        }
                        else{
                            tmpOppList.add(".");
                            opponentList.add(tmpOppList);
                            items.put(OPPONENT_NAME,opponentList);
                        }
                    } else{
                        tmpList.add(".");
                        tmpOppList.add(".");
                    }



                }


            });
        });

        boardDto.setValueList(items);
        return boardDto;
    }
}

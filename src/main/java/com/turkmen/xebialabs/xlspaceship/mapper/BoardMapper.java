package com.turkmen.xebialabs.xlspaceship.mapper;

import com.turkmen.xebialabs.xlspaceship.builder.GenericBuilder;
import com.turkmen.xebialabs.xlspaceship.dto.GameStatusDto;
import com.turkmen.xebialabs.xlspaceship.dto.PlayerInfoDto;
import com.turkmen.xebialabs.xlspaceship.dto.PlayerTurnDto;
import com.turkmen.xebialabs.xlspaceship.helper.GameSalvoHelper;
import com.turkmen.xebialabs.xlspaceship.model.Game;
import com.turkmen.xebialabs.xlspaceship.model.GameItem;
import com.turkmen.xebialabs.xlspaceship.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by turkmenmustafademirci on 11/21/19.
 */

@Component
public class BoardMapper {

    private static final String SELF_USER_NAME = "player-1";
    private static final String OPPONENT_NAME = "xebialabs-1";


    @Autowired
    GameService gameService;

    /*
    * TODO  This is not a good practice , winner check method must be centralized for common use
    */
    @Autowired
    GameSalvoHelper gameSalvoHelper;

    public GameStatusDto convertToGameStatusDto(List<GameItem> gameItemList) {


        GameStatusDto gameStatusDto = GenericBuilder.of(GameStatusDto::new).build();

        Game game = gameService.getGames().stream().findAny().get();

        PlayerInfoDto selfInfo=GenericBuilder.of(PlayerInfoDto::new).build();

        PlayerInfoDto opponentInfo=GenericBuilder.of(PlayerInfoDto::new).build();


        PlayerTurnDto playerTurnDto = GenericBuilder.of(PlayerTurnDto::new)
                .with(PlayerTurnDto::setPlayer_turn, gameSalvoHelper.setWinnerIfExist(game).getWinner() == null ? game.getPlayerTurn() : null)
                .with(PlayerTurnDto::setWon,gameSalvoHelper.setWinnerIfExist(game).getWinner() != null ? game.getWinner() : null)
                .build();

        gameStatusDto.setGame(playerTurnDto);

        List<String> selfItemList=new ArrayList();

        List<String> opponentItemList=new ArrayList();

        IntStream.range(0, 16).forEach(i -> {

            StringBuilder sbSelf=new StringBuilder();
            StringBuilder sbOpp=new StringBuilder();

            gameItemList.stream().forEach(j -> {
                if (j.getRow() == i) {
                    if (j.getValue() != null) {
                        if(j.getUser() != null && j.getUser().getName().equals(SELF_USER_NAME)){
                            sbSelf.append(j.getValue());
                            sbOpp.append(".");
                        }
                        else {
                            sbSelf.append(".");
                            sbOpp.append(".");
                        }
                    }
                    else {
                        sbSelf.append(".");
                        sbOpp.append(".");
                    }
                }
            }
            );
                    selfItemList.add(sbSelf.toString());
                    opponentItemList.add(sbOpp.toString());
        });
        selfInfo.setUser_id(SELF_USER_NAME);
        opponentInfo.setUser_id(OPPONENT_NAME);
        selfInfo.setBoard(selfItemList);
        opponentInfo.setBoard(opponentItemList);
        gameStatusDto.setSelf(selfInfo);
        gameStatusDto.setOpponent(opponentInfo);
        return gameStatusDto;

    }
}

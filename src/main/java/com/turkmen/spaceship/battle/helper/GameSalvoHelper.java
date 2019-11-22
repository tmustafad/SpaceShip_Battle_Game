package com.turkmen.spaceship.battle.helper;

import com.turkmen.spaceship.battle.builder.GenericBuilder;
import com.turkmen.spaceship.battle.configuration.SalvoConfiguration;
import com.turkmen.spaceship.battle.dto.PlayerTurnDto;
import com.turkmen.spaceship.battle.dto.SalvoRequestDto;
import com.turkmen.spaceship.battle.dto.SalvoResponseDto;
import com.turkmen.spaceship.battle.model.Game;
import com.turkmen.spaceship.battle.model.GameItem;
import com.turkmen.spaceship.battle.model.User;
import com.turkmen.spaceship.battle.service.GameItemService;
import com.turkmen.spaceship.battle.service.GameService;
import com.turkmen.spaceship.battle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by turkmenmustafademirci on 11/20/19.
 */

@Component
public class GameSalvoHelper {

    @Autowired
    SalvoConfiguration salvoConfiguration;

    @Autowired
    GameItemService gameItemService;

    @Autowired
    GameService gameService;

    @Autowired
    UserService userService;

    private Map<String, String> salvoMap;


    @PostConstruct
    private void loadMap() {
        this.salvoMap = new HashMap();
        salvoMap.put("0", salvoConfiguration.zero);
        salvoMap.put("1", salvoConfiguration.one);
        salvoMap.put("2", salvoConfiguration.two);
        salvoMap.put("3", salvoConfiguration.three);
        salvoMap.put("4", salvoConfiguration.four);
        salvoMap.put("5", salvoConfiguration.five);
        salvoMap.put("6", salvoConfiguration.six);
        salvoMap.put("7", salvoConfiguration.seven);
        salvoMap.put("8", salvoConfiguration.eight);
        salvoMap.put("9", salvoConfiguration.nine);
        salvoMap.put("A", salvoConfiguration.a);
        salvoMap.put("B", salvoConfiguration.b);
        salvoMap.put("C", salvoConfiguration.c);
        salvoMap.put("D", salvoConfiguration.d);
        salvoMap.put("E", salvoConfiguration.e);
        salvoMap.put("F", salvoConfiguration.f);

    }


    public Game setWinnerIfExist(Game game){
         boolean player_1=true;
         boolean xebialabs_player=true;
        for (GameItem i : game.getGameItems()) {
            User user=userService.getUserFromGameItem(i.getId());
            if (user!= null && user.getName().equals("xebialabs-1")) {
                if (i.getValue().equals("*")){
                    xebialabs_player = false;
                }

            }
            else if(user != null && user.getName().equals("player-1")){
                if(i.getValue().equals("*")){
                    player_1=false;
                }
            }
        }
        if(player_1){
            game.setWinner("xebialabs-1");
            gameService.save(game);
        }
        else if(xebialabs_player){
            game.setWinner("player-1");
            gameService.save(game);
        }
        return game;
    }

    public SalvoResponseDto generateSalvoResponse(SalvoRequestDto salvoRequestDto, Game game, String userName) {



        SalvoResponseDto salvoResponseDto = GenericBuilder.of(SalvoResponseDto::new)
                .with(SalvoResponseDto::setSalvo, new HashMap<String, String>()).build();

        if(setWinnerIfExist(game).getWinner() != null){
            salvoResponseDto.setGame(GenericBuilder.of(PlayerTurnDto::new).with(PlayerTurnDto::setWon ,game.getWinner()).build());
            return salvoResponseDto;
        }
        else{
            salvoResponseDto.setGame(GenericBuilder.of(PlayerTurnDto::new).with(PlayerTurnDto::setPlayer_turn ,game.getPlayerTurn()).build());
        }

        if(!userName.equals(game.getPlayerTurn())){
            return null;
        }



        salvoRequestDto.getSalvo().forEach(i -> {
            String rawSalvo = i;
            String[] salvos = i.split("X|x");
            String row = this.salvoMap.get(salvos[0]);
            String column = this.salvoMap.get(salvos[1]);
            GameItem gameItem = gameItemService.getByRowAndColNo(row, column, game.getId());
            gameItem.setGame(gameService.getGameById(game.getId()));

            if (gameItem.getValue() == null) {
                gameItem.setValue("-");
                salvoResponseDto.getSalvo().put(rawSalvo, "Miss");


            } else if (gameItem.getValue().equals("*")) {
                gameItem.setValue("X");
                salvoResponseDto.getSalvo().put(rawSalvo, "Hit");

            } else {
                salvoResponseDto.getSalvo().put(rawSalvo, "Miss");
            }


            gameItemService.save(gameItem);

            if (userName.equals("xebialabs-1"))
                game.setPlayerTurn("player-1");
            else
                game.setPlayerTurn("xebialabs-1");

            gameService.save(game);


        });
        return salvoResponseDto;
    }

    public Map<String, String> getSalvoMap() {
        return salvoMap;
    }

    public void setSalvoMap(Map<String, String> salvoMap) {
        this.salvoMap = salvoMap;
    }
}

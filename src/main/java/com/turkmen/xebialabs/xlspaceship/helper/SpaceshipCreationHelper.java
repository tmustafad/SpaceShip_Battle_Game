package com.turkmen.xebialabs.xlspaceship.helper;

import com.turkmen.xebialabs.xlspaceship.model.Game;
import com.turkmen.xebialabs.xlspaceship.model.GameItem;
import com.turkmen.xebialabs.xlspaceship.model.User;
import com.turkmen.xebialabs.xlspaceship.service.GameItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;


/**
 * Created by turkmenmustafademirci on 11/12/19.
 */

@Component
public class SpaceshipCreationHelper {


    @Value("${coordinate.slots.1}")
    private String slot_1;

    @Value("${coordinate.slots.2}")
    private String slot_2;

    @Value("${coordinate.slots.3}")
    private String slot_3;

    @Value("${coordinate.slots.4}")
    private String slot_4;

    @Value("${coordinate.slots.5}")
    private String slot_5;

    @Value("${coordinate.slots.6}")
    private String slot_6;

    @Value("${coordinate.slots.7}")
    private String slot_7;

    @Value("${coordinate.slots.8}")
    private String slot_8;

    @Value("${coordinate.slots.9}")
    private String slot_9;

    @Value("${coordinate.slots.10}")
    private String slot_10;

    @Value("${coordinate.formula.winger}")
    private String formula_winger;

    @Value("${coordinate.formula.angle}")
    private String formula_angle;

    @Value("${coordinate.formula.aclass}")
    private String formula_a_class;

    @Value("${coordinate.formula.bclass}")
    private String formula_b_class;

    @Value("${coordinate.formula.sclass}")
    private String formula_s_class;


    @Autowired
    GameItemService gameItemService;

    private List<String> availableSlots = new ArrayList();


    public void createSpaceships(Game game) {
        availableSlots.clear();
        availableSlots.add(slot_1);
        availableSlots.add(slot_2);
        availableSlots.add(slot_3);
        availableSlots.add(slot_4);
        availableSlots.add(slot_5);
        availableSlots.add(slot_6);
        availableSlots.add(slot_7);
        availableSlots.add(slot_8);
        availableSlots.add(slot_9);
        availableSlots.add(slot_10);
        game.getUsers().forEach(u -> {
            create(game, formula_winger, "winger", u);
            create(game, formula_angle, "angle", u);
            create(game, formula_a_class, "aclass", u);
            create(game, formula_b_class, "bclass", u);
            create(game, formula_s_class, "sclass", u);
        });

    }

    public void create(Game game, String formula, String shipName, User user) {
        String slotName = getRandomSlot();

        String[] exploded_slot = slotName.split(" ");
        String[] formula_exploded = formula.split(" ");

        allocateSpaceShip(exploded_slot, formula_exploded, game, shipName, user);
    }


    private void updateGameItem(String row, String col, Game game, User user) {
        GameItem gameItem = gameItemService.getByRowAndColNo(row, col, game.getId());
        gameItem.setAllocated(true);
        gameItem.setGame(game);
        gameItem.setValue("*");
        gameItem.setUser(user);
        gameItemService.save(gameItem);
    }

    private void allocateSpaceShip(String[] exploded_slot, String[] formulaExploded, Game game, String shipName, User user) {

        int tmpColNumber = Integer.valueOf(exploded_slot[1]);
        int tmpRowNumber = Integer.valueOf(exploded_slot[0]);

        if (shipName.equals("aclass") || shipName.equals("sclass"))
            tmpColNumber++;

        updateGameItem(String.valueOf(tmpRowNumber), String.valueOf(tmpColNumber), game, user);


        for (int j = 0; j < formulaExploded.length; j++) {


            if (tmpColNumber + Integer.valueOf(formulaExploded[j]) <= 15) {

                String colNumber = String.valueOf(Integer.valueOf(tmpColNumber) + Integer.valueOf(formulaExploded[j]));


                updateGameItem(String.valueOf(tmpRowNumber), colNumber, game, user);

                tmpColNumber = Integer.valueOf(colNumber);

            } else {
                tmpRowNumber = tmpRowNumber + 1;
                tmpColNumber = (Integer.valueOf(formulaExploded[j]) - (16 - tmpColNumber));
                updateGameItem(String.valueOf(tmpRowNumber), String.valueOf(tmpColNumber), game, user);

            }

        }
    }

    private String getRandomSlot() {

        Collections.shuffle(availableSlots);
        Random rnd = new Random();
        int i = rnd.nextInt(availableSlots.size()>1 ? availableSlots.size() - 1 :availableSlots.size());
        String returnVal = availableSlots.get(i);
        availableSlots.remove(i);


        return returnVal;
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<String> availableSlots) {
        this.availableSlots = availableSlots;
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.game.initiative;

import dmtools.game.entities.DNDEntity;
import java.util.*;

/**
 *
 * @author A3
 */
public class InitiativeTracker {

    private final Map<DNDEntity, Integer> initiatives;
    private final List<DNDEntity> entities;
    private int round, turn;
    public static final int PREVIOUS = 0;
    public static final int CURRENT = 1;
    public static final int NEXT = 2;

    public InitiativeTracker(Map<DNDEntity, Integer> initiatives) {
        this.initiatives = initiatives;
        this.entities = new ArrayList();
        sortByInitiative();
        this.round = 1;
        this.turn = 0;
    }
    
    public int getTurnNumber() {
        return turn;
    }

    public int getRound() {
        return round;
    }

    public DNDEntity getCurrentEntity() {
        return entities.get(turn);
    }

    public List<DNDEntity> getEntityList() {
        return this.entities;
    }

    public void nextTurn() {
        try {
            entities.get(turn + 1);
            turn++;
        } catch (Exception e) {
            round++;
            turn = 0;
        }
    }

    public void prevTurn() {

        try {
            entities.get(turn - 1);
            turn--;
        } catch (Exception e) {
            round--;
            if (round < 1) {
                turn = 0;
                round = 1;
            } else {
                turn = entities.size() - 1;
            }
        }
    }

    public DNDEntity prevCurrentNext(int location) {
        switch (location) {
            //previous
            case PREVIOUS:
                if (turn == 0) {
                    return entities.get(entities.size() - 1);
                } else {
                    return entities.get(turn - 1);
                }

            //current
            case CURRENT:
                return entities.get(turn);

            //next
            case NEXT:
                if (turn == (entities.size() - 1)) {
                    return entities.get(0);
                } else {
                    return entities.get(turn + 1);
                }
        }
        return null;
    }

    private void sortByInitiative() {
        for (DNDEntity i : initiatives.keySet()) {
            entities.add(i);
        }
        Collections.sort(entities, new InitiativeComparator(initiatives));
    }
}

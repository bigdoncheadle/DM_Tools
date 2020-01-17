/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.game.initiative;

import dmtools.game.entities.DNDEntity;
import dmtools.game.entities.PC;
import dmtools.game.entities.numericals.enums.Skill;
import dmtools.game.playableclasses.PlayableClass;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author A3
 */
public class InitiativeTextBasedTool {
    private Scanner reader;
    private InitiativeTracker tracker;
    public InitiativeTextBasedTool() {
        reader = new Scanner(System.in);
    }
    
    public void run() {
        tracker = new InitiativeTracker(getPlayers());
        while (true) {
            displayTurn();
            if (!reader.nextLine().equals("")) {
                break;
            }
            tracker.nextTurn();
        }
    }
    
    private void displayTurn() {
        System.out.println("Round: " + tracker.getRound());
        System.out.println(tracker.getCurrentEntity() + "'s turn!");
        System.out.println("");
    }
    
    private Map<DNDEntity, Integer> getPlayers() {
        Map<DNDEntity, Integer> i = new HashMap<DNDEntity, Integer>();
        
        while (true) {
            System.out.print("Player name? ");
            String name = reader.nextLine();
                if(name.equals("")) {
                    break;
                }
            System.out.print("Initiative? ");
            int initiative = Integer.parseInt(reader.nextLine());
            
//            i.put(new PC(name, 1, name, PlayableClass.BARBARIAN, new HashSet<Skill>()), initiative);
        }
        
        return i;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.game.dice;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author A3
 */
public enum Dice {
    d2(2),
    d3(3),
    d4(4),
    d6(6),
    d8(8),
    d10(10),
    d12(12),
    d20(20),
    d100(100);
    
    private final int numberOfSides;

    private Dice(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }
    
    public int roll(int times) {
        int rollTotal = 0;
        Random r = new Random();
        for(int i = 0; i < times; i ++) {
            rollTotal += r.nextInt(numberOfSides) + 1;
        }
        
        return rollTotal;
    }
    
    public int roll() {
        Random r = new Random();
        return r.nextInt(numberOfSides) + 1;
    }
    
    public int rollWithModifier(int times, int modifier) {
        return this.roll(times) + modifier;
    }
    
    public static int rollMultiDice(List<Dice> d) {
        int rollTotal = 0;
        for (Dice i : d) {
            rollTotal += i.roll();
        }
        return rollTotal;
    }
    
    public static int rollMultiDiceWithModifier(List<Dice> d, int modifier) {
        return rollMultiDice(d) + modifier;
    }
}

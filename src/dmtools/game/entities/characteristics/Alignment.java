/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.game.entities.characteristics;

/**
 *
 * @author A3
 */
public enum Alignment {
    LAWFUL_GOOD("Lawful Good"),
    NEUTRAL_GOOD("Neutral Good"),
    CHAOTIC_GOOD("Chaotic Good"),
    LAWFUL_NEUTRAL("Lawful Neutral"),
    TRUE_NEUTRAL("True Neutral"),
    CHAOTIC_NEUTRAL("Chaotic Neutral"),
    LAWFUL_EVIL("Lawful Evil"),
    NEUTRAL_EVIL("Neutral Evil"),
    CHAOTIC_EVIL("Chaotic Evil");
    private String name;

    private Alignment(String name) {
        this.name = name;
    }
    
    public static Alignment stringValueOf(String name) {
        String fixedName = name.replaceAll(" ", "_");
        return Alignment.valueOf(fixedName.toUpperCase());
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
    
   
}

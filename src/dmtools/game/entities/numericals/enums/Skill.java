/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.game.entities.numericals.enums;

import dmtools.game.entities.numericals.enums.Stat;

/**
 *
 * @author A3
 */
public enum Skill {
    ACROBATICS(Stat.DEX, "Acrobatics"),
    ANIMAL_HANDLING(Stat.WIS, "Animal Handling"),
    ARCANA(Stat.INT, "Arcana"),
    ATHLETICS(Stat.STR, "Athletics"),
    DECEPTION(Stat.CHA, "Deception"),
    HISTORY(Stat.INT, "History"),
    INSIGHT(Stat.WIS, "Insight"),
    INTIMIDATION(Stat.CHA, "Intimidation"),
    INVESTIGATION(Stat.INT, "Investigation"),
    MEDICINE(Stat.WIS, "Medicine"),
    NATURE(Stat.INT, "Nature"),
    PERCEPTION(Stat.WIS, "Perception"),
    PERFORMANCE(Stat.CHA, "Performance"),
    PERSUASION(Stat.CHA, "Persuasion"),
    RELIGION(Stat.INT, "Religion"),
    SLEIGHT_OF_HAND(Stat.DEX, "Sleight of Hand"),
    STEALTH(Stat.DEX, "Stealth"),
    SURVIVAL(Stat.WIS, "Survival");
    private final Stat relevantStat;
    private final String skillName;

    private Skill(Stat s, String name) {
        this.relevantStat = s;
        this.skillName = name;
    }

    public Stat getRelevantStat() {
        return relevantStat;
    }

    @Override
    public String toString() {
        return skillName;
    }

    public static String[] getSkillObjects() {
        String[] returnValue = new String[Skill.values().length];
        for (int i = 0; i < Skill.values().length; i++) {
            returnValue[i] = Skill.values()[i].toString();
        }
        return returnValue;
    }

    public static Skill getSkillFromString(String string) {
        for (Skill i : Skill.values()) {
            if (i.toString().equalsIgnoreCase(string)) {
                return i;
            }
        }
        return null;
    }
}

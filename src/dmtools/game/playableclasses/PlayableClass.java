/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.game.playableclasses;

import dmtools.game.entities.numericals.enums.Skill;
import dmtools.game.entities.numericals.enums.Stat;
import dmtools.game.dice.Dice;
import dmtools.game.entities.numericals.enums.Skill;
import java.util.EnumSet;

/**
 *
 * @author A3
 */
public enum PlayableClass {
    BARBARIAN(
            "Barbarian", 2, Dice.d12,
            EnumSet.of(Stat.STR),
            EnumSet.of(Stat.STR, Stat.CON),
            EnumSet.of(Skill.ANIMAL_HANDLING,
                    Skill.ATHLETICS, Skill.INTIMIDATION, Skill.NATURE,
                    Skill.PERCEPTION, Skill.SURVIVAL)
    ),
    
    BARD(
            "Bard", 3, Dice.d8,
            EnumSet.of(Stat.CHA),
            EnumSet.of(Stat.DEX, Stat.CHA),
            EnumSet.allOf(Skill.class)
    ),
    
    CLERIC(
            "Cleric", 2, Dice.d8,
            EnumSet.of(Stat.WIS),
            EnumSet.of(Stat.WIS, Stat.CHA),
            EnumSet.of(Skill.HISTORY, Skill.INSIGHT, Skill.MEDICINE,
                    Skill.PERSUASION, Skill.RELIGION)
    ),
    
    DRUID(
            "Druid", 2, Dice.d8,
            EnumSet.of(Stat.WIS),
            EnumSet.of(Stat.INT, Stat.WIS),
            EnumSet.of(Skill.ARCANA, Skill.ANIMAL_HANDLING, Skill.INSIGHT,
                    Skill.MEDICINE, Skill.NATURE, Skill.PERCEPTION,
                    Skill.RELIGION, Skill.SURVIVAL)
    ),
    
    FIGHTER(
            "Fighter", 2, Dice.d10,
            EnumSet.of(Stat.STR, Stat.DEX),
            EnumSet.of(Stat.STR, Stat.CON),
            EnumSet.of(Skill.ACROBATICS, Skill.ANIMAL_HANDLING, Skill.ATHLETICS,
                    Skill.HISTORY, Skill.INSIGHT, Skill.INTIMIDATION,
                    Skill.PERCEPTION, Skill.SURVIVAL)
    ),
    
    MONK(
            "Monk", 2, Dice.d8,
            EnumSet.of(Stat.DEX, Stat.WIS),
            EnumSet.of(Stat.STR, Stat.DEX),
            EnumSet.of(Skill.ACROBATICS, Skill.ATHLETICS, Skill.HISTORY, 
                    Skill.INSIGHT, Skill.RELIGION, Skill.STEALTH)
    ),
    
    PALADIN(
            "Paladin", 2, Dice.d10,
            EnumSet.of(Stat.STR, Stat.CHA),
            EnumSet.of(Stat.WIS, Stat.CHA),
            EnumSet.of(Skill.ATHLETICS, Skill.INSIGHT, Skill.INTIMIDATION, 
                    Skill.MEDICINE, Skill.PERSUASION, Skill.RELIGION)
    ),
    
    RANGER(
            "Ranger", 3, Dice.d10,
            EnumSet.of(Stat.DEX, Stat.WIS),
            EnumSet.of(Stat.STR, Stat.DEX),
            EnumSet.of(Skill.ANIMAL_HANDLING, Skill.ATHLETICS, Skill.INSIGHT, 
                    Skill.INVESTIGATION, Skill.NATURE, Skill.PERCEPTION, 
                    Skill.STEALTH, Skill.SURVIVAL)
    ),
    
    ROGUE(
            "Rogue", 4, Dice.d8,
            EnumSet.of(Stat.DEX),
            EnumSet.of(Stat.DEX, Stat.INT),
            EnumSet.of(Skill.ACROBATICS, Skill.ATHLETICS, Skill.DECEPTION, 
                    Skill.INSIGHT, Skill.INTIMIDATION, Skill.INVESTIGATION, 
                    Skill.PERCEPTION, Skill.PERFORMANCE, Skill.PERSUASION, 
                    Skill.SLEIGHT_OF_HAND, Skill.STEALTH)
    ),
    
    SORCERER(
            "Sorcerer", 2, Dice.d6,
            EnumSet.of(Stat.CHA),
            EnumSet.of(Stat.CON, Stat.CHA),
            EnumSet.of(Skill.ARCANA, Skill.DECEPTION, Skill.INSIGHT, 
                    Skill.INTIMIDATION, Skill.PERSUASION, Skill.RELIGION)
    ),
    
    WARLOCK(
            "Warlock", 2, Dice.d8,
            EnumSet.of(Stat.CHA),
            EnumSet.of(Stat.WIS, Stat.CHA),
            EnumSet.of(Skill.ARCANA, Skill.DECEPTION, Skill.HISTORY, 
                    Skill.INTIMIDATION, Skill.INVESTIGATION, Skill.NATURE, 
                    Skill.RELIGION)
    ),
    
    WIZARD(
            "Wizard", 2, Dice.d6,
            EnumSet.of(Stat.INT),
            EnumSet.of(Stat.INT, Stat.WIS),
            EnumSet.of(Skill.ARCANA, Skill.HISTORY, Skill.INSIGHT, 
                    Skill.INVESTIGATION, Skill.MEDICINE, Skill.RELIGION)
    );

    private final String className;
    private final int numberOfSkillSelections;
    private final Dice hitDie;

    private EnumSet<Stat> primaryAbilities;
    private EnumSet<Stat> savingThrowProficiencies;
    private EnumSet<Skill> possibleSkillProficiencies;

    PlayableClass(String className, int numberOfSkillSelections, Dice hitDie,
            EnumSet<Stat> primaryAbilities,
            EnumSet<Stat> savingThrowProficiencies,
            EnumSet<Skill> possibleSkillProficiencies) {
        this.className = className;
        this.numberOfSkillSelections = numberOfSkillSelections;
        this.hitDie = hitDie;
        this.primaryAbilities = primaryAbilities;
        this.savingThrowProficiencies = savingThrowProficiencies;
        this.possibleSkillProficiencies = possibleSkillProficiencies;
    }

    public Dice getHitDie() {
        return hitDie;
    }

    public EnumSet<Stat> getPrimaryAbilities() {
        return primaryAbilities;
    }

    public EnumSet<Stat> getSavingThrowProficiences() {
        return savingThrowProficiencies;
    }

    public EnumSet<Skill> getPossibleSkillProficiencies() {
        return possibleSkillProficiencies;
    }

    public int numberOfSkillSelections() {
        return numberOfSkillSelections;
    }

    @Override
    public String toString() {
        return className;
    }

}

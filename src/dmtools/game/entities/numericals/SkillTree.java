/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.game.entities.numericals;

import dmtools.game.entities.PC;
import dmtools.game.entities.numericals.enums.Skill;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *
 * @author A3
 */
public class SkillTree {

    private EnumMap<Skill, Integer> skillTree;
    private PC owner;

    public SkillTree(PC owner) {
        skillTree = getEmptySkillTree();
        this.owner = owner;
        fillTree();
    }

    public int getSkillValue(Skill skill) {
        return skillTree.get(skill);
    }
    
    public EnumMap<Skill, Integer> getSkillTree() {
        return skillTree;
    }

    private void fillTree() {
        for (Skill i : skillTree.keySet()) {
            if (owner.isSkillProficient(i)) {
                skillTree.put(i,
                        owner.getStatBlock().getModifier(i.getRelevantStat())
                        + owner.getProficiencyBonus());
            } else {
                skillTree.put(i,
                        owner.getStatBlock().getModifier(i.getRelevantStat()));
            }
        }
    }

    private static EnumMap<Skill, Integer> getEmptySkillTree() {
        EnumMap<Skill, Integer> emptyTree = new EnumMap<>(Skill.class);
        emptyTree.put(Skill.ACROBATICS, 0);
        emptyTree.put(Skill.ANIMAL_HANDLING, 0);
        emptyTree.put(Skill.ARCANA, 0);
        emptyTree.put(Skill.ATHLETICS, 0);
        emptyTree.put(Skill.DECEPTION, 0);
        emptyTree.put(Skill.HISTORY, 0);
        emptyTree.put(Skill.INSIGHT, 0);
        emptyTree.put(Skill.INTIMIDATION, 0);
        emptyTree.put(Skill.INVESTIGATION, 0);
        emptyTree.put(Skill.MEDICINE, 0);
        emptyTree.put(Skill.NATURE, 0);
        emptyTree.put(Skill.PERCEPTION, 0);
        emptyTree.put(Skill.PERFORMANCE, 0);
        emptyTree.put(Skill.PERSUASION, 0);
        emptyTree.put(Skill.RELIGION, 0);
        emptyTree.put(Skill.SLEIGHT_OF_HAND, 0);
        emptyTree.put(Skill.STEALTH, 0);
        emptyTree.put(Skill.SURVIVAL, 0);

        return emptyTree.clone();
    }

    @Override
    public String toString() {
        StringBuilder rS = new StringBuilder();
        Iterator<Entry<Skill, Integer>> iterator = skillTree.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<Skill, Integer> entry = iterator.next();
            rS.append(entry.getKey());
            rS.append(": ");
            rS.append(entry.getValue());
            if (iterator.hasNext()) {
                rS.append("\n");
            }
        }

        
        return rS.toString();
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.game.entities;

import dmtools.filehandling.ReadWritable;
import dmtools.game.entities.characteristics.Alignment;
import dmtools.game.entities.characteristics.Race;
import dmtools.game.entities.numericals.SkillTree;
import dmtools.game.entities.numericals.StatBlock;
import dmtools.game.entities.numericals.enums.Skill;
import dmtools.game.entities.numericals.enums.Stat;
import dmtools.game.items.Equpment;
import dmtools.game.items.Wealth;
import dmtools.game.playableclasses.PlayableClass;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author A3
 */
public class PC extends DNDEntity implements ReadWritable{
    private final String playerName;
    private final Race race;
    private Alignment alignment;
    private final PlayableClass pcClass;
    private int characterLevel;
    private final HashSet<Skill> selectedSkills;
    private SkillTree skillTree;
    private Equpment equipment;
    private Wealth wealth;

    
    public PC(String characterName, String playerName, Race race, 
            Alignment alignment, PlayableClass c, int characterLevel, StatBlock statBlock, 
            HashSet<Skill> selectedSkills, int AC, int maxHP, int currentHP) {
        super(characterName, statBlock, AC, maxHP);
        this.playerName = playerName;
        this.race = race;
        this.alignment = alignment;
        this.pcClass = c;
        this.characterLevel = characterLevel;
        this.selectedSkills = selectedSkills;
        this.skillTree = new SkillTree(this);
        super.setCurrentHP(currentHP);
    }

    public String getPlayerName() {
        return playerName;
    }
   
    public PlayableClass getPlayableClass() {
        return this.pcClass;
    }

    public int getCharacterLevel() {
        return characterLevel;
    }
    
    public Alignment getAlignment() {
        return alignment;
    }

    public Race getRace() {
        return race;
    }

    public SkillTree getSkillTree() {
        return skillTree;
    }
    
    public int getPassivePerception() {
        return getSkillCheck(Skill.PERCEPTION) + 10;
    }
    
    public boolean isSkillProficient(Skill skill) {
        return selectedSkills.contains(skill);
    }
    
    public String writeSelectedSkills() {
        StringBuilder sb = new StringBuilder();
        Iterator it = selectedSkills.iterator();
        while (it.hasNext()) {
            Skill s = (Skill) it.next();
            sb.append(s.name());
            if (it.hasNext()) {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
    
    public static String getFilePath(String name) {
        return "User/PCs/" + name.toUpperCase() + ".pc";
    }
    
    @Override
    public int getSavingThrow(Stat stat) {
        if (pcClass.getSavingThrowProficiences().contains(stat)) {
            return statBlock.getModifier(stat) + getProficiencyBonus();
        } else {
            return statBlock.getModifier(stat);
        }
    }
    
    @Override
    public int getSkillCheck(Skill skill) {
        return skillTree.getSkillValue(skill);
    }

    @Override
    public int getProficiencyBonus() {
        return ((this.characterLevel - 1) / 4) + 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append("\n");
        sb.append(this.playerName).append("\n");
        sb.append(this.pcClass).append("\n");
        sb.append(this.statBlock).append("\n");
        sb.append(this.selectedSkills).append("\n");
        sb.append(this.skillTree);
        
        return sb.toString();
    }

    @Override
    public String getFilePath() {
        return "User/PCs/" + this.name.toUpperCase() + ".pc";
    }

    @Override
    public int compareTo(DNDEntity o) {
        return this.name.compareTo(o.name);
    }
    

}

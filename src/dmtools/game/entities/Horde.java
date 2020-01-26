/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.game.entities;

import dmtools.game.entities.numericals.StatBlock;
import dmtools.game.entities.numericals.enums.Skill;
import dmtools.game.entities.numericals.enums.Stat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author A3
 */
public class Horde extends DNDEntity {
    private Map<Integer, Monster> horde;
    private Monster hordeType;
    private int hordeSize;
    private int overallCount;
    
    public Horde(Monster monster,int count) {
        super(monster.getType() + " Horde", new StatBlock(), 
                monster.getAC(), monster.getMaxHP());
        this.hordeType = monster;
        horde = new HashMap();
        for (int i = 1; i <= count; i ++) {
            Monster clone = new Monster(monster.getName() + " " + i, 
                    monster.getType(), monster.getAC(), 
                    monster.getMaxHP(), monster.getCR());
            horde.put(i, clone);
            hordeSize = i;
            overallCount = i;
        }
    }
    
    public Monster getHordeType() {
        return this.hordeType;
    }
    
    public int getSize() {
        return this.hordeSize;
    }
    
    public Monster addMonster() {
        hordeSize ++;
        overallCount ++;
        Monster clone = new Monster(hordeType.getName() + " " + 
                overallCount, hordeType.getType(), hordeType.getAC(), 
                hordeType.getMaxHP(), hordeType.getCR());
        horde.put(overallCount, clone);
        return clone;
    }
    
    public void removeMonster(int monsterNumber) {
        horde.remove(monsterNumber);
        hordeSize --;
    }
    
    public Map<Integer, Monster> getMembers() {
        return this.horde;
    }
    
    public Monster getMonster(int monsterNumber) {
        return this.horde.get(monsterNumber);
    }
    
    public int getCurrentHP(int monsterNumber) {
        return horde.get(monsterNumber).getCurrentHP();
    }
    
    public void setCurrentHP(int currentHP, int monsterNumber) {
        horde.get(monsterNumber).setCurrentHP(currentHP);
    }
    
    @Override
    public int getProficiencyBonus() {
        return 0;
    }

    @Override
    public int getSavingThrow(Stat stat) {
        return super.statBlock.getModifier(stat) + getProficiencyBonus();
    }

    @Override
    public int getSkillCheck(Skill skill) {
        return super.statBlock.getModifier(skill.getRelevantStat());
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append("\n");
        sb.append("Members:");
        sb.append("\n");
        Iterator i = horde.keySet().iterator();
        while(i.hasNext()) {
            int x = (Integer)i.next();
            sb.append(horde.get(x).name);
            if (i.hasNext()) {
                sb.append("\n");
            }
        }
        
        return sb.toString();
    }

    @Override
    public int compareTo(DNDEntity o) {
        return this.name.compareTo(o.name);
    }
}

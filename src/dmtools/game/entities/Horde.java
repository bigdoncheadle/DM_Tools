/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.game.entities;

import dmtools.game.entities.numericals.StatBlock;
import dmtools.game.entities.numericals.enums.Skill;
import dmtools.game.entities.numericals.enums.Stat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A3
 */
public class Horde extends DNDEntity {
    private List<Monster> horde;
    private Monster hordeType;
    public Horde(Monster monster,int count) {
        super(monster.getType() + " Horde", new StatBlock(), 
                monster.getAC(), monster.getMaxHP());
        this.hordeType = monster;
        horde = new ArrayList();
        for (int i = 1; i <= count; i ++) {
            Monster clone = new Monster(monster.getName() + " " + i, 
                    monster.getType(), monster.getAC(), 
                    monster.getMaxHP(), monster.getCR());
            horde.add(clone);
        }
    }
    
    public void addMonster() {
        Monster clone = new Monster(hordeType.getName() + " " + 
                horde.size() + 1, hordeType.getType(), hordeType.getAC(), 
                hordeType.getMaxHP(), hordeType.getCR());
        horde.add(clone);
    }
    
    public void removeMonster(int monsterNumber) {
        horde.remove(monsterNumber - 1);
    }
    
    public List<Monster> getHorde() {
        return this.horde;
    }
    
    public Monster getMonster(int monsterNumber) {
        return this.horde.get(monsterNumber - 1);
    }
    
    public int getCurrentHP(int monsterNumber) {
        return horde.get(monsterNumber - 1).getCurrentHP();
    }
    
    public void setCurrentHP(int currentHP, int monsterNumber) {
        horde.get(monsterNumber - 1).setCurrentHP(currentHP);
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
    public int compareTo(DNDEntity o) {
        return this.name.compareTo(o.name);
    }
    
}

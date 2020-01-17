/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.game.entities;

import dmtools.game.entities.numericals.StatBlock;
import dmtools.game.entities.numericals.enums.Skill;
import dmtools.game.entities.numericals.enums.Stat;

/**
 *
 * @author A3
 */
public abstract class DNDEntity implements Comparable<DNDEntity>{

    protected final String name;
    protected final StatBlock statBlock;
    protected int AC;
    protected final int maxHP;
    protected int currentHP;

    public DNDEntity(String characterName, StatBlock statBlock, int AC,
            int maxHP) {
        this.name = characterName;
        this.statBlock = statBlock;
        this.AC = AC;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }

    public String getName() {
        return this.name;
    }

    public StatBlock getStatBlock() {
        return this.statBlock;
    }

    public int getAC() {
        return AC;
    }

    public void setAC(int AC) {
        this.AC = AC;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
    
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object inQuestion) {
        if (inQuestion == null) {
            return false;
        }

        if (getClass() != inQuestion.getClass()) {
            return false;
        }

        DNDEntity compared = (DNDEntity) inQuestion;
        //put your equals check here as a return false;
        return this.name.equalsIgnoreCase(compared.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() * 29;
    }

    abstract public int getProficiencyBonus();

    abstract public int getSavingThrow(Stat stat);

    abstract public int getSkillCheck(Skill skill);
}

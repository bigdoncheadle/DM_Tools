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

    private Map<Integer, Monster> members;
    private Monster hordeType;
    private int hordeSize;
    private int overallCount;
    private String id;

    public Horde(Monster monster, int count, String id) {
        super(monster.getType() + " Horde", new StatBlock(),
                monster.getAC(), monster.getMaxHP());
        this.hordeType = monster;
        this.id = id;
        members = new HashMap();
        for (int i = 1; i <= count; i++) {
            Monster clone = new Monster(monster.getName() + " " + i,
                    monster.getType(), monster.getAC(),
                    monster.getMaxHP(), monster.getCR());
            members.put(i, clone);
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
        hordeSize++;
        overallCount++;
        Monster clone = new Monster(hordeType.getName() + " "
                + overallCount, hordeType.getType(), hordeType.getAC(),
                hordeType.getMaxHP(), hordeType.getCR());
        members.put(overallCount, clone);
        return clone;
    }

    public void removeMonster(int monsterNumber) {
        members.remove(monsterNumber);
        hordeSize--;
    }

    public Map<Integer, Monster> getMembers() {
        return this.members;
    }

    public Monster getMonster(int monsterNumber) {
        return this.members.get(monsterNumber);
    }

    public int getCurrentHP(int monsterNumber) {
        return members.get(monsterNumber).getCurrentHP();
    }

    public void setCurrentHP(int currentHP, int monsterNumber) {
        members.get(monsterNumber).setCurrentHP(currentHP);
    }

    public String getUniqueName() {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(name);
        sb1.append(id);
        return sb1.toString();
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
        sb.append("ID: ");
        sb.append(id);
        sb.append("\n");
        sb.append("Members:");
        sb.append("\n");
        Iterator i = members.keySet().iterator();
        while (i.hasNext()) {
            int x = (Integer) i.next();
            sb.append(members.get(x).name);
            if (i.hasNext()) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object inQuestion) {
        if (inQuestion == null) {
            return false;
        }

        if (getClass() != inQuestion.getClass()) {
            return false;
        }

        Horde compared = (Horde) inQuestion;
     

        return getUniqueName().equals(compared.getUniqueName());
    }

    @Override
    public int compareTo(DNDEntity o) {
        if (o.getClass() == Horde.class) {
            Horde h = (Horde) o;
            return getUniqueName().compareToIgnoreCase(h.getUniqueName());
        } else {
            return name.compareToIgnoreCase(o.getName());
        }
    }
}

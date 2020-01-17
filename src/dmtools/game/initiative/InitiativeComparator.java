/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.game.initiative;

import dmtools.game.entities.DNDEntity;
import dmtools.game.entities.numericals.enums.Stat;
import java.util.Comparator;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author A3
 */
public class InitiativeComparator implements Comparator<DNDEntity>{
    private Map<DNDEntity, Integer> entityInitiatives;

    public InitiativeComparator(Map<DNDEntity, Integer> entityInitiatives) {
        this.entityInitiatives = entityInitiatives;
    }
    
    
    @Override
    public int compare(DNDEntity e1, DNDEntity e2) {
        Random r = new Random();
        int[] randomReturnValue = {-1, 1};
        if (entityInitiatives.get(e1).equals( entityInitiatives.get(e2))) {
            if (e1.getStatBlock().getStat(Stat.DEX) != 
                    e2.getStatBlock().getStat(Stat.DEX)) {
                return e2.getStatBlock().getStat(Stat.DEX) - 
                        e1.getStatBlock().getStat(Stat.DEX);
            }
            return randomReturnValue[r.nextInt(2)];
        }
        return entityInitiatives.get(e2) - entityInitiatives.get(e1);
    }
    
}

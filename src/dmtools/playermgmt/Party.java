/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.playermgmt;

import dmtools.filehandling.ReadWritable;
import dmtools.game.entities.DNDEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 *
 * @author A3
 */
public abstract class Party implements ReadWritable{

    protected ArrayList<DNDEntity> party;
    private String name;

    public Party(String name) {
        this.name = name;
        this.party = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public ArrayList<DNDEntity> getMembers() {
        return party;
    }

    public void add(DNDEntity e) {
        party.add(e);
        Collections.sort(party);
    }

    public void remove(DNDEntity e) {
        if (party.contains(e)) {
            party.remove(e);
        }
    }

    public boolean containsEntity(DNDEntity e) {
        return party.contains(e);
    }
}

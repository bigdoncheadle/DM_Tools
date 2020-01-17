/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.playermgmt;

import dmtools.filehandling.ReadWritable;
import dmtools.game.entities.PC;
import java.util.TreeSet;

/**
 *
 * @author A3
 */
public class PlayerParty extends Party implements ReadWritable {

    public PlayerParty(String name, TreeSet<PC> party) {
        super(name);
        for (PC i : party) {
            super.add(i);
        }
    }

    public PlayerParty(String name) {
        super(name);
    }
    
    public static String getFilePath(String name) {
        return "User/Parties/" + name.toUpperCase() + ".pty";
    }
    
    @Override
    public String getFilePath() {
        return "User/Parties/" + super.getName().toUpperCase() + ".pty";
    }
}

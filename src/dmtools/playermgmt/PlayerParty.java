/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.playermgmt;

import dmtools.filehandling.ReadWritable;
import dmtools.game.entities.DNDEntity;
import dmtools.game.entities.PC;
import java.util.ArrayList;

/**
 *
 * @author A3
 */
public class PlayerParty extends Party implements ReadWritable {

    public PlayerParty(String name, ArrayList<PC> party) {
        super(name);
        for (PC i : party) {
            super.add(i);
        }
    }

    public PlayerParty(String name) {
        super(name);
    }
    
    
    @Override
    public String getFilePath() {
        return "Campaigns/default/party.pty";
    }
    
    public static String getPartyPath() {
        return "Campaigns/default/party.pty";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Party: ");
        sb.append(name);
        sb.append("\n");
        sb.append("Members: \n");
        for (DNDEntity i : party) {
            sb.append(i.getName());
            sb.append("\n");
        }
        return sb.toString();
    }
    
    
}

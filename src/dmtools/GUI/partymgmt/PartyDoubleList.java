/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.partymgmt;

import dmtools.filehandling.BatchFileHandler;
import dmtools.game.entities.DNDEntity;
import dmtools.game.entities.PC;
import dmtools.playermgmt.PlayerParty;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author A3
 */
public class PartyDoubleList extends DoubleList{

    private PlayerParty party;

    public PartyDoubleList(PlayerParty party) {
        super(new HashMap<String, Object>());
        this.party = party;
        constructDoubleList();
        jListB.requestFocus();
        jListB.setSelectedIndex(0);
    }

    public void changePartyName(String newName) {
        labelB.setText("Party: " + newName);
    }

    public PlayerParty getUpdatedParty() {
        this.party = new PlayerParty(
                labelB.getText().split(":")[1].trim());
        for (Object i : super.getListBObjects()) {
            this.party.add((PC) i);
        }

        return this.party;
    }

    private void constructDoubleList() {
        super.setLabelA("Available Players");
        super.setLabelB("Party: " + party.getName());

        BatchFileHandler batch = new BatchFileHandler();
        try {
            ArrayList<PC> allPCs = batch.loadAllPcs();
            boolean shouldSwap;
            for (PC i : allPCs) {
                if (party.containsEntity(i)){
                    shouldSwap = true;
                } else {
                    shouldSwap = false;
                }
                    
                super.addObject(i, getListing(i), shouldSwap);
            }
        } catch (Exception e) {
        }
    }

    private String getListing(PC pc) {
        StringBuilder sb = new StringBuilder();
        sb.append(pc.getName());
        sb.append(" (");
        sb.append(pc.getPlayerName());
        sb.append(")");
        return sb.toString();
    }
}

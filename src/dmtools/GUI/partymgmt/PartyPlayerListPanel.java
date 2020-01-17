/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.partymgmt;

import dmtools.game.entities.DNDEntity;
import dmtools.game.entities.PC;
import dmtools.playermgmt.PlayerParty;
import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.TreeSet;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author A3
 */
public class PartyPlayerListPanel extends JPanel
        implements ListSelectionListener {

    private JList players;
    private DefaultListModel listModel;
    private PlayerParty party;
    private HashMap<String, PC> playerMap;

    public PartyPlayerListPanel(PlayerParty party) {
        super();
        this.party = party;
        setLayout(new GridBagLayout());

        refreshList();
        players = new JList(listModel);
        players.setLayoutOrientation(JList.VERTICAL);
        players.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        players.addListSelectionListener(this);
        players.setSelectedIndex(0);
        players.setVisibleRowCount(0);

        add(players);
    }

    public PC getSelectedPC() {
        return playerMap.get(getPcNameFromListing());
    }
    
    public void addPC(PC pc) {
        party.add(pc);
        playerMap.put(pc.getName(), pc);
        listModel.add(getCorrectIndex(pc), pc.getName() + "(" + 
                pc.getPlayerName() + ")");
        players.setSelectedIndex(getCorrectIndex(pc));
    }
    
    public void removePC() {
        String pcName = getPcNameFromListing();
        PC toRemove = (PC)playerMap.get(pcName);
        party.remove(toRemove);
        playerMap.remove(pcName);
        players.setSelectedIndex(0);
        listModel.removeElement(players.getSelectedValue());
    }
    
    public void updatePC (PC oldVersion, PC newVersion) {
        party.remove(oldVersion);
        party.add(newVersion);
        refreshList();
    }

    private void refreshList() {
        listModel = new DefaultListModel();
        playerMap = new HashMap();
        for (DNDEntity i : party.getMembers()) {
            PC j = (PC) i;
            listModel.addElement(j.getName() + " (" + j.getPlayerName() + ")");
            playerMap.put(j.getName(), j);
        }
    }
    
    private int getCorrectIndex(PC pc) {
        return party.getMembers().indexOf(pc);
    }
    
    private String getPcNameFromListing() {
        String currentPcListing = (String) players.getSelectedValue();
        return currentPcListing.split(" ")[0];
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (players.getSelectedIndex() == -1) {
                //No selection
                

            } else {
                //Selection
                
            }
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String i : playerMap.keySet()) {
            sb.append(i);
            sb.append(": ");
            sb.append(playerMap.get(i).getName());
            sb.append("\n");
        }
        return sb.toString();
    }
}

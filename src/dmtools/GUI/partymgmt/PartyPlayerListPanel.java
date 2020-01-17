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
        playerMap = new HashMap();
        listModel = new DefaultListModel();
        setLayout(new GridBagLayout());

        addComponents();
        players = new JList(listModel);
        players.setLayoutOrientation(JList.VERTICAL);
        players.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        players.addListSelectionListener(this);
        players.setSelectedIndex(0);
        players.setVisibleRowCount(0);

        add(players);
    }

    private void addComponents() {
        for (DNDEntity i : party.getMembers()) {
            PC j = (PC) i;
            listModel.addElement(j.getName() + " (" + j.getPlayerName() + ")");
            playerMap.put(j.getName(), j);
        }
    }
    
    public PC getSelectedPC() {
        String currentPcName = (String) players.getSelectedValue();
        return playerMap.get(currentPcName);
    }
    
    public void removePC() {
        PC toRemove = (PC)playerMap.get((String)players.getSelectedValue());
        party.remove(toRemove);
        playerMap.remove((String)players.getSelectedValue());
        listModel.removeElement(players.getSelectedValue());
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
}

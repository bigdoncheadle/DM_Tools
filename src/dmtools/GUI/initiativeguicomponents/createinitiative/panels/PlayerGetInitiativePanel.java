/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.initiativeguicomponents.createinitiative.panels;

import dmtools.playermgmt.PlayerParty;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author A3
 */
public class PlayerGetInitiativePanel extends JPanel {
    private PlayerParty party;
    private JLabel header;

    public PlayerGetInitiativePanel(PlayerParty party) {
        this.party = party;
        createComponents();
    }
    
    private void createComponents() {
        
    }
}

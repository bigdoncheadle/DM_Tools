/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.partymgmt;

import dmtools.playermgmt.PlayerParty;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author A3
 */
public class PartyMgmtPanel extends JPanel{
    private PlayerParty party;

    public PartyMgmtPanel(PlayerParty party) {
        super();
        this.party = party;
        
        PartyPlayerListPanel playerList = new PartyPlayerListPanel(party);
        add(playerList);
        PartyMgmtButtonPanel partyButtons = new PartyMgmtButtonPanel(playerList);
        add(partyButtons);
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.initiativeguicomponents.createinitiative.panels;

import dmtools.game.entities.PC;
import dmtools.playermgmt.Party;
import dmtools.playermgmt.PlayerParty;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author A3
 */
public class PlayerGetInitiativePanel extends JPanel {

    private PlayerParty party;
    private JLabel header;
    private HashMap<PC, JTextField> inputs;

    public PlayerGetInitiativePanel(PlayerParty party) {
        this.party = party;
        this.inputs = new HashMap();
        createComponents();
    }

    private void createComponents() {
        setLayout(new GridBagLayout());

        // Header
        header = new JLabel(party.getName());
        header.setFont(header.getFont().deriveFont(Font.BOLD, 20f));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(5, 5, 0, 5);
        c.anchor = GridBagConstraints.CENTER;
        add(header, c);
        
        // Each Player
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        
        Iterator it = party.getMembers().iterator();
        while (it.hasNext()) {
            c.gridy++;

            // Label
            c.weightx = 1;
            c.gridx = 0;
            c.anchor = GridBagConstraints.FIRST_LINE_END;
            if (!it.hasNext()) {
                c.insets = new Insets(5, 5, 5, 5);
            } else {
                c.insets = new Insets(5, 5, 0, 5);
            }
            PC pc = (PC) it.next();
            JLabel label = new JLabel(pc.getName());
            this.add(label, c);

            // TextField
            c.gridx = 1;
            c.anchor = GridBagConstraints.LINE_START;
            if (!it.hasNext()) {
                c.insets = new Insets(5, 0, 5, 5);
            } else {
                c.insets = new Insets(5, 0, 0, 5);
            }
            JTextField tf = new JTextField(2);
            inputs.put(pc, tf);
            this.add(tf, c);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.initiativeguicomponents.getinitiative.panels;

import dmtools.GUI.LayoutConstants;
import dmtools.game.entities.DNDEntity;
import dmtools.game.entities.PC;
import dmtools.playermgmt.PlayerParty;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
    private HashMap<PC, JLabel> labels;
    private int fillerY;

    public PlayerGetInitiativePanel(PlayerParty party) {
        this.party = party;
        this.inputs = new HashMap();
        this.labels = new HashMap();
        createComponents();
    }
    
    public Map<DNDEntity, Integer> getInitiatives() 
            throws IllegalArgumentException{
        Map<DNDEntity, Integer> initiatives = new HashMap();
        for (PC i : inputs.keySet()) {
            try {
                int ini = Integer.parseInt(inputs.get(i).getText());
                initiatives.put(i, ini);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid initiative found");
            }
        }
        
        return initiatives;
    }

    public boolean hasValidInfo() {
        boolean isValid = true;
        for (PC i : inputs.keySet()) {
            if (inputs.get(i).getText().equals("")) {
                highlight(i, true);
                isValid = false;
            } else {
                try {
                    Integer.parseInt(inputs.get(i).getText());
                    highlight(i, false);
                } catch (NumberFormatException e) {
                    highlight(i, true);
                    isValid = false;
                }
            }
        }

        return isValid;
    }
    
    protected void updateParty(PlayerParty party) {
        // Gets existing typed text
        HashMap<PC, String> typedText = new HashMap();
        for (PC i : inputs.keySet()) {
            typedText.put(i, inputs.get(i).getText());
        }
        
        // Updates the panel
        this.party = party;
        removeAll();
        this.inputs = new HashMap();
        this.labels = new HashMap();
        createComponents();
        
        // Refills pre-typed initiatives
        for (PC i : typedText.keySet()) {
            if (inputs.containsKey(i)) {
                inputs.get(i).setText(typedText.get(i));
            }
        }
    }

    private void highlight(PC pc, boolean shouldColor) {
        if (shouldColor) {
            labels.get(pc).setForeground(Color.red);
        } else {
            labels.get(pc).setForeground(null);
        }
    }

    private void createComponents() {
        setLayout(new GridBagLayout());
        setBackground(LayoutConstants.BEIGE);

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
        fillerY = c.gridy + 1;

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
            labels.put(pc, label);
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
            fillerY = c.gridy + 1;
        }

        // Filler
        JPanel filler = new JPanel();
        filler.setBackground(getBackground());
//        filler.setBackground(Color.red);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = fillerY;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 0.1;
        add(filler, c);
    }
}

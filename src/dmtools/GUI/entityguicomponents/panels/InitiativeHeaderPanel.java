/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.entityguicomponents.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author A3
 */
public class InitiativeHeaderPanel extends JPanel{
    private final int initiative;

    public InitiativeHeaderPanel(int initiative) {
        super(new GridBagLayout());
        this.initiative = initiative;
        
        JLabel initHeader = new JLabel("Initiative: ");
        JLabel initiativeValue = new JLabel("" + this.initiative);
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        add(initHeader, c);
        c.gridx = 1;
        add(initiativeValue, c);
    }
    
    
}

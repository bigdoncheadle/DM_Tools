/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.entityguicomponents.panels;

import dmtools.GUI.LayoutConstants;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author A3
 */
public class PlayerNamePanel extends JPanel{
    private JLabel name;
    public PlayerNamePanel(String playerName) {
        super();
        setBackground(LayoutConstants.SUB_PANEL_COLOR);
        name = new JLabel("Player: " + playerName);
        name.setForeground(LayoutConstants.CHARCOAL);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        
        add(name, c);
    }
    
}

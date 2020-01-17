/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.entityguicomponents.panels;

import dmtools.GUI.LayoutConstants;
import dmtools.game.entities.PC;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author A3
 */
public class RaceAndPlayableClassPanel extends JPanel {
    private JLabel raceAndClassName;
    public RaceAndPlayableClassPanel(PC pc) {
                super();
        setBackground(LayoutConstants.SUB_PANEL_COLOR);
        raceAndClassName = new JLabel(pc.getRace().toString() + " " + 
                pc.getPlayableClass().toString() + " (Lvl: " + 
                pc.getCharacterLevel() + ")");
        raceAndClassName.setForeground(LayoutConstants.RED);
        raceAndClassName.setFont(raceAndClassName.getFont().deriveFont(Font.ITALIC, 18f));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        
        add(raceAndClassName, c);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.main;

import dmtools.GUI.LayoutConstants;
import dmtools.playermgmt.PlayerParty;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;

/**
 *
 * @author A3
 */
public class MainPanel extends JPanel {

    private final NavigationPanel nav;
    private final DisplayPanel display;

    public MainPanel(String version, PlayerParty party) {
        this.display = new DisplayPanel(version, party);
        this.nav = new NavigationPanel(display);
        createComponents();

        /*
        * For testing purposes only
        */
       
        /*
        *           END TESTING SECTION
        */
        
    }
    
    private void createComponents() {
        setBackground(LayoutConstants.MAIN_PANEL_COLOR);
        setLayout(new GridBagLayout());
        
        // Display panel
        GridBagConstraints navC = new GridBagConstraints();
        navC.gridx = 0;
        navC.gridy = 0;
        navC.weighty = 1;
        navC.fill = GridBagConstraints.VERTICAL;
        add(nav, navC);

        // Display panel
        GridBagConstraints iniC = new GridBagConstraints();
        iniC.gridx = 1;
        iniC.gridy = 0;
        iniC.weightx = 1;
        iniC.weighty = 0.5;
        iniC.fill = GridBagConstraints.BOTH;
        iniC.insets = new Insets(0, 10, 0, 0);
        add(display, iniC);
    }
}

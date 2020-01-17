/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.main;

import dmtools.GUI.LayoutConstants;
import dmtools.GUI.initiativeguicomponents.panels.masterpanels.EncounterPanel;
import dmtools.GUI.main.panels.NavigationPanel;
import dmtools.filehandling.FileHandler;
import dmtools.game.entities.DNDEntity;
import dmtools.game.entities.PC;
import dmtools.game.initiative.InitiativeTracker;
import dmtools.playermgmt.PlayerParty;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import resources.testing.TestingEntities;

/**
 *
 * @author A3
 */
public class MainPanel extends JPanel {

    private final NavigationPanel nav;

    public MainPanel() {
        setBackground(LayoutConstants.MAIN_PANEL_COLOR);
        setLayout(new GridBagLayout());
        nav = new NavigationPanel();

        //for testing purposes only
        Map<DNDEntity, Integer> entities = new HashMap();
        entities.put(TestingEntities.TESTING_PC1, 1);
        entities.put(TestingEntities.TESTING_PC2, 2);

        InitiativeTracker iTrack = new InitiativeTracker(entities);

        PlayerParty pParty = new PlayerParty("Test Party");
        pParty.add(TestingEntities.TESTING_PC1);
        pParty.add(TestingEntities.TESTING_PC2);
        try {
            pParty.add((PC) FileHandler.loadFromName("Cooper", FileHandler.PC_FILE));
            pParty.add((PC) FileHandler.loadFromName("Bertha", FileHandler.PC_FILE));
        } catch (Exception e) {
            System.out.println("oopsie doopsie");
        }

        EncounterPanel ePanel = new EncounterPanel(iTrack);
        
        /*
        *           END TESTING SECTION
        */
        
        //navigation panel
        GridBagConstraints navC = new GridBagConstraints();
        navC.gridx = 0;
        navC.gridy = 0;
        navC.weighty = 1;
        navC.fill = GridBagConstraints.VERTICAL;
        add(nav, navC);

        //encounter panel
        GridBagConstraints iniC = new GridBagConstraints();
        iniC.gridx = 1;
        iniC.gridy = 0;
        iniC.weightx = 1;
        iniC.weighty = 0.5;
        iniC.fill = GridBagConstraints.BOTH;
        iniC.insets = new Insets(0, 10, 0, 0);
        add(ePanel, iniC);
    }
}

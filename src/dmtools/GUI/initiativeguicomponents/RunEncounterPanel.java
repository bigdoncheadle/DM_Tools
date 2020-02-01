/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.initiativeguicomponents;

import dmtools.GUI.LayoutConstants;
import dmtools.GUI.initiativeguicomponents.panels.InitiativeButtonPanel;
import dmtools.GUI.initiativeguicomponents.panels.InitiativeEntityCardPanel;
import dmtools.GUI.initiativeguicomponents.panels.InitiativePlayerListPanel;
import dmtools.game.initiative.InitiativeTracker;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author A3
 */
public class RunEncounterPanel extends JPanel{
    private final InitiativeTracker iTrack;
    private final InitiativeButtonPanel buttonPanel;
    private final InitiativePlayerListPanel playerList;
    private final InitiativeEntityCardPanel cardPanel;
    
    public RunEncounterPanel(InitiativeTracker iTrack) {
        this.iTrack = iTrack;
        this.playerList = new InitiativePlayerListPanel(iTrack);
        this.cardPanel = new InitiativeEntityCardPanel(iTrack);
        this.buttonPanel = new InitiativeButtonPanel(iTrack, playerList, 
                cardPanel);
        
        createComponents();
    }
    
    private void createComponents() {
        setLayout(new GridBagLayout());
        setBackground(LayoutConstants.MAIN_PANEL_COLOR);
        
        //Player List
        GridBagConstraints listC = new GridBagConstraints();
        listC.gridx = 0;
        listC.gridy = 0;
        listC.fill = GridBagConstraints.VERTICAL;
        listC.insets = new Insets(10, 10, 0, 0);
        
        
        //Player Cards
        GridBagConstraints cardC = new GridBagConstraints();
        cardC.gridx = 1;
        cardC.gridy = 0;
        cardC.insets = new Insets(10, 10, 0, 10);

        //Dead Space
        GridBagConstraints spaceC = new GridBagConstraints();
        spaceC.gridx = 2;
        spaceC.gridy = 0;
        spaceC.weightx = 1;
        add(new JLabel("More features soon"), spaceC);
        
        //Button Panel
        GridBagConstraints buttonC = new GridBagConstraints();
        buttonC.gridx = 0;
        buttonC.gridy = 1;
        buttonC.gridwidth = 3;
        buttonC.fill = GridBagConstraints.HORIZONTAL;
        buttonC.insets = new Insets(5, 10, 5, 10);
        
        add(playerList, listC);
        add(cardPanel, cardC);
        add(buttonPanel, buttonC);
    }
}

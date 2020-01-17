/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.entityguicomponents.panels.masterpanels;

import dmtools.GUI.LayoutConstants;
import dmtools.GUI.entityguicomponents.labels.NameCard;
import dmtools.GUI.entityguicomponents.panels.ACPanel;
import dmtools.GUI.entityguicomponents.panels.HPPanel;
import dmtools.GUI.entityguicomponents.panels.RaceAndPlayableClassPanel;
import dmtools.GUI.entityguicomponents.panels.PlayerNamePanel;
import dmtools.GUI.entityguicomponents.panels.SkillPanel;
import dmtools.GUI.entityguicomponents.panels.StatBlockPanel;
import dmtools.game.entities.PC;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;

/**
 *
 * @author A3
 */
public class PCPanel extends JPanel {

    private PC pc;

    public PCPanel(PC pc) {
        this.pc = pc;
        setLayout(new GridBagLayout());
        setBackground(LayoutConstants.PLAYER_CARD_COLOR);
        /*
        *
        * This is where all of the components for 
        * the player card are setup.
        *
        */
        Insets defaultInsets = new Insets(5, 10, 10, 10);
        
        //Character Name
        NameCard nameCard = new NameCard(pc.getName());
        GridBagConstraints nameC = new GridBagConstraints();
        
        nameC.gridx = 0;
        nameC.gridy = 0;
        nameC.anchor = GridBagConstraints.LAST_LINE_START;
        nameC.insets = new Insets(5, 10, 0, 10);
        
        //Playable class and race
        RaceAndPlayableClassPanel playClassPanel = new RaceAndPlayableClassPanel(pc);
        GridBagConstraints playC = new GridBagConstraints();
        playC.gridx = 0;
        playC.gridy = 1;
        playC.anchor = GridBagConstraints.FIRST_LINE_START;
        playC.insets = new Insets(0, 10, 0, 10);
        
        //Player Name
        PlayerNamePanel playerName = new PlayerNamePanel(pc.getPlayerName());
        GridBagConstraints pNameC = new GridBagConstraints();
        
        pNameC.anchor = GridBagConstraints.FIRST_LINE_START;
        pNameC.gridx = 0;
        pNameC.gridy = 2;
        pNameC.insets = new Insets (0, 10, 10, 10);
        
        //Armor Class
        ACPanel armorClass = new ACPanel(pc.getAC());
        GridBagConstraints armorC = new GridBagConstraints(); 
        
        armorC.anchor = GridBagConstraints.LINE_START;
        armorC.gridx = 0;
        armorC.gridy = 4;
        armorC.insets = defaultInsets;
        
        //HP
        HPPanel hp = new HPPanel(pc.getMaxHP(), pc.getCurrentHP());
        GridBagConstraints hpC = new GridBagConstraints();
        
        hpC.anchor = GridBagConstraints.LINE_START;
        hpC.gridx = 0;
        hpC.gridy = 3;
        hpC.insets = defaultInsets;
        
        //StatBlock
        StatBlockPanel statBlock = new StatBlockPanel(pc.getStatBlock());
        GridBagConstraints statC = new GridBagConstraints();
        
        statC.anchor = GridBagConstraints.LINE_START;
        statC.gridx = 0;
        statC.gridy = 5;
        statC.insets = defaultInsets;
        
        //Skill Tree
        SkillPanel skillTree = new SkillPanel(pc.getSkillTree());
        GridBagConstraints skillC = new GridBagConstraints();
        
        skillC.gridx = 1;
        skillC.gridy = 2;
        skillC.gridheight = 5;
        skillC.insets = defaultInsets;
                
                
        /*
        *
        * Adds the components to the PC Panel
        *
        */
        
        add(nameCard, nameC);
        add(playClassPanel, playC);
        add(playerName, pNameC);
        add(armorClass, armorC);
        add(hp, hpC);
        add(statBlock, statC);
        add(skillTree, skillC);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.entityguicomponents.panels.masterpanels;

import dmtools.GUI.LayoutConstants;
import dmtools.GUI.entityguicomponents.panels.ACPanel;
import dmtools.GUI.entityguicomponents.panels.CRPanel;
import dmtools.GUI.entityguicomponents.panels.HPPanel;
import dmtools.game.entities.Monster;
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
public class MonsterPanel extends JPanel{
    private Monster monster;

    public MonsterPanel(Monster monster) {
        super();
        this.monster = monster;
    
        setLayout(new GridBagLayout());
        setBackground(LayoutConstants.BEIGE);
        
        /*
        * All of the components are laid out
        */
        
        //Name
        JLabel monsterNameLabel = new JLabel(monster.getName());
        Font nameFont = monsterNameLabel.getFont().deriveFont(25f);
        monsterNameLabel.setFont(nameFont);
        monsterNameLabel.setForeground(LayoutConstants.DARKOAL);
        GridBagConstraints nameC = new GridBagConstraints();
        nameC.gridx = 0;
        nameC.gridy = 0;
        nameC.gridwidth = 2;
        nameC.anchor = GridBagConstraints.PAGE_START;
        nameC.insets = new Insets(5, 5, 5, 5);
        add(monsterNameLabel, nameC);
        
        //CR
        CRPanel crLabel = new CRPanel(monster.getCR());
        GridBagConstraints crC= new GridBagConstraints();
        crC.gridx = 0;
        crC.gridy = 1;
        crC.fill = GridBagConstraints.HORIZONTAL;
        crC.anchor = GridBagConstraints.CENTER;
        add(crLabel, crC);
        
        //AC
        ACPanel acPanel = new ACPanel(monster.getAC());
        GridBagConstraints acC = new GridBagConstraints();
        acC.gridx = 0;
        acC.gridy = 2;
        acC.fill = GridBagConstraints.HORIZONTAL;
        add(acPanel, acC);
        
        //HP
        HPPanel hpPanel = new HPPanel(monster.getMaxHP(), 
                monster.getCurrentHP());
        GridBagConstraints hpC = new GridBagConstraints();
        hpC.gridx = 1;
        hpC.gridy = 1;
        hpC.gridheight = 2;
        hpC.fill = GridBagConstraints.HORIZONTAL;
        add(hpPanel, hpC);
        
        //Width Filler
//        JPanel lwFill = new JPanel();
//        GridBagConstraints wFillC = new GridBagConstraints();
//        wFillC.gridx = 0;
//        wFillC.gridy = 0;
//        wFillC.gridheight = 5;
//        wFillC.weightx = 1.0;
//        add(lwFill, wFillC);
        
        //Width Filler
//        JPanel rwFill = new JPanel();
//        GridBagConstraints rwFillC = new GridBagConstraints();
//        rwFillC.gridx = 3;
//        rwFillC.gridy = 0;
//        rwFillC.gridheight = 5;
//        rwFillC.weightx = 1.0;
//        add(rwFill, rwFillC);
        
        //Height filler
        JPanel hFill = new JPanel();
        hFill.setBackground(LayoutConstants.BEIGE);
        GridBagConstraints hFillC = new GridBagConstraints();
        hFillC.gridx = 1;
        hFillC.gridy = 4;
        hFillC.weighty = 1;
        add(hFill, hFillC);
    }
    
}

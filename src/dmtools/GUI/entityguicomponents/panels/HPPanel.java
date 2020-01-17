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
import javax.swing.JTextField;

/**
 *
 * @author A3
 */
public class HPPanel extends JPanel{
    private int HP;
    private int currentHP;
    private float fontSize = 14f;

    public HPPanel(int HP, int currentHP) {
        super(new GridBagLayout());
        this.HP = HP;
        this.currentHP = currentHP;
        setBackground(LayoutConstants.BEIGE);
        JLabel maxHeading = new JLabel("HP:");
        maxHeading.setForeground(LayoutConstants.GREEN);
        JLabel maxHP = new JLabel("" + this.HP);
        JTextField currentField = new JTextField("" + currentHP);
        currentField.setEditable(true);
        currentField.setColumns(4);
        
        
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        add(maxHeading, c);
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5, 0, 5, 5);
        add(maxHP, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.insets = new Insets(0, 5, 5, 5);
        add(currentField, c);

    }
    
    
}

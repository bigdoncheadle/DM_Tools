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
public class PassivePerceptionPanel extends JPanel{

    private final int passivePerception;

    public PassivePerceptionPanel(int passivePerception) {

        super(new GridBagLayout());
        this.passivePerception = passivePerception;

        JLabel perHeader = new JLabel("Perception(Passive): ");
        JLabel perValue = new JLabel("" + this.passivePerception);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        add(perHeader, c);
        c.gridx = 1;
        add(perValue, c);
    }
}

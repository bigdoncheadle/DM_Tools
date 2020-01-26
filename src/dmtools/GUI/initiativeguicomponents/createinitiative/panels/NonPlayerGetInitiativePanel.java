/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.initiativeguicomponents.createinitiative.panels;

import dmtools.game.entities.DNDEntity;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author A3
 */
public class NonPlayerGetInitiativePanel extends JPanel {

    private Map<DNDEntity, JTextField> inputs;
    private int workingGridY;

    public NonPlayerGetInitiativePanel() {
        super();
        inputs = new HashMap();
        workingGridY = 1;
        createComponents();
    }

    public void add(DNDEntity e) {
        GridBagConstraints c;

        // Label
        JLabel name = new JLabel(e.getName());
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = workingGridY;
        c.weightx = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        c.insets = new Insets(5, 5, 0, 5);
        add(name, c);

        // TextField
        JTextField tf = new JTextField(2);
        inputs.put(e, tf);
        
        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 0, 0, 5);
        add(tf, c);
        
        workingGridY++;
        revalidate();
        repaint();
    }

    private void createComponents() {
        setLayout(new GridBagLayout());
        JLabel header = new JLabel("Non Players");
        header.setFont(header.getFont().deriveFont(Font.BOLD, 20f));

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(5, 5, 0, 5);
        add(header, c);
    }
}

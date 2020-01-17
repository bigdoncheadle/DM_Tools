/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.entityguicomponents.panels;

import dmtools.GUI.LayoutConstants;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author A3
 */
public class ACPanel extends JPanel{
    private int acValue;
    private final Dimension size = new Dimension(75, 30);
    private final float acFontSize = 20f;
    private final float valueFontSize = 20f;

    public ACPanel(int acValue) {
        super(new GridBagLayout());
        this.acValue = acValue;

        GridBagConstraints c = new GridBagConstraints();
        
        JLabel ac = new JLabel("AC: ");
        ac.setFont(getFont().deriveFont(acFontSize));
        ac.setForeground(LayoutConstants.RED);
        JLabel value = new JLabel("" + acValue);
        value.setFont(getFont().deriveFont(valueFontSize));
        
        setBackground(LayoutConstants.BEIGE);
        setMinimumSize(size);
        setMaximumSize(size);
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(2, 5, 2, 0);
        add(ac, c);
        c.gridx = 1;
        c.insets = new Insets(2, 5, 2, 5);
        add(value, c);
    }
}

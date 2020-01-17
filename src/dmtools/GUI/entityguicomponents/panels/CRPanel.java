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
public class CRPanel extends JPanel{
    private int crValue;
    private final Dimension size = new Dimension(75, 30);
    private final float acFontSize = 20f;
    private final float valueFontSize = 20f;

    public CRPanel(int crValue) {
        super(new GridBagLayout());
        this.crValue = crValue;

        GridBagConstraints c = new GridBagConstraints();
        
        JLabel ac = new JLabel("CR: ");
        ac.setFont(getFont().deriveFont(acFontSize));
        ac.setForeground(LayoutConstants.YELLOW);
        JLabel value = new JLabel("" + crValue);
        value.setFont(getFont().deriveFont(valueFontSize));
        
        setBackground(LayoutConstants.BEIGE);
        setMinimumSize(size);
        setMaximumSize(size);
        c.gridx = 0;
        c.gridy = 0;
        add(ac, c);
        c.gridx = 1;
        add(value, c);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.main;

import dmtools.GUI.LayoutConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author A3
 */
public class FeatureComingSoon extends JPanel{

    public FeatureComingSoon() {
        super();
        createComponents();
    }
    
    private void createComponents() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(LayoutConstants.MAIN_PANEL_COLOR);
        add(Box.createVerticalGlue());
        
        JLabel text = new JLabel("Feature Coming Soon", SwingConstants.CENTER);
        text.setFont(text.getFont().deriveFont(40f));
        text.setForeground(LayoutConstants.YELLOW);
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(text);
        
        add(Box.createVerticalGlue());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.main.homepage;

import dmtools.GUI.LayoutConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.URL;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author A3
 */
public class HomePanel extends JPanel {
    
    private final Color BACKGROUND_COLOR = LayoutConstants.MAIN_PANEL_COLOR;
    private final String headerText;

    public HomePanel(String version) {
        super();
        this.headerText = "DM Tools " + version;
        createComponents();
    }

    private void createComponents() {
        setLayout(new GridBagLayout());
        setBackground(BACKGROUND_COLOR);
        
        // Top Filler
        JPanel filler = new JPanel();
        filler.setBackground(BACKGROUND_COLOR);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; 
        c.gridy = 0;
        c.weighty = 0.1;
        add(filler, c);
        
        // Header
        JLabel header = new JLabel(headerText, SwingConstants.CENTER);
        header.setFont(header.getFont().deriveFont(40f));
        header.setForeground(LayoutConstants.YELLOW);
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 5, 5, 5);
        add(header,c );
        
        // About
        if (getAboutText() != null) {
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 2;
            c.insets = new Insets(0, 5, 0, 5);
            add(getAboutText(), c);
        }
        
        // Bottom Filler
        filler = new JPanel();
        filler.setBackground(BACKGROUND_COLOR);
        c = new GridBagConstraints();
        c.gridx = 0; 
        c.gridy = 3;
        c.weighty = 0.1;
        add(filler, c);
    }

    private JEditorPane getAboutText() {
        JEditorPane aboutText = new JEditorPane();
        aboutText.setEditable(false);
        aboutText.setBackground(BACKGROUND_COLOR);
        aboutText.setForeground(LayoutConstants.YELLOW);
        URL aboutURL = HomePanel.class.getResource("about.rtf");
        if (aboutURL != null) {
            try {
                aboutText.setPage(aboutURL);
                return aboutText;
            } catch (Exception e) {
                System.out.println("URL Error");
            }
        } else {
            return null;
        }
        return null;
    }
}

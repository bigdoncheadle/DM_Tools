/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.main.panels;

import dmtools.GUI.LayoutConstants;
import dmtools.GUI.main.buttons.NewEncounterButton;
import dmtools.GUI.main.buttons.PartyManagementButton;
import dmtools.GUI.main.buttons.PlayerButton;
import dmtools.GUI.main.buttons.DMToolsButton;
import dmtools.GUI.main.buttons.SettingsButton;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author A3
 */
public class NavigationPanel extends JPanel implements ActionListener {

    private final NewEncounterButton encounter;
    private final PartyManagementButton party;
    private final PlayerButton player;
    private final DMToolsButton dm;
    private final SettingsButton settings;

    public NavigationPanel() {
        super();
        setBackground(LayoutConstants.NAV_PANEL_COLOR);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.weighty = 1.0;

        //New Encounter Button
        encounter = new NewEncounterButton();
        c.gridy = 0;
        add(encounter, c);

        //Party Mgmt Button
        party = new PartyManagementButton();
        c.gridy = 1;
        add(party, c);
        
        //Player Button
        player = new PlayerButton();
        c.gridy = 2;
        add(player, c);
        
        //DM Tools Button
        dm = new DMToolsButton();
        c.gridy = 3;
        add(dm, c);
        
        //Settings Button
        settings = new SettingsButton();
        c.gridy = 4;
        add(settings, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}

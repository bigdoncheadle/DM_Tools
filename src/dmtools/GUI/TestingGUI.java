/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI;

import dmtools.GUI.initiativeguicomponents.panels.InitiativeEntityCardPanel;
import dmtools.GUI.initiativeguicomponents.panels.InitiativePlayerListPanel;
import dmtools.GUI.partymgmt.PartyMgmtButtonPanel;
import dmtools.GUI.partymgmt.PartyMgmtListener;
import dmtools.GUI.partymgmt.PartyPlayerListPanel;
import dmtools.game.initiative.InitiativeTracker;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author A3
 */
public class TestingGUI implements Runnable, ActionListener {

    private JFrame frame;
    private JButton delete;
    private PartyPlayerListPanel pplp;
    private InitiativeEntityCardPanel eCardPanel;
    InitiativePlayerListPanel iPlayerList;
    InitiativeTracker iTrack;

    public TestingGUI(String text) {
    }

    @Override
    public void run() {
        frame = new JFrame("Testing GUI");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.darkGray);
        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void createComponents(Container container) {
        
        PartyMgmtButtonPanel buttonPanel = new PartyMgmtButtonPanel();
        container.add(buttonPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

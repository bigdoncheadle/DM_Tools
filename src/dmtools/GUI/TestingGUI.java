/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI;

import dmtools.GUI.entityguicomponents.horde.CreateHordeDialog;
import dmtools.GUI.initiativeguicomponents.getinitiative.dialogs.RemoveNonPlayerDialog;
import dmtools.GUI.initiativeguicomponents.getinitiative.panels.CreateEncounterPanel;
import dmtools.GUI.initiativeguicomponents.getinitiative.panels.NonPlayerGetInitiativePanel;
import dmtools.GUI.partymgmt.PartyMgmtPanel;
import dmtools.filehandling.FileHandler;
import dmtools.game.entities.DNDEntity;
import dmtools.game.entities.Horde;
import dmtools.game.entities.PC;
import dmtools.playermgmt.PlayerParty;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author A3
 */
public class TestingGUI implements Runnable, ActionListener {

    private PartyMgmtPanel partyPanel;
    private NonPlayerGetInitiativePanel nonPlayerPanel;
    private JButton add, remove;

    public TestingGUI() {
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Testing GUI");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);

    }

    private void addComponents(Container container) {
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        PlayerParty party = new PlayerParty("Testing Party");
        try {
            party.add((PC) FileHandler.loadFromName("Bertha", FileHandler.PC_FILE));
            party.add((PC) FileHandler.loadFromName("Cooper", FileHandler.PC_FILE));
            party.add((PC) FileHandler.loadFromName("Testing1", FileHandler.PC_FILE));
            party.add((PC) FileHandler.loadFromName("Testing2", FileHandler.PC_FILE));
        } catch (Exception e) {
        }

        CreateEncounterPanel iniPanel = new CreateEncounterPanel(party);
        container.add(iniPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(add)) {
            CreateHordeDialog cHorde = new CreateHordeDialog(null);
            Horde h = cHorde.getHorde();
            if (h != null) {
                nonPlayerPanel.addEntity(h);
            }
        }
        
        if (e.getSource().equals(remove)) {
            RemoveNonPlayerDialog removeNP = new RemoveNonPlayerDialog(null, 
                    nonPlayerPanel.getEntities());
            ArrayList<DNDEntity> toRemove = removeNP.getEntitiesToRemove();
            if (!toRemove.isEmpty()) {
                for (DNDEntity i : toRemove) {
                    nonPlayerPanel.removeEntity(i);
                }
            }
        }
    }
}

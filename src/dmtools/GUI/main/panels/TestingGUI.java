/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.main.panels;

import dmtools.GUI.partymgmt.PartyDoubleList;
import dmtools.filehandling.FileHandler;
import dmtools.game.entities.PC;
import dmtools.playermgmt.PlayerParty;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author A3
 */
public class TestingGUI implements Runnable {

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
        PlayerParty party = new PlayerParty("Testing Party");
        try {
            party.add((PC) FileHandler.loadFromName("Bertha", FileHandler.PC_FILE));
            party.add((PC) FileHandler.loadFromName("Cooper", FileHandler.PC_FILE));
            party.add((PC) FileHandler.loadFromName("Testing1", FileHandler.PC_FILE));
            party.add((PC) FileHandler.loadFromName("Testing2", FileHandler.PC_FILE));
        } catch (Exception e) {
        }
        PartyDoubleList list = new PartyDoubleList(party);
        container.add(list);
    }

}

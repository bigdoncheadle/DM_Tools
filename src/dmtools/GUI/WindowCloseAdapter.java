/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI;

import dmtools.GUI.main.DisplayPanel;
import dmtools.filehandling.FileHandler;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author A3
 */
public class WindowCloseAdapter extends WindowAdapter {

    private DisplayPanel displayPanel;

    public WindowCloseAdapter(DisplayPanel partyPanel) {
        super();
        this.displayPanel = partyPanel;
    }

    @Override
    public void windowClosing(WindowEvent w) {
        Object[] options = {"Save and Quit",
            "Cancel"};
        int n = JOptionPane.showOptionDialog(null,
                "Are you sure you want to exit and save changes?",
                "Confirm Close",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        
        // Closes only if the user selects yes
        if (n == JOptionPane.YES_OPTION) {
            try {
                FileHandler.saveFromInstance(displayPanel.getCurrentParty(),
                        FileHandler.PLAYER_PARTY_FILE);
                System.exit(0);
            } catch (IOException e) {
                System.out.println("Problem saving the party on close");
                System.exit(0);
            }
        }
    }
}

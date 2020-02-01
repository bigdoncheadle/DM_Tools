/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools;

import dmtools.GUI.main.DMToolsGui;
import dmtools.filehandling.FileHandler;
import dmtools.playermgmt.PlayerParty;
import java.io.File;
import java.io.IOException;
import javax.swing.SwingUtilities;

/**
 *
 * @author A3
 */
public class DMTools {

    private static final String VERSION = "v.0.1-alpha";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            PlayerParty party = (PlayerParty) FileHandler.loadFromName(
                    "party", FileHandler.PLAYER_PARTY_FILE);
            DMToolsGui dmGui = new DMToolsGui(VERSION, party);
            SwingUtilities.invokeLater(dmGui);
        } catch (IOException e) {
            System.out.println("oops");
        }

    }
}

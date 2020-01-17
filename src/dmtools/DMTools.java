/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools;

import dmtools.GUI.TestingGUI;
import dmtools.filehandling.PCFileHandler;
import dmtools.game.entities.DNDEntity;
import dmtools.game.entities.PC;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

/**
 *
 * @author A3
 */
public class DMTools {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        TestingGUI ui = new TestingGUI("TEst");
        SwingUtilities.invokeLater(ui);
    }
}

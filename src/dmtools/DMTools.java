/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools;

import dmtools.GUI.TestingGUI;
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

        TestingGUI gui = new TestingGUI();
        SwingUtilities.invokeLater(gui);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.main;

import dmtools.GUI.partymgmt.PartyMgmtPanel;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import resources.testing.TestingEntities;

/**
 *
 * @author A3
 */
public class DMToolsGui implements Runnable{
    private final String version;
    public static JFrame frame = new JFrame();
    
    public DMToolsGui(String version) {
        this.version = version;
    }
    
    private void addContent(Container container) {
        PartyMgmtPanel partyPanel = new PartyMgmtPanel(TestingEntities.TESTING_PARTY);
        container.add(partyPanel);
    }
    
    @Override
    public void run() {
        frame.setTitle("DM Tools " + version);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //add some stuff here
        addContent(frame.getContentPane());
        //stop adding stuff here
        
        frame.pack();
        frame.setVisible(true);
    }
    
}

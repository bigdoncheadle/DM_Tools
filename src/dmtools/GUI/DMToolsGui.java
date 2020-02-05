/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI;

import dmtools.GUI.main.MainPanel;
import dmtools.playermgmt.PlayerParty;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author A3
 */
public class DMToolsGui implements Runnable{
    private PlayerParty party;
    private MainPanel mainPanel;
    public final String version;
    public static JFrame frame = new JFrame();
    
    public DMToolsGui(String version, PlayerParty party) {
        this.version = version;
        this.party = party;
    }
    
    private void createComponents(Container container) {
        mainPanel = new MainPanel(version, party);
        container.add(mainPanel);
    }
    
    @Override
    public void run() {
        frame.setTitle("DM Tools " + version);
        frame.setPreferredSize(new Dimension(900, 600));
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
        //add some stuff here
        createComponents(frame.getContentPane());
        //stop adding stuff here
        
        frame.addWindowListener(new WindowCloseAdapter(mainPanel.getDisplay()));
        frame.pack();
        frame.setVisible(true);
    }
    
}

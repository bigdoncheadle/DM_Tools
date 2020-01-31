/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.main;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.initiativeguicomponents.createinitiative.panels;

import dmtools.game.entities.PC;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author A3
 */
public class PlayerInputLabel extends JPanel{
    private PC pc;
    private JLabel name;
    private JTextField inputI;

    public PlayerInputLabel(PC pc) {
        this.pc = pc;
        createComponents();
    }
    
    public PC getPC() {
        return this.pc;
    }
    
    private void createComponents() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        name = new JLabel(pc.getName());
        inputI = new JTextField();
        add(name);
        add(inputI);
    }
}

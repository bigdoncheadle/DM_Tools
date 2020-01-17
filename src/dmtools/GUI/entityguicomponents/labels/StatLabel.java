/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.entityguicomponents.labels;

import dmtools.GUI.LayoutConstants;
import dmtools.game.entities.numericals.enums.Stat;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author A3
 */
public class StatLabel extends JLabel{
    public StatLabel(Stat stat, float fontSize) {
        setText(stat.name() + ":");
        setFont(getFont().deriveFont(Font.BOLD, fontSize));
        setForeground(LayoutConstants.GREEN);
    }
    
}

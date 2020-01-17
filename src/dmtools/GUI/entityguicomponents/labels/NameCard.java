/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.entityguicomponents.labels;

import dmtools.GUI.LayoutConstants;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author A3
 */
public class NameCard extends JLabel {

    

    public NameCard(String name) {
        super(name);
        setFont(getFont().deriveFont(Font.BOLD,
                LayoutConstants.HEADER_FONT_SIZE));
        setForeground(LayoutConstants.RED);
    }

}

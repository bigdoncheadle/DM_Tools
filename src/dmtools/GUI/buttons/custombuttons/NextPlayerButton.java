/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.buttons.custombuttons;

import dmtools.GUI.LayoutConstants;
import dmtools.GUI.buttons.CustomButton;

/**
 *
 * @author A3
 */
public class NextPlayerButton extends CustomButton {
    private String icon, hover, click;

    public NextPlayerButton() {
        super("RIGHTARROW", 
                LayoutConstants.ARROW_COLOR, 
                LayoutConstants.ARROW_CLICK_COLOR, 
                LayoutConstants.ENCOUNTER_BUTTON_SIZE, 
                "NextPlayer");
    }
}

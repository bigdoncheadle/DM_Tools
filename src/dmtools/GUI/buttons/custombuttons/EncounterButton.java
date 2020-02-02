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
public class EncounterButton extends CustomButton {

    public EncounterButton() {
        super("ENCOUNTER",
                LayoutConstants.NAVIGATOR_ICON_COLOR,
                LayoutConstants.NAVIGATOR_ICON_CLICK,
                LayoutConstants.NAVIGATOR_BUTTON_SIZE,
                "Create or Run an Encounter");
    }
}

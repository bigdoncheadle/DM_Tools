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
public class ExitEncounterButton extends CustomButton {

    public ExitEncounterButton() {
        super("EXIT",
                LayoutConstants.EXIT_COLOR,
                LayoutConstants.EXIT_CLICK_COLOR,
                LayoutConstants.ENCOUNTER_BUTTON_SIZE,
                "End Encounter");
    }
}

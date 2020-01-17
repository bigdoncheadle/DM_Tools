/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.entityguicomponents.labels;

import dmtools.GUI.LayoutConstants;
import dmtools.game.entities.numericals.enums.Skill;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author A3
 */
public class SkillLabel extends JLabel {

    public SkillLabel(Skill skill, float fontSize) {
        setText(skill.toString());
        setFont(getFont().deriveFont(Font.BOLD, fontSize));
        setForeground(LayoutConstants.GREEN);
    }
}

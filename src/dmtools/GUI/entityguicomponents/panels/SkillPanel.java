/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.entityguicomponents.panels;

import dmtools.GUI.LayoutConstants;
import dmtools.GUI.entityguicomponents.labels.SkillLabel;
import javax.swing.JPanel;
import dmtools.game.entities.numericals.SkillTree;
import dmtools.game.entities.numericals.enums.Skill;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author A3
 */
public class SkillPanel extends JPanel {

    private final SkillTree skillTree;
    private static final float SKILL_FONT_SIZE = 16F;
    private static final float VALUE_FONT_SIZE = 14F;

    public SkillPanel(SkillTree skillTree) {
        this.skillTree = skillTree;
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        setBackground(LayoutConstants.BEIGE);
        

        GridBagConstraints l = new GridBagConstraints();
        l.anchor = GridBagConstraints.LAST_LINE_START;
        l.gridx = 0;
        l.insets = new Insets(0, 5, 0, 10);
        GridBagConstraints r = new GridBagConstraints();
        r.anchor = GridBagConstraints.LAST_LINE_START;
        r.gridx = 1;
        r.insets = new Insets(0, 0, 0, 5);
        
        
        int y = 0;
        for (Skill i : skillTree.getSkillTree().keySet()) {
            //Skill name label
            SkillLabel toAdd = new SkillLabel(i, SKILL_FONT_SIZE);
            //Skill value label
            JLabel value = new JLabel("" + skillTree.getSkillValue(i));
            value.setFont(getFont().deriveFont(VALUE_FONT_SIZE));

            if (y == skillTree.getSkillTree().size() - 1) {
                l.gridy = y;
                l.insets = new Insets(0, 5, 5, 10);
                add(value, l);
                r.gridy = y;
                r.insets = new Insets(0, 0, 5, 5);
                add(toAdd, r);
            } else {
                l.gridy = y;
                r.gridy = y;
                add(value, l);
                add(toAdd, r);
                y++;
            }
        }
    }
}

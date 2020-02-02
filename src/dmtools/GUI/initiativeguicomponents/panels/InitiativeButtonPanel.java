/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.initiativeguicomponents.panels;

import dmtools.GUI.LayoutConstants;
import dmtools.GUI.initiativeguicomponents.Cyclable;
import dmtools.GUI.buttons.custombuttons.ExitEncounterButton;
import dmtools.GUI.buttons.custombuttons.NextPlayerButton;
import dmtools.GUI.buttons.custombuttons.PrevPlayerButton;
import static dmtools.GUI.DMToolsGui.frame;
import dmtools.GUI.main.DisplayPanel;
import dmtools.game.initiative.InitiativeTracker;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author A3
 */
public class InitiativeButtonPanel extends JPanel implements ActionListener {

    private List<Cyclable> toCycle;
    private final InitiativeTracker iTrack;
    private final NextPlayerButton nextB;
    private final PrevPlayerButton prevB;
    private final ExitEncounterButton exitB;

    private final DisplayPanel display;

    public InitiativeButtonPanel(
            InitiativeTracker iTrack, DisplayPanel display, Cyclable... c) {
        this.iTrack = iTrack;
        this.display = display;
        toCycle = new ArrayList();
        toCycle.addAll(Arrays.asList(c));
        nextB = new NextPlayerButton();
        prevB = new PrevPlayerButton();
        exitB = new ExitEncounterButton();
        addComponents();
    }

    private void addComponents() {
        //Add actionlisteners
        nextB.addActionListener(this);
        prevB.addActionListener(this);
        exitB.addActionListener(this);

        //Set Layout
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBackground(LayoutConstants.BUTTON_PANEL_BACKGROUND);

        add(Box.createRigidArea(new Dimension(10, 0)));
        add(prevB);
        add(Box.createHorizontalGlue());
        add(exitB);
        add(Box.createHorizontalGlue());
        add(nextB);
        add(Box.createRigidArea(new Dimension(10, 0)));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Previous
        if (e.getSource() == prevB) {
            if (iTrack.getRound() == 1 && iTrack.getTurnNumber() == 0) {
                return;
            } else {
                iTrack.prevTurn();
                for (Cyclable i : toCycle) {
                    i.cycleBack();
                }
            }
        }

        //Exit
        if (e.getSource() == exitB) {
            // Dialog for confirmation
            Object[] options = {"End Encounter", "Cancel"};
            int n = JOptionPane.showOptionDialog(null,
                    "Would you like to end this Encounter?",
                    "Confirm Encounter End",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
            if (n == JOptionPane.OK_OPTION) {
                display.endEncounter();
            }
        }

        //Next
        if (e.getSource() == nextB) {
            iTrack.nextTurn();
            for (Cyclable i : toCycle) {
                i.cycleForward();
            }
        }
    }

}

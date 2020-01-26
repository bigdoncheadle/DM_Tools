/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.monsters.hordes;

import dmtools.filehandling.FileHandler;
import dmtools.game.entities.Horde;
import java.awt.Frame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author A3
 */
public class CreateHordeDialog extends JDialog
        implements PropertyChangeListener {

    private final JOptionPane optionPane;
    private final CreateHordePanel hordePanel;
    private Horde horde;

    public CreateHordeDialog(Frame frame) {
        super(frame, true);
        this.hordePanel = new CreateHordePanel();

        setTitle("Create a new Horde");
        String createButtonTxt = "Create";
        Object[] options = {createButtonTxt};

        optionPane = new JOptionPane(hordePanel,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.OK_OPTION,
                null, //icon
                options,
                options[0]);

        setContentPane(optionPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        optionPane.addPropertyChangeListener(this);
        pack();
        setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        String prop = e.getPropertyName();
        if (isVisible()
                && (e.getSource() == optionPane)
                && (JOptionPane.VALUE_PROPERTY.equals(prop))
                || JOptionPane.INPUT_VALUE_PROPERTY.equals(prop)) {
            Object value = optionPane.getValue();

            if (value == JOptionPane.UNINITIALIZED_VALUE) {
                return;
            }
            optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);

            /*
            * This is where the error list is displayed
            * or the monster is created
             */
            List<String> errors = hordePanel.hasValidInfo();
            if (errors.isEmpty()) {
                //create the monster here
                try {
                    this.horde = hordePanel.getCreatedHorde();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this,
                            ex.getLocalizedMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE,
                            null);
                }
                dispose();
                
            } else {
                JOptionPane.showMessageDialog(this,
                        errors.toArray(),
                        "Horde incomplete or incorrect",
                        JOptionPane.ERROR_MESSAGE,
                        null);
            }
        }
    }

    public Horde getHorde() {
        return this.horde;
    }
}

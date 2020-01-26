/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.entityguicomponents.panels.horde;

import dmtools.game.entities.Horde;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author A3
 */
public class AddMoreMembersDialog extends JDialog
        implements PropertyChangeListener {

    private final JOptionPane optionPane;
    private final Horde horde;
    private JSpinner spinner;
    private int slots, amountToAdd;

    public AddMoreMembersDialog(Frame frame, Horde horde) {
        super(frame, true);
        this.horde = horde;
        this.amountToAdd = 0;

        setTitle("Add more Monsters");
        String addString = "Add";
        Object[] options = {addString};
        JPanel content = getContent();

        optionPane = new JOptionPane(content,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.OK_OPTION,
                null, // icon
                options,
                options[0]);

        setContentPane(optionPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        optionPane.addPropertyChangeListener(this);
        pack();
        setVisible(true);
    }
    
    public int getAmountToAdd() {
        return amountToAdd;
    }

    private JPanel getContent() {
        JPanel panel = new JPanel(new GridBagLayout());
        slots = 100 - horde.getSize();
        SpinnerModel sModel = new SpinnerNumberModel(1, 1, slots, 1);
        GridBagConstraints c = new GridBagConstraints();

        // Label
        JLabel label = new JLabel(horde.getHordeType().getName() + 
                " to add: (Max = " + slots + ")");
        c.gridx = 0;
        c.gridy = 0;
        panel.add(label, c);

        // Spinner
        spinner = new JSpinner(sModel);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        panel.add(spinner, c);

        return panel;
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
            amountToAdd = (Integer)spinner.getValue();
            if (amountToAdd > slots) {
                amountToAdd = slots;
            }
            dispose();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.entityguicomponents.horde;

import dmtools.GUI.entityguicomponents.monsters.CreateMonsterDialog;
import dmtools.filehandling.FileHandler;
import dmtools.game.entities.Horde;
import dmtools.game.entities.Monster;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author A3
 */
public class CreateHordePanel extends JPanel implements ActionListener {

    private MonsterComboBox monBox;
    private JButton createMon;
    private JLabel countLabel;
    private JSpinner countSpinner;
    private ArrayList<String> errors;

    public CreateHordePanel() {
        super();
        createComponents();
    }

    public ArrayList<String> hasValidInfo() {
        errors = new ArrayList();

        // Monster Type
        highlight(monBox, false);
        if (monBox.getSelectedIndex() == 0) {
            errors.add("-Select a Monster Type");
            highlight(monBox, true);
        }

        // Monster Count
        highlight(countSpinner, false);
        // if blank
        if (countSpinner.getValue().equals("")) {
            errors.add("-Monster Count cannot be blank");
            highlight(countSpinner, true);
        } else {
            int count = (Integer) countSpinner.getValue();
            // if count < 2
            if (count < 2) {
                errors.add("-A Horde must be >1 Monster");
                highlight(countSpinner, true);
            }
        }

        return errors;
    }

    public Horde getCreatedHorde() throws Exception {
        if (hasValidInfo().isEmpty()) {
            String monsterName = (String) monBox.getSelectedItem();
            try {
                Monster monsterType = (Monster) FileHandler.loadFromName(
                        monsterName, FileHandler.MONSTER_FILE);
                int count = (Integer) countSpinner.getValue();
                return new Horde(monsterType, count);
            } catch (IOException e) {
                throw new IOException("Error loading selected monster");
            }
        } else {
            throw new IllegalArgumentException(
                    "There are unaddressed errors in one or more fields");
        }
    }

    private void createComponents() {
        setLayout(new GridBagLayout());

        // Monster ComboBox
        monBox = new MonsterComboBox();
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        add(monBox, c);

        // Add Monster Button
        createMon = new JButton("+");
        createMon.addActionListener(this);
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        c.gridx = 1;
        c.gridy = 0;
        add(createMon, c);

        // Count Label
        countLabel = new JLabel("Count (Max: 100)");
        c = new GridBagConstraints();
        c.insets = new Insets(5, 0, 0, 0);
        c.gridx = 0;
        c.gridy = 1;
        add(countLabel, c);

        // Count JSpinner
        SpinnerModel sModel = new SpinnerNumberModel(0, 0, 100, 1);
        countSpinner = new JSpinner(sModel);
        c = new GridBagConstraints();
        c.insets = new Insets(5, 0, 0, 0);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 1;
        c.gridy = 1;
        add(countSpinner, c);
    }

    private void highlight(JComponent component, boolean shouldColor) {
        if (component.getClass() == MonsterComboBox.class) {
            if (shouldColor) {
                component.setBorder(BorderFactory.createBevelBorder(
                        EtchedBorder.RAISED, Color.red, Color.RED));
            } else {
                component.setBorder(null);
            }
        }

        if (component.getClass() == JSpinner.class) {
            JSpinner spinner = (JSpinner) component;
            JComponent editor = spinner.getEditor();
            if (shouldColor) {
                ((JSpinner.DefaultEditor) editor).getTextField().
                        setForeground(Color.red);
            } else {
                ((JSpinner.DefaultEditor) editor).getTextField().
                        setForeground(null);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CreateMonsterDialog monDialog = new CreateMonsterDialog(null);
        if (monDialog.getMonster() != null) {
            monBox.refresh();
            monBox.setSelectedItem(monDialog.getMonster().getName());
        }
    }
}

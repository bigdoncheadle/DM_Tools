/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.monsters;

import dmtools.filehandling.FileHandler;
import dmtools.game.entities.Monster;
import java.awt.Frame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author A3
 */
public class CreateMonsterDialog extends JDialog 
        implements PropertyChangeListener {

    private final JOptionPane optionPane;
    private final MonsterCreationPanel monPanel;
    private Monster monster;

    public CreateMonsterDialog(Frame frame) {
        super(frame, true);
        this.monPanel = new MonsterCreationPanel();

        setTitle("Create a new Monster");
        String createButtonTxt = "Create";
        Object[] options = {createButtonTxt};

        optionPane = new JOptionPane(monPanel,
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
            List<String> errors = monPanel.hasValidInfo();
            if (errors.isEmpty()) {
                //create the monster here
                this.monster = monPanel.getCreatedMonster();
                try {
                    FileHandler.saveFromInstance(monster,
                            FileHandler.MONSTER_FILE);
                } catch (IOException ex) {
                    System.out.println("ERROR"); // Don't know what to do 
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        errors.toArray(),
                        "Monster incomplete or incorrect",
                        JOptionPane.ERROR_MESSAGE,
                        null);
            }
        }
    }

    public Monster getMonster() {
        return this.monster;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.partymgmt;

import dmtools.GUI.entityguicomponents.dialogs.CreatePcDialog;
import dmtools.GUI.entityguicomponents.dialogs.EditPcDialog;
import dmtools.GUI.main.DMToolsGui;
import dmtools.game.entities.PC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author A3
 */
public class PartyMgmtListener implements ActionListener {

    private final JButton addNew, addExisting, remove, edit;
    private final PartyPlayerListPanel playerList;

    public PartyMgmtListener(JButton addNew, JButton addExisting,
            JButton remove, JButton edit, PartyPlayerListPanel playerList) {
        this.addNew = addNew;
        this.addExisting = addExisting;
        this.remove = remove;
        this.edit = edit;
        this.playerList = playerList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if there is no selection
        try {
            playerList.getSelectedPC();
        } catch (Exception ex) {
            return;
        }

        //add new player button
        if (e.getSource() == addNew) {
            CreatePcDialog createDialog = new CreatePcDialog(DMToolsGui.frame,
                    true);
            try {
                PC addedPC = createDialog.getCreatedPC();
                playerList.addPC(addedPC);
            } catch (Exception ex) {
                return;
            }
        }

        //add existing player button
        if (e.getSource() == addExisting) {

        }

        //remove player button
        if (e.getSource() == remove) {
            Object[] options = {"Remove", "Cancel"};
            String pcName = playerList.getSelectedPC().getName();

            int n = JOptionPane.showOptionDialog(DMToolsGui.frame,
                    "Are you sure you want to remove "
                    + pcName
                    + " from the party?",
                    "Player Removal Confirmation",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
            if (n == JOptionPane.OK_OPTION) {
                playerList.removePC();
            }
        }

        //edit player button
        if (e.getSource() == edit) {
            System.out.println(playerList);
            PC pcToEdit = playerList.getSelectedPC();
            EditPcDialog editDialog = new EditPcDialog(DMToolsGui.frame, 
                    pcToEdit);
            PC updatedPC = editDialog.getUpdatedPC();
            if (updatedPC != null) {
                playerList.updatePC(pcToEdit, updatedPC);
            }
        }
    }

}

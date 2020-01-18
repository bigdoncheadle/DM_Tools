/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.partymgmt;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author A3
 */
public class PartyMgmtButtonPanel extends JPanel {

    private final JButton addNew, addExisting, remove, edit;
    private final PartyPlayerListPanel playerList;
    
    public PartyMgmtButtonPanel(PartyPlayerListPanel playerList) {
        super();
        this.playerList = playerList;
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(2, 2, 2, 2);

        addNew = new JButton("Add New PC");
        addExisting = new JButton("Add Existing PC");
        remove = new JButton("Remove PC");
        edit = new JButton("Edit PC");
        PartyMgmtListener listener = new PartyMgmtListener(addNew, addExisting, 
                remove, edit, playerList);

        addNew.addActionListener(listener);
        c.gridx = 0;
        c.gridy = 0;
        add(addNew, c);
        
        addExisting.addActionListener(listener);
        c.gridx = 0;
        c.gridy = 1;
        add(addExisting, c);

        remove.addActionListener(listener);
        c.gridx = 0;
        c.gridy = 2;
        add(remove, c);

        edit.addActionListener(listener);
        c.gridx = 0;
        c.gridy = 3;
        add(edit, c);
    }

}

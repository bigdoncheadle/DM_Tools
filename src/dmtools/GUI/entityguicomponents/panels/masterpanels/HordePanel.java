/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.entityguicomponents.panels.masterpanels;

import dmtools.GUI.LayoutConstants;
import dmtools.GUI.entityguicomponents.panels.horde.AddMoreMembersDialog;
import dmtools.GUI.main.DMToolsGui;
import dmtools.game.entities.Horde;
import dmtools.game.entities.Monster;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author A3
 */
public class HordePanel extends JPanel implements ListSelectionListener,
        ActionListener {

    private final Horde horde;
    private JList memberList;
    private DefaultListModel listModel;
    private JScrollPane scroller;
    private CardLayout memberCardLayout;
    private JPanel memberCards;
    private JButton add, remove;

    public HordePanel(Horde horde) {
        this.horde = horde;
        createComponents();
    }

    private void createComponents() {
        setLayout(new GridBagLayout());
        setBackground(LayoutConstants.GREEN);
        GridBagConstraints c = new GridBagConstraints();

        // List Model and memberCards
        listModel = new DefaultListModel();
        memberCardLayout = new CardLayout();
        memberCards = new JPanel(memberCardLayout);

        for (Integer i : horde.getMembers().keySet()) {
            Monster m = horde.getMonster(i);
            listModel.addElement(m.getName());
            memberCards.add(m.getName(), new MonsterPanel(m));
        }

        // Title
        JLabel hordeName = new JLabel(horde.getName());
        hordeName.setFont(hordeName.getFont().deriveFont(30f));
        hordeName.setForeground(LayoutConstants.DARKOAL);
        hordeName.setBackground(LayoutConstants.BEIGE);
        hordeName.setOpaque(true);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.insets = new Insets(5, 5, 5, 5);
        add(hordeName, c);

        // Members List
        memberList = new JList(listModel);
        memberList.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        memberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        memberList.setVisibleRowCount(15);
        memberList.setSelectedIndex(0);
        memberList.addListSelectionListener(this);

        scroller = new JScrollPane(memberList);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 2;
        c.insets = new Insets(5, 5, 5, 5);
        add(scroller, c);

        // Buttons
        add = new JButton("+");
        add.addActionListener(this);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(5, 5, 0, 0);
        add(add, c);

        remove = new JButton("-");
        remove.addActionListener(this);
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 0, 0, 5);
        add(remove, c);

        // Selected Monsters monsterPanel
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.VERTICAL;
        c.insets = new Insets(5, 5, 5, 5);
        add(memberCards, c);
    }

    private int getSelectedMonsterHordeIndex() {
        String memberName = (String) memberList.getSelectedValue();
        String[] s = memberName.split(" ");
        return Integer.parseInt(s[s.length - 1]);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
            memberCardLayout.show(memberCards,
                    (String) memberList.getSelectedValue());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Add
        if (e.getSource().equals(add)) {
            AddMoreMembersDialog addDialog = new AddMoreMembersDialog(
                    null, horde);
            int toAdd = addDialog.getAmountToAdd();
            if (toAdd > 0) {
                for (int i = 0; i < toAdd; i++) {
                    Monster m = horde.addMonster();
                    listModel.addElement(m.getName());
                    memberCards.add(m.getName(), new MonsterPanel(m));
                }
            }
        }

        // Remove
        if (e.getSource().equals(remove)) {
            Object[] options = {"Remove", "Cancel"};
            int n = JOptionPane.showOptionDialog(null,
                    "Are you sure you want to remove " + 
                            memberList.getSelectedValue(),
                    "Remove Monster from Horde",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
            
            if (n == JOptionPane.OK_OPTION) {
                horde.removeMonster(getSelectedMonsterHordeIndex());
                listModel.removeElementAt(memberList.getSelectedIndex());
                memberList.setSelectedIndex(0);
            }
        }
    }
}

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.partymgmt;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author A3
 */
public class DoubleList extends JPanel
        implements ActionListener, MouseListener {

    private HashMap<String, Object> masterMap;
    private ArrayList<String> masterList, listA, listB;
    private JLabel labelA, labelB;
    private JButton swap;
    private DefaultListModel listModelA, listModelB;
    private JList jListA, jListB;
    private int padding;

    public DoubleList(HashMap<String, Object> masterMap, int padding) {
        //initialize all variables
        this.masterMap = masterMap;
        this.masterList = new ArrayList();
        this.listA = new ArrayList();
        this.listB = new ArrayList();
        this.listModelA = new DefaultListModel();
        this.listModelB = new DefaultListModel();
        this.labelA = new JLabel("Label A");
        this.labelB = new JLabel("Label B");
        this.swap = new JButton("Swap");
        swap.addActionListener(this);
        this.padding = padding;

        generateLists();
        generateListDisplays();
        fillContainer();
    }

    public DoubleList(HashMap<String, Object> masterMap) {
        this(masterMap, 5);
    }

    public void setLabelA(String text) {
        labelA.setText(text);
    }

    public void setLabelB(String text) {
        labelB.setText(text);
    }

    public void setSwapButton(String text) {
        swap.setText(text);
    }

    public void setSwapButton(JButton button) {
        this.swap = button;
        swap.addActionListener(this);
    }
    public Object getSelectedObject() {
        if (!jListA.isSelectionEmpty()) {
            return masterMap.get((String) jListA.getSelectedValue());
        } else if (!jListB.isSelectionEmpty()) {
            return masterMap.get((String) jListB.getSelectedValue());
        }
        return null;
    }
    
    public ArrayList<Object> getListAObjects () {
        ArrayList<Object> objects = new ArrayList();
        for (String i : aList) {
            objects.add(masterMap.get(i));
        }
        return objects;
    }
    
    public ArrayList<Object> getListBObjects () {
        ArrayList<Object> objects = new ArrayList();
        for (String i : bList) {
            objects.add(masterMap.get(i));
        }
        return objects;
    }
    
    private void generateLists() {
        for (String i : masterMap.keySet()) {
            masterList.add(i);
            aList.add(i);
        }
        Collections.sort(masterList);
        Collections.sort(aList);
    }

    private void generateListDisplays() {
        for (String i : masterList) {
            listModelA.addElement(i);
        }

        Border border = BorderFactory.createEmptyBorder(padding, padding,
                padding, padding);
        jListA = new JList(listModelA);
        jListA.setBorder(border);
        jListA.setVisibleRowCount(masterList.size() + 1);
        jListA.addMouseListener(this);
        jListB = new JList(listModelB);
        jListB.setVisibleRowCount(masterList.size() + 1);
        jListB.setBorder(border);
        jListB.addMouseListener(this);
    }

    private void fillContainer() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        Insets leftInsets = new Insets(padding, padding, padding, padding);
        Insets centerInsets = new Insets(padding, 0, padding, 0);
        Insets rightInsets = new Insets(padding, padding, padding, padding);

        //overall
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.BOTH;

        //A Side
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = leftInsets;
        c.gridx = 0;
        c.gridy = 0;
        add(labelA, c);

        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 2;
        add(jListA, c);

        //B Side
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = rightInsets;
        c.gridx = 2;
        c.gridy = 0;
        add(labelB, c);

        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 2;
        c.gridy = 1;
        c.gridheight = 2;
        add(jListB, c);

        //Center
        c.anchor = GridBagConstraints.CENTER;
        c.insets = centerInsets;
        c.gridheight = 1;
        c.gridheight = 2;
        c.gridx = 1;
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        add(swap, c);
    }

    private void swap(Object key) {
        if (listModelA.contains(key)) {
            //remove 
            listModelA.removeElement(key);
            listA.remove((String) key);
            //add
            listB.add((String) key);
            Collections.sort(listB);
            listModelB.add(listB.indexOf(key), key);
        } else if (listModelB.contains(key)) {
            //remove
            listModelB.removeElement(key);
            listB.remove((String) key);
            //add
            listA.add((String) key);
            Collections.sort(listA);
            listModelA.add(listA.indexOf(key), key);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!jListA.isSelectionEmpty()) {
            swap(jListA.getSelectedValue());
        }
        if (!jListB.isSelectionEmpty()) {
            swap(jListB.getSelectedValue());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() != MouseEvent.BUTTON1) {
            return;
        }

        JList list = (JList) e.getSource();
        if (e.getClickCount() == 2) {
            if (list == jListA) {
                swap(jListA.getSelectedValue());
            }
            if (list == jListB) {
                swap(jListB.getSelectedValue());
            }

        } else {
            if (list == jListA) {
                jListB.clearSelection();
            }
            if (list == jListB) {
                jListA.clearSelection();
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

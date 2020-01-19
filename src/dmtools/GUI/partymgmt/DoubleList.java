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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author A3
 */
public class DoubleList extends JPanel
        implements ActionListener, MouseListener, ListSelectionListener {

    private HashMap<String, Object> masterMap;
    private ArrayList<String> masterList, listA, listB;
    protected JLabel labelA, labelB;
    protected JButton swap;
    protected DefaultListModel listModelA, listModelB;
    protected JList jListA, jListB;
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

    public void addObject(Object o, String key) {
        masterMap.put(key, o);
        masterList.add(key);
        Collections.sort(masterList);
        listA.add(key);
        Collections.sort(listA);
        listModelA.add(listA.indexOf(key), key);
    }

    public void removeSelected() {
        //gets selected string
        String key = "";
        if (!jListA.isSelectionEmpty()) {
            key = (String) jListA.getSelectedValue();
        }
        if (!jListB.isSelectionEmpty()) {
            key = (String) jListB.getSelectedValue();
        }

        //removes
        if (!key.equals("")) {
            masterMap.remove(key);
            masterList.remove(key);
            listA.remove(key);
            listB.remove(key);
            listModelA.removeElement(key);
            listModelB.removeElement(key);
        }
    }

    public void replaceObject(Object o, String key) {
        if (masterMap.containsKey(key)) {
            masterMap.put(key, o);
        }
    }

    public Object getSelectedObject() {
        if (!jListA.isSelectionEmpty()) {
            return masterMap.get((String) jListA.getSelectedValue());
        } else if (!jListB.isSelectionEmpty()) {
            return masterMap.get((String) jListB.getSelectedValue());
        }
        return null;
    }

    public ArrayList<String> getKeyMasterList() {
        return masterList;
    }

    public ArrayList<String> getListAKeys() {
        return listA;
    }

    public ArrayList<String> getListBKeys() {
        return listB;
    }

    public ArrayList<Object> getListAObjects() {
        ArrayList<Object> objects = new ArrayList();
        for (String i : listA) {
            objects.add(masterMap.get(i));
        }
        return objects;
    }

    protected void swap(Object key) {
        if (listModelA.contains(key)) {
            //remove 
            listModelA.removeElement(key);
            listA.remove((String) key);
            //add
            listB.add((String) key);
            Collections.sort(listB);
            listModelB.add(listB.indexOf(key), key);
            jListB.setSelectedValue(key, true);
            jListB.requestFocus();
        } else if (listModelB.contains(key)) {
            //remove
            listModelB.removeElement(key);
            listB.remove((String) key);
            //add
            listA.add((String) key);
            Collections.sort(listA);
            listModelA.add(listA.indexOf(key), key);
            jListA.setSelectedValue(key, true);
            jListA.requestFocus();
        }
    }

    public ArrayList<Object> getListBObjects() {
        ArrayList<Object> objects = new ArrayList();
        for (String i : listB) {
            objects.add(masterMap.get(i));
        }
        return objects;
    }

    private void generateLists() {
        for (String i : masterMap.keySet()) {
            masterList.add(i);
            listA.add(i);
        }
        Collections.sort(masterList);
        Collections.sort(listA);
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
        jListA.addListSelectionListener(this);
        jListA.addMouseListener(this);
        jListB = new JList(listModelB);
        jListB.setVisibleRowCount(masterList.size() + 1);
        jListB.setBorder(border);
        jListB.addListSelectionListener(this);
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
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = leftInsets;
        c.gridx = 0;
        c.gridy = 0;
        add(labelA, c);

        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 2;
        add(jListA, c);

        //B Side
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = rightInsets;
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 2;
        c.gridy = 0;
        add(labelB, c);

        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 2;
        c.gridy = 1;
        c.gridheight = 2;
        c.weightx = 1;
        c.weighty = 1;
        add(jListB, c);

        //Center
        c.weightx = 0;
        c.weighty = 0;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = centerInsets;
        c.gridheight = 1;
        c.gridheight = 2;
        c.gridx = 1;
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        add(swap, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!jListA.isSelectionEmpty()) {
            swap(jListA.getSelectedValue());

        } else if (!jListB.isSelectionEmpty()) {
            swap(jListB.getSelectedValue());
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (e.getSource() == jListA) {
                if (!jListA.isSelectionEmpty()) {
                    jListB.clearSelection();
                }
            }
            if (e.getSource() == jListB) {
                if (!jListB.isSelectionEmpty()) {
                    jListA.clearSelection();
                }
            }
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

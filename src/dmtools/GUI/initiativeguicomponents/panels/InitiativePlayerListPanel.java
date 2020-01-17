/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.initiativeguicomponents.panels;

import dmtools.GUI.LayoutConstants;
import dmtools.game.entities.DNDEntity;
import dmtools.game.initiative.InitiativeTracker;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import dmtools.GUI.initiativeguicomponents.Cyclable;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 *
 * @author A3
 */
public class InitiativePlayerListPanel extends JPanel implements Cyclable {

    private InitiativeTracker iTrack;
    private Map<DNDEntity, JLabel> entityLabels;
    private JLabel roundLabel = new JLabel();
    private Font roundLabelFont = roundLabel.getFont().deriveFont(30f);
    private Font entityLabelFont = roundLabel.getFont().deriveFont(15f);
    private Border matte = BorderFactory.createMatteBorder(1, 5, 1, 1,
            LayoutConstants.RED);
    private Border highlight = BorderFactory.createTitledBorder(matte,
            "Current", TitledBorder.ABOVE_TOP, 0, null, LayoutConstants.RED);
    private Border noBorder = BorderFactory.createEmptyBorder();

    public InitiativePlayerListPanel(InitiativeTracker i) {
        super();
        this.iTrack = i;
        this.entityLabels = new HashMap();
        this.roundLabel = new JLabel();
        roundLabel.setForeground(LayoutConstants.DARKOAL);
        roundLabel.setFont(roundLabelFont);
        setLayout(new GridBagLayout());
        setBackground(LayoutConstants.SUB_PANEL_COLOR);
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
                LayoutConstants.SUB_PANEL_BORDER_COLOR));

        //creates the label for each entity
        createEntityLabels();

        //fills this with the components
        fillComponents(this);

    }

    private void createEntityLabels() {
        for (DNDEntity i : iTrack.getEntityList()) {
            entityLabels.put(i, new JLabel(i.getName()));
            entityLabels.get(i).setFont(entityLabelFont);
            entityLabels.get(i).setForeground(LayoutConstants.DARKOAL);
        }
    }

    private void fillComponents(Container container) {
        //Creates the background panel with box layout
        JPanel background = new JPanel();
        background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
        background.setBackground(LayoutConstants.SUB_PANEL_COLOR);
        
        //adds the header and a rigid area for spacing
        roundLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        background.add(roundLabel);
        background.add(Box.createRigidArea(new Dimension(0, 5)));

        //adds the entities
        for (DNDEntity i : iTrack.getEntityList()) {
            entityLabels.get(i).setAlignmentX(Component.LEFT_ALIGNMENT);
            background.add(entityLabels.get(i));
        }
        background.add(Box.createVerticalGlue());
        cycleForward();
        
        //adds the background label to the parent
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.BOTH;
        container.add(background, c);
        //blank space
        c.gridy = 1;
        c.weighty = 1;
        JLabel blank = new JLabel();
        blank.setOpaque(false);
        container.add(blank, c);

//        //adds the header and a rigid area for spacing
//        roundLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        container.add(roundLabel);
//        container.add(Box.createRigidArea(new Dimension(0, 5)));
//        
//        //adds the entities
//        for (DNDEntity i : iTrack.getEntityList()) {
//            entityLabels.get(i).setAlignmentX(Component.LEFT_ALIGNMENT);
//            container.add(entityLabels.get(i));
//        }
//        container.add(Box.createVerticalGlue());
//        cycleForward();
    }

    @Override
    public void cycleForward() {
        roundLabel.setText("Round: " + iTrack.getRound());
        entityLabels.get(iTrack.getCurrentEntity()).setBorder(highlight);
        entityLabels.get(iTrack.prevCurrentNext(InitiativeTracker.PREVIOUS)).
                setBorder(noBorder);
    }

    @Override
    public void cycleBack() {
        roundLabel.setText("Round: " + iTrack.getRound());
        entityLabels.get(iTrack.getCurrentEntity()).setBorder(highlight);
        entityLabels.get(iTrack.prevCurrentNext(InitiativeTracker.NEXT)).
                setBorder(noBorder);
    }

}

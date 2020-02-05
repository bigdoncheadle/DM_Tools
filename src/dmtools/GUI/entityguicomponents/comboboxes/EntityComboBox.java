/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.entityguicomponents.comboboxes;

import dmtools.game.entities.characteristics.Alignment;
import dmtools.game.entities.characteristics.Race;
import dmtools.game.playableclasses.PlayableClass;

/**
 *
 * @author A3
 */
public class EntityComboBox extends javax.swing.JComboBox{
    public final static int RACE_BOX = 0;
    public final static int ALIGNMENT_BOX = 1;
    public final static int PLAYABLE_CLASS_BOX = 2;
    public final static int CHARACTER_LEVEL_BOX = 3;
    private final static int MAX_LEVEL = 20;

    public EntityComboBox(int boxType) {
        super();
        switch (boxType) {
            case RACE_BOX:
                this.addItem("-Select Race-");
                for (Race i : Race.values()) {
                    this.addItem(i.toString());
                }
                this.setMaximumRowCount(this.getItemCount());
                break;
            case ALIGNMENT_BOX:
                this.addItem("-Select Alignment-");
                for (Alignment i : Alignment.values()) {
                    this.addItem(i.toString());
                }
                this.setMaximumRowCount(this.getItemCount());
                break; 
            case PLAYABLE_CLASS_BOX:
                this.addItem("-Select Class-");
                for (PlayableClass i : PlayableClass.values()) {
                    this.addItem(i.toString());
                }
                this.setMaximumRowCount(this.getItemCount());
                break;
            case CHARACTER_LEVEL_BOX:
                for (int i = 1; i <= MAX_LEVEL; i ++) {
                    this.addItem(i);
                }
        } 
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.entityguicomponents.horde;

import dmtools.filehandling.BatchFileHandler;
import dmtools.game.entities.Monster;
import javax.swing.JComboBox;

/**
 *
 * @author A3
 */
public class MonsterComboBox extends JComboBox {
    private final String index0;
    
    public MonsterComboBox(String index0) {
        super();
        this.index0 = index0;
        fillBox();
    }

    public MonsterComboBox() {
        super();
        this.index0 = "-Select a Monster-";
        fillBox();
    }
    
    
    
    public void refresh() {
        this.removeAllItems();
        fillBox();
    }

    private void fillBox() {
        BatchFileHandler batch = new BatchFileHandler();
        this.addItem(index0);
        for (String i : batch.loadAllFileNames(Monster.class)) {
            this.addItem(i);
        }
        this.setMaximumRowCount(this.getItemCount());
    }
}

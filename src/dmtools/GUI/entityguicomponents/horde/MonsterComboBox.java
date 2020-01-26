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

    public MonsterComboBox() {
        super();
        fillBox();
    }
    
    public void refresh() {
        this.removeAllItems();
        fillBox();
    }

    private void fillBox() {
        BatchFileHandler batch = new BatchFileHandler();
        this.addItem("-Select a Monster-");
        for (String i : batch.loadAllFileNames(Monster.class)) {
            this.addItem(i);
        }
        this.setMaximumRowCount(this.getItemCount());
    }
}

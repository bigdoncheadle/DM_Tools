/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.filehandling;

import dmtools.game.entities.Monster;
import dmtools.game.entities.PC;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

/**
 *
 * @author A3
 */
public class BatchFileHandler {

    public BatchFileHandler() {
    }

    public ArrayList<PC> loadAllPcs() throws Exception {
        ArrayList<PC> pcs = new ArrayList();
        File pcDir = new File("User/PCs");
        for (File i : pcDir.listFiles(new DndFileFilter(DndFileFilter.PC))) {
            pcs.add((PC) FileHandler.loadFromFile(i));
        }
        return pcs;
    }

    public ArrayList<Monster> loadAllMonsters() throws Exception {
        ArrayList<Monster> monsters = new ArrayList();
        File monDir = new File("User/Monsters");
        for (File i : monDir.listFiles(
                new DndFileFilter(DndFileFilter.MONSTER))) {
            monsters.add((Monster) FileHandler.loadFromFile(i));
        }
        return monsters;
    }
}

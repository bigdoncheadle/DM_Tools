/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.filehandling;

import dmtools.game.entities.PC;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

/**
 *
 * @author A3
 */
public class BatchFileHandler implements FileFilter{
    public BatchFileHandler() {
    }
    
    public ArrayList<PC> loadAllPcs() throws Exception{
        ArrayList<PC> pcs = new ArrayList();
        File pcDir = new File("User/PCs");
        for (File i : pcDir.listFiles(this)) {
            pcs.add((PC) FileHandler.loadFromFile(i));
        }
        return pcs;
    }

    @Override
    public boolean accept(File f) {
        return f.getPath().endsWith(".pc");
    }
}

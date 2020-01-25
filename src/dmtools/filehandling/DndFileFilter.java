/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.filehandling;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author A3
 */
public class DndFileFilter implements FileFilter{
    static int PC = 0;
    static int MONSTER = 1;
    
    private final int fileType;
    public DndFileFilter(int fileType) {
        this.fileType = fileType;
    }
    

    @Override
    public boolean accept(File pathname) {
        if (this.fileType == PC) {
            return pathname.getPath().endsWith(".pc");
        }
        if (this.fileType == MONSTER) {
            return pathname.getPath().endsWith(".mon");
        }
        return false;
    }
}

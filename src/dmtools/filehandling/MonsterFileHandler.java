/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.filehandling;

import dmtools.game.entities.Monster;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author A3
 */
public class MonsterFileHandler {

    public MonsterFileHandler() {
    }
    
    static Monster read(Properties monProperties) {
        String name = monProperties.getProperty("monsterName");
        String monsterType = name; // Until monsterType is actually used
        int AC = Integer.parseInt(monProperties.getProperty("armorClass"));
        int HP = Integer.parseInt(monProperties.getProperty("maxHP"));
        int CR = Integer.parseInt(monProperties.getProperty("challengeRating"));
        
        return new Monster(name, monsterType, AC, HP, CR);
    }

    static void write(Monster monster, File monFile) throws IOException {
        try {
            FileWriter fWrite = new FileWriter(monFile);
            fWrite.write("monsterName=" + monster.getName());
            fWrite.write("\n");
            fWrite.write("armorClass=" + monster.getAC());
            fWrite.write("\n");
            fWrite.write("maxHP=" + monster.getMaxHP());
            fWrite.write("\n");
            fWrite.write("challengeRating=" + monster.getCR());
            
            fWrite.close();
        } catch (IOException e) {
            throw new IOException("Error occured writing monster to file");
        }
    }
}

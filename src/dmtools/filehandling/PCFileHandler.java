/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.filehandling;

import dmtools.game.entities.PC;
import dmtools.game.entities.characteristics.Alignment;
import dmtools.game.entities.characteristics.Race;
import dmtools.game.entities.numericals.StatBlock;
import dmtools.game.entities.numericals.enums.Skill;
import dmtools.game.playableclasses.PlayableClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import javax.imageio.IIOException;
import javax.swing.SwingUtilities;

/**
 *
 * @author A3
 */
public class PCFileHandler {

    public PCFileHandler() {
    }

//    static PC load(String name) throws IOException {
//        InputStream iStream;
//        Properties playerProperties = new Properties();
//        String propFileName = "PCs/" + name.toUpperCase() + ".pc";
//        File pcFile = new File(propFileName);
//
//        if (pcFile.isFile()) {
//            iStream = new FileInputStream(pcFile);
//            playerProperties.load(iStream);
//            iStream.close();
//            return generatePC(playerProperties);
//        } else {
//            throw new FileNotFoundException("No such player found.");
//        }
//    }

//    public static void save(PC pc) throws IOException {
//        String fileName = "PCs/" + pc.getName().toUpperCase() + ".pc";
//        File pcFile = new File(fileName);
//        if (!pcFile.isFile()) {//if the player file doesn't exists
//            try {
//                pcFile.createNewFile();
//            } catch (IOException e) {
//                throw new IIOException("Something went wrong creating a new file");
//            }
//        }
//
//        //once file is found/created, the PC is written to the file
//        try {
//            write(pc, pcFile);
//        } catch (IOException e) {
//            throw new IOException("Something went wrong writing to the file at "
//                    + pcFile.getPath());
//        }
//    }

    static PC read(Properties playerProperties) {
        String characterName = playerProperties.getProperty("characterName");
        String playerName = playerProperties.getProperty("playerName");
        Race race = Race.valueOf(playerProperties.getProperty("race"));
        Alignment alignment = Alignment.valueOf(
                playerProperties.getProperty("alignment"));
        PlayableClass playableClass = PlayableClass.valueOf(
                playerProperties.getProperty("playableClass"));
        int characterLevel = Integer.parseInt(playerProperties.getProperty(
                "characterLevel"));
        StatBlock statBlock = generateStatBlock(playerProperties.getProperty(
                "statBlock"));
        HashSet<Skill> selectedSkills = generateSelectedSkillsSet(
                playerProperties.getProperty("selectedSkills"));
        int AC = Integer.parseInt(playerProperties.getProperty("armorClass"));
        int maxHP = Integer.parseInt(playerProperties.getProperty("maxHP"));
        int currentHP = Integer.parseInt(playerProperties.getProperty(
                "currentHP"));
        //inventory goes here
        //wealth goes here
        //others here

        return new PC(characterName, playerName, race, alignment, playableClass,
                characterLevel, statBlock, selectedSkills, AC, maxHP, currentHP);
    }

    static void write(PC pc, File pcFile) throws IOException {
        try {
            FileWriter fWrite = new FileWriter(pcFile);
            fWrite.write("characterName=" + pc.getName());
            fWrite.write("\n");
            fWrite.write("playerName=" + pc.getPlayerName());
            fWrite.write("\n");
            fWrite.write("race=" + pc.getRace().name());
            fWrite.write("\n");
            fWrite.write("alignment=" + pc.getAlignment().name());
            fWrite.write("\n");
            fWrite.write("playableClass=" + pc.getPlayableClass().name());
            fWrite.write("\n");
            fWrite.write("characterLevel=" + pc.getCharacterLevel());
            fWrite.write("\n");
            fWrite.write("statBlock=" + pc.getStatBlock().write());
            fWrite.write("\n");
            fWrite.write("selectedSkills=" + pc.writeSelectedSkills());
            fWrite.write("\n");
            fWrite.write("armorClass=" + pc.getAC());
            fWrite.write("\n");
            fWrite.write("maxHP=" + pc.getMaxHP());
            fWrite.write("\n");
            fWrite.write("currentHP=" + pc.getCurrentHP());
            //invenetory goes here
            //wealth goes here
            //other stuff can go here

            fWrite.close();
        } catch (IOException e) {
            throw new IOException();
        }
    }

    private static StatBlock generateStatBlock(String statString) {
        String[] statValueString = statString.split(" ");
        int[] statValues = new int[6];
        for (int i = 0; i < statValueString.length; i++) {
            statValues[i] = Integer.parseInt(statValueString[i]);
        }

        return new StatBlock(statValues);
    }

    private static HashSet<Skill> generateSelectedSkillsSet(String skills) {
        HashSet<Skill> selectedSkills = new HashSet();
        String[] separatedSkills = skills.split(" ");
        for (String separatedSkill : separatedSkills) {
            selectedSkills.add(Skill.valueOf(separatedSkill));
        }

        return selectedSkills;
    }
}

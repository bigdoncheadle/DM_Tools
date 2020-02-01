/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.filehandling;

import dmtools.playermgmt.PlayerParty;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author A3
 */
public class Initialize {

    public Initialize() {
    }

    public static void setup() {
        validateDirectories();
    }
    
    public static PlayerParty getParty() throws Exception{
        try {
            return (PlayerParty) FileHandler.loadFromName("party", 
                    FileHandler.PLAYER_PARTY_FILE);
        } catch (IOException e) {
            throw new FileNotFoundException("error loading party file");
        }
    }

//    public PlayerParty getParty() {
//
//    }

    private static void validateDirectories() {
        // Loads the property file 
        Properties filePaths = new Properties();
        InputStream iStream
                = Initialize.class.getResourceAsStream("filepath.properties");
        try {
            filePaths.load(iStream);
        } catch (IOException e) {
        }
        
        // Checks Config Directory
        File configDir = new File(filePaths.getProperty("configPath"));
        if (!configDir.isDirectory()) {
            configDir.mkdirs();
        }
        
        // Checks campaign properties
        File config = new File(filePaths.getProperty("campaignPropFile"));
        if (!config.isFile()) {
            try {
            config.createNewFile();
            // Do more stuff here when properties are needed.
            } catch (IOException e) {
            }
        }
        
        // Checks for Campaign Directory
        File campaign = new File(filePaths.getProperty("campaignPath"));
        if (!campaign.isDirectory()) {
            campaign.mkdirs();
        }
        
        // Checks for the party.pty file
        File party = new File(filePaths.getProperty("partyFile"));
        //creates a new party.pty file if it is not found
        if (!party.isFile()) {
            try {
                party.createNewFile();
                PartyFileHandler.makeNew(PartyFileHandler.PLAYER_PARTY, party);
            } catch (IOException e) {
            }
        }
        
        // Checks for the PC directory
        File pcPath = new File(filePaths.getProperty("pcPath"));
        if (!pcPath.isDirectory()) {
            pcPath.mkdir();
        }
        
        // Checks for the Monster directory
        File monPath = new File(filePaths.getProperty("monsterPath"));
        if (!monPath.isDirectory()) {
            monPath.mkdir();
        }
    }
}

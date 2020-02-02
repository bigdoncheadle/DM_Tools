/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.filehandling;

import dmtools.game.entities.PC;
import dmtools.playermgmt.Party;
import dmtools.playermgmt.PlayerParty;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

/**
 *
 * @author A3
 */
public class PartyFileHandler {

    static int PLAYER_PARTY = 256;
    static int MONSTER_PARTY = 477;

    public PartyFileHandler() {
    }

    static Party read(Properties partyProperties, int partyType)
            throws IOException {

        //Player Party
        if (partyType == PLAYER_PARTY) {
            PlayerParty playerParty = new PlayerParty(
                    partyProperties.getProperty("partyName"));
            if (!partyProperties.getProperty("members").equals("null")) {
                StringBuilder memberString = new StringBuilder();
                memberString.append(partyProperties.getProperty("members"));
                String[] members = memberString.toString().split("\\$");
                for (String i : members) {
                    try {
                        playerParty.add((PC) FileHandler.loadFromName(i,
                                FileHandler.PC_FILE));
                    } catch (IOException e) {
                        throw new IOException("Party member " + i + "'s file could "
                                + "not be found");
                    }
                }
            }
            return playerParty;

        } else {
            return null;
        }
    }

    static void write(Party party, int partyType, File partyFile)
            throws IOException {

        //Player party
        if (partyType == PLAYER_PARTY) {
            try {
                FileWriter fWrite = new FileWriter(partyFile);
                fWrite.write("partyName=");
                fWrite.write(party.getName() + "\n");
                fWrite.write("members=");
                if (party.getMembers().isEmpty()) {
                    fWrite.write("null");
                } else {
                    Iterator it = party.getMembers().iterator();
                    while (it.hasNext()) {
                        PC i = (PC) it.next();
                        fWrite.write(i.getName());
                        if (it.hasNext()) {
                            fWrite.write("$");
                        }
                    }
                }
                fWrite.close();

            } catch (IOException e) {
                throw new IOException();
            }

        } //if the method is not given a proper party type
        else {
            throw new IOException("Party type not supported/found");
        }
    }

    static void makeNew(int partyType, File partyFile) {
        FileWriter fWrite;
        if (partyType == PLAYER_PARTY) {
            try {
                fWrite = new FileWriter(partyFile);
                fWrite.write("partyName=New Party\n");
                fWrite.write("members=null");
                fWrite.close();
            } catch (IOException e) {
            }
        }
    }
}

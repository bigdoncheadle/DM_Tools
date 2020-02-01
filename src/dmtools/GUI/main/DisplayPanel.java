/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.main;

import dmtools.GUI.initiativeguicomponents.RunEncounterPanel;
import dmtools.GUI.initiativeguicomponents.getinitiative.panels.CreateEncounterPanel;
import dmtools.GUI.main.homepage.HomePanel;
import dmtools.GUI.partymgmt.PartyMgmtPanel;
import dmtools.playermgmt.PlayerParty;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author A3
 */
public class DisplayPanel extends JPanel{
    private CardLayout cardLayout;
    
    private HomePanel home;
    private PartyMgmtPanel partyMgmt;
    private CreateEncounterPanel createEncounter;
    private RunEncounterPanel encounter;
    private FeatureComingSoon comingSoon;
    
    public final static String HOME = "Home Page";
    public final static String PARTYMGMT = "Party Management Panel";
    public final static String ENCOUNTER = "Either Encounter Panel";
    public final static String COMING_SOON = "Feature Coming Soon";
    
    private final static String CREATE_ENCOUNTER = "Create Encounter Panel";
    private final static String RUN_ENCOUNTER = "Run an Encounter Panel";
    
    private PlayerParty party;
    private final String version;
    private boolean inCombat;
    
    public DisplayPanel(String version, PlayerParty party) {
        super();
        this.party = party;
        this.version = version;
        this.inCombat = false;
        createComponents();
    }
    
    public boolean isInCombat() {
        return inCombat;
    }
    
    public void show(String panelName) {
        if (panelName.equals(PARTYMGMT)) {
            cardLayout.show(this, PARTYMGMT);
        }
        
        if (panelName.equals(ENCOUNTER)) {
            if (inCombat) {
                
            } else {
            if (!partyMgmt.getParty().equals(party)) {
                this.party = partyMgmt.getParty();
                createEncounter.updateParty(party);
            }
            cardLayout.show(this, CREATE_ENCOUNTER);
            }
        }
        
        if (panelName.equals(COMING_SOON)) {
            cardLayout.show(this, COMING_SOON);
        }
    }
    
    private void createComponents() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        
        // Home
        home = new HomePanel(version);
        add(home, HOME);
        
        // Party Management
        partyMgmt = new PartyMgmtPanel(party);
        add(partyMgmt, PARTYMGMT);
        
        // Create Encounter
        createEncounter = new CreateEncounterPanel(party);
        add(createEncounter, CREATE_ENCOUNTER);
        
        // Feature Coming Soon
        comingSoon = new FeatureComingSoon();
        add(comingSoon, COMING_SOON);
    }
}

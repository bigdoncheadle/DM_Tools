/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.initiativeguicomponents.panels;

import dmtools.GUI.LayoutConstants;
import dmtools.GUI.entityguicomponents.panels.masterpanels.HordePanel;
import dmtools.GUI.entityguicomponents.panels.masterpanels.MonsterPanel;
import dmtools.GUI.entityguicomponents.panels.masterpanels.PCPanel;
import dmtools.game.initiative.InitiativeTracker;
import java.awt.CardLayout;
import javax.swing.JPanel;
import dmtools.GUI.initiativeguicomponents.Cyclable;
import dmtools.game.entities.DNDEntity;
import dmtools.game.entities.Horde;
import dmtools.game.entities.Monster;
import dmtools.game.entities.PC;
import javax.swing.BorderFactory;

/**
 *
 * @author A3
 */
public class InitiativeEntityCardPanel extends JPanel implements Cyclable{
    private InitiativeTracker iTrack;
    private CardLayout cardLayout;

    public InitiativeEntityCardPanel(InitiativeTracker iTrack) {
        super();
        this.iTrack = iTrack;
        this.cardLayout = new CardLayout();
        setLayout(cardLayout);
        addCards();
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, 
                LayoutConstants.SUB_PANEL_BORDER_COLOR));
    
    
    }
    
    private void addCards() {
        for (DNDEntity i : iTrack.getEntityList()) {
            if (i.getClass() == PC.class) {
                add(new PCPanel((PC)i));
            }
            if (i.getClass() == Monster.class) {
                add(new MonsterPanel((Monster)i));
            }
            if (i.getClass() == Horde.class) {
                add(new HordePanel((Horde)i));
            }
        }
    }
    
    @Override
    public void cycleForward() {
        cardLayout.next(this);
    }

    @Override
    public void cycleBack() {
        cardLayout.previous(this);
    }
    
}

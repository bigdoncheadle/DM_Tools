/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.testing;

import dmtools.game.entities.PC;
import dmtools.game.entities.characteristics.Alignment;
import dmtools.game.entities.characteristics.Race;
import dmtools.game.entities.numericals.StatBlock;
import dmtools.game.entities.numericals.enums.Skill;
import dmtools.game.playableclasses.PlayableClass;
import dmtools.playermgmt.PlayerParty;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

/**
 *
 * @author A3
 */
public class TestingEntities {

    private static final Skill[] exampleSkills = new Skill[]{Skill.ARCANA, Skill.STEALTH};

    public static PC TESTING_PC1 = new PC("Testing1", "Developer", Race.DWARF,
            Alignment.LAWFUL_EVIL, PlayableClass.BARBARIAN, 20, new StatBlock(),
            new HashSet<Skill>(Arrays.asList(exampleSkills)), 20, 100, 100);

    public static PC TESTING_PC2 = new PC("Testing2", "Developer", Race.DWARF,
            Alignment.LAWFUL_EVIL, PlayableClass.BARBARIAN, 20, new StatBlock(),
            new HashSet<Skill>(Arrays.asList(exampleSkills)), 20, 100, 100);

    private static final PC PCS[] = {TESTING_PC1, TESTING_PC2};

    public static PlayerParty TESTING_PARTY = new PlayerParty("Testing Party",
            new TreeSet<PC>(Arrays.asList(PCS)));
}

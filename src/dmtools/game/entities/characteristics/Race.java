/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.game.entities.characteristics;

/**
 *
 * @author A3
 */
public enum Race {
    DRAGONBORN("Dragonborn"),
    DWARF("Dwarf"),
    ELF("Elf"),
    GNOME("Gnome"),
    HALF_ELF("Half Elf"),
    HALF_ORC("Half Orc"),
    HALFLING("Halfling"),
    HUMAN("Human"),
    TIEFLING("Tiefling");

    private String name;

    private Race(String name) {
        this.name = name;
    }

    public static Race stringValueOf(String name) {
        String fixedName = name.replaceAll(" ", "_");
        return Race.valueOf(fixedName.toUpperCase());
    }

    @Override
    public String toString() {
        return name;
    }

}

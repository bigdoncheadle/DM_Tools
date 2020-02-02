/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI;

import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author A3
 */
public class LayoutConstants {
    //Font Sizes
    public static float HEADER_FONT_SIZE = 30f;
    
    //Layout Colors
    public static Color YELLOW = Color.decode("#C2983D");
    public static Color CHARCOAL = Color.decode("#262425");
    public static Color DARKOAL = Color.decode("#141314");
    public static Color GREEN = Color.decode("#303D38");
    public static Color BEIGE = Color.decode("#928A74");
    public static Color RED = Color.decode("#380909");
    public static Color DARK_GREEN = Color.decode("#1c2421");
    
    //Panel Colors
    public static Color MAIN_PANEL_COLOR = DARKOAL;
    public static Color PLAYER_CARD_COLOR = GREEN;
    public static Color SUB_PANEL_COLOR = GREEN;
    public static Color SUB_PANEL_BORDER_COLOR = YELLOW;
    public static Color NAV_PANEL_COLOR = Color.BLACK;
    public static Color BUTTON_PANEL_BACKGROUND = DARK_GREEN;
    
    //Button Sizes
    public static final int NAVIGATOR_BUTTON_SIZE = 60;
    public static final int ENCOUNTER_BUTTON_SIZE = 40;
    
    //Button Colors
    public static final String ARROW_COLOR = "YELLOW";
    public static final String ARROW_CLICK_COLOR = "GREEN";
    public static final String EXIT_COLOR = "RED";
    public static final String EXIT_CLICK_COLOR = "YELLOW";
    
    public static final String NAVIGATOR_ICON_COLOR = "RED";
    public static final String NAVIGATOR_ICON_CLICK = "YELLOW";
    public static final Color NAVIGATOR_BUTTON_COLOR = BEIGE;

    /*
    * PLAYABLE CHARACTER PANEL
    */
    
    
    /*
    * INITIATIVE PANEL
    */
    
    public static Color getColor(String color) {
        if (color.equalsIgnoreCase("red")) {
            return RED;
        }
        if (color.equalsIgnoreCase("yellow")) {
            return YELLOW;
        }
        if (color.equalsIgnoreCase("black")) {
            return CHARCOAL;
        }
        if (color.equalsIgnoreCase("green")) {
            return GREEN;
        }
        if (color.equalsIgnoreCase("beige")) {
            return BEIGE;
        }
        else return null;
    }
}



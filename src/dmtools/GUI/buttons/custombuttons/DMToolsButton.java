/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmtools.GUI.buttons.custombuttons;

import dmtools.GUI.LayoutConstants;
import java.awt.Image;
import java.awt.Insets;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author A3
 */
public class DMToolsButton extends JButton {

    private static final int BUTTON_SIZE
            = LayoutConstants.NAVIGATOR_BUTTON_SIZE;

    public DMToolsButton() {
        super();
        try {
            //Main icon for button
            URL defaultURL = getClass().getResource(
                    "icons/tools_" + LayoutConstants.NAVIGATOR_ICON_COLOR
                    + ".png");
            ImageIcon originalIcon = new ImageIcon(defaultURL);
            Image scaledImg = originalIcon.getImage();
            scaledImg = scaledImg.getScaledInstance(BUTTON_SIZE, BUTTON_SIZE,
                    java.awt.Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(scaledImg));

            //Hover icon for button
            URL hoverURL = getClass().getResource(
                    "icons/tools_" + LayoutConstants.NAVIGATOR_ICON_COLOR
                    + "_hover.png");
            originalIcon = new ImageIcon(hoverURL);
            scaledImg = originalIcon.getImage();
            scaledImg = scaledImg.getScaledInstance(BUTTON_SIZE, BUTTON_SIZE,
                    java.awt.Image.SCALE_SMOOTH);
            setRolloverIcon(new ImageIcon(scaledImg));

            //Pressed icon for button
            URL pressedURL = getClass().getResource(
                    "icons/tools_" + LayoutConstants.NAVIGATOR_ICON_CLICK
                    + ".png");
            originalIcon = new ImageIcon(pressedURL);
            scaledImg = originalIcon.getImage();
            scaledImg = scaledImg.getScaledInstance(BUTTON_SIZE, BUTTON_SIZE,
                    java.awt.Image.SCALE_SMOOTH);
            setPressedIcon(new ImageIcon(scaledImg));

            //Overall button settings
            setBorderPainted(false);
            setBorder(null);
            setMargin(new Insets(0, 0, 0, 0));
            setContentAreaFilled(false);
            setBackground(LayoutConstants.NAVIGATOR_BUTTON_COLOR);
            setToolTipText("Tools to help you run your campaign");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

package com.blogspot.inimushawa;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BhasIcons {

    private static final BhasIcons icon = new BhasIcons();

    private BhasIcons() {
    }

    public static Image getIconAbout() {
        return new ImageIcon(icon.getClass().getResource("bhas.png")).getImage();
    }

    public static Image getIconExplain() {
        return new ImageIcon(icon.getClass().getResource("coe.png")).getImage();
    }

    public static Image getIconTray() {
        return new ImageIcon(icon.getClass().getResource("min.png")).getImage();
    }
}

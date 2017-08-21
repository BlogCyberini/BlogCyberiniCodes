package com.blogspot.inimushawa;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Run {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
            @Override
            public void run() {
                try {
                    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Metal".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                    new GUIBhaskara();
                } catch (Exception e) {
                    System.exit(1);
                }
            }
        }
        );

    }

}

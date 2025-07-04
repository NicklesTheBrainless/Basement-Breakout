package base;

import base.panel.GamePanel;

import javax.swing.*;

import static base.setting.Settings.TITLE;

public class Main {

    public static void main(String[] args) {

        // create window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // set title and if it is resizable
        window.setTitle(TITLE);
        window.setResizable(false);

        // create the GamePanel and add it to the window
        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();

        //////////////////////////
        // set window icon here //
        //////////////////////////

        // center window on the screen and make it visible
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // start game
        gp.startProgramThread();
    }
}
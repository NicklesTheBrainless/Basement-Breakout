package game;

import base.listeners.KeyHandler;
import base.panel.GamePanel;
import utils.GameObject;

import java.awt.*;

public class Platform extends Rectangle implements GameObject {

    GamePanel gp;
    KeyHandler keyH;

    public Platform(GamePanel gp) {
        this.gp = gp;
        this.keyH = gp.keyH;
    }



    @Override
    public void update(double delta) {

    }

    @Override
    public void draw(Graphics2D g2) {

    }

}

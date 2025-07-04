package game;

import base.panel.GamePanel;
import utils.GameObject;

import java.awt.*;

public class Block extends Rectangle implements GameObject {

    GamePanel gp;

    Color color;

    public Block(GamePanel gp, Color color) {
        this.gp = gp;
        this.color = color;
    }



    @Override
    public void update(double delta) {

    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(x, y, width, height);
    }
}

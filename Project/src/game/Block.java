package game;

import utils.GameObject;

import java.awt.*;

import static base.setting.Settings.STANDARD_BLOCK_HEIGHT;
import static base.setting.Settings.STANDARD_BLOCK_WIDTH;

public class Block extends Rectangle implements GameObject {

    Color color;

    public Block(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;

        this.width  = STANDARD_BLOCK_WIDTH;
        this.height = STANDARD_BLOCK_HEIGHT;
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

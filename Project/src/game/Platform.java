package game;

import base.listeners.KeyHandler;
import base.panel.GamePanel;
import utils.GameObject;

import java.awt.*;

import static base.setting.Settings.*;

public class Platform extends Rectangle implements GameObject {

    GamePanel gp;
    KeyHandler keyH;

    public Platform(GamePanel gp) {
        this.gp = gp;
        this.keyH = gp.keyH;

        this.x = PLATFORM_X;
        this.y = PLATFORM_Y;
        this.width = PLATFORM_WIDTH;
        this.height = PLATFORM_HEIGHT;
    }



    @Override
    public void update(double delta) {

        if (keyH.A_justPressed)
            x -= PLATFORM_SPEED;
        if (keyH.D_justPressed)
            x += PLATFORM_SPEED;

    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(PLATFORM_COLOR);
        g2.drawOval(x, y, 5, 5);
        g2.fillRect(x, y, width, height);
        System.out.println(x + " " + y + "            :            " + width + " " + height);
    }

}

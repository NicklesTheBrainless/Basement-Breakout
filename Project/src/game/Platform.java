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

        updateMovement();
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(PLATFORM_COLOR);
        g2.fillRect(x, y, width, height);
    }



    void updateMovement() {

        if (keyH.A_pressed) {
            x -= PLATFORM_SPEED;
            if (x < 0)
                x = 0;
        }
        if (keyH.D_pressed){
            x += PLATFORM_SPEED;
            if (x + PLATFORM_WIDTH >= WIDTH)
                x = WIDTH - PLATFORM_WIDTH;
        }
    }

}

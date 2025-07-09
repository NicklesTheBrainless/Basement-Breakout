package game;

import base.listeners.KeyHandler;
import base.panel.GamePanel;
import utils.GameObject;

import java.awt.*;

import static base.setting.GameSettings.*;
import static base.setting.GeneralSettings.*;
import static utils.Utils.random;

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

        if (keyH.W_pressed && gp.balls.isEmpty())
            spawnBall();
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
            if (x + PLATFORM_WIDTH >= GAME_WIDTH)
                x = GAME_WIDTH - PLATFORM_WIDTH;
        }
    }



    void spawnBall() {
        double angle = random.nextDouble(-MAX_BOUNCE_ANGLE, MAX_BOUNCE_ANGLE);
        double vx = STANDARD_BALL_SPEED * Math.sin(angle);
        double vy = -STANDARD_BALL_SPEED * Math.cos(angle);
        Ball ball = new Ball(gp, x + width/2.0, y - STANDARD_BALL_RADIUS - 2, vx, vy);
        gp.balls.add(ball);
    }

}

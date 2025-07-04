package game;

import base.panel.GamePanel;
import utils.GameObject;

import java.awt.*;

import static base.setting.Settings.STANDARD_BALL_RADIUS;

public class Ball implements GameObject {

    GamePanel gp;

    public double x;
    public double y;

    public double vx;
    public double vy;

    public double radius = STANDARD_BALL_RADIUS;

    public Ball(GamePanel gp, double x, double y, double vx, double vy) {
        this.gp = gp;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }



    @Override
    public void update(double delta) {

        updateVelocity();

        updateWallCollisions();
        updateBlockCollisions();

    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillOval((int) (x - radius), (int) (y - radius), (int) (radius * 2), (int) (radius * 2));
    }



    void updateVelocity() {
        x += vx;
        y += vy;
    }

    void updateWallCollisions() {

        boolean collidesWallX = CollisionLogic.checkBallCollidesWallsX(this);
        if (collidesWallX)
            x = -x;

        boolean collidesWallY = CollisionLogic.checkBallCollidesWallsY(this);
        if (collidesWallY)
            y = -y;
    }

    void updateBlockCollisions() {

        for (Block block : gp.blocks)
            evaluateBlockCollision(block);
    }



    void evaluateBlockCollision(Block block) {

        boolean collidesBlockX = CollisionLogic.checkBallCollidesRectX(this, block);
        if (collidesBlockX)
            x = -x;

        boolean collidesBlockY = CollisionLogic.checkBallCollidesRectY(this, block);
        if (collidesBlockY)
            y = -y;
    }

}

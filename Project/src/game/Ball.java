package game;

import base.panel.GamePanel;
import game.logic.CollisionLogic;
import utils.GameObject;

import java.awt.*;

import static base.setting.Settings.MAX_BOUNCE_ANGLE;
import static base.setting.Settings.STANDARD_BALL_RADIUS;

public class Ball implements GameObject {

    GamePanel gp;
    Platform platform;

    public double x;
    public double y;

    public double vx;
    public double vy;

    public double radius = STANDARD_BALL_RADIUS;

    public Ball(GamePanel gp, double x, double y, double vx, double vy) {
        this.gp = gp;
        this.platform = gp.platform;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }



    @Override
    public void update(double delta) {

        updateVelocity();

        updatePlatformBounce();

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

    void updatePlatformBounce() {

        boolean collidesPlatformX = CollisionLogic.checkBallCollidesRectAxisX(this, platform);
        boolean collidesPlatformY = CollisionLogic.checkBallCollidesRectAxisY(this, platform);

        if (collidesPlatformX || collidesPlatformY) {
            y -= vy;
            vy = -vy;

            double platformCenter = platform.x + (platform.width / 2.0);
            double distanceFromCenter = x - platformCenter;

            double normalizedOffset = distanceFromCenter / (platform.width / 2.0);

            double bounceAngle = normalizedOffset * MAX_BOUNCE_ANGLE;

            double speed = Math.sqrt(vx * vx + vy * vy);
            vx = speed * Math.sin(bounceAngle);
            vy = -speed * Math.cos(bounceAngle);
        }
    }

    void updateWallCollisions() {

        boolean collidesLeftWall  = CollisionLogic.checkBallCollidesLeftWall(this);
        boolean collidesRightWall = CollisionLogic.checkBallCollidesRightWall(this);
        if (collidesLeftWall || collidesRightWall)
            vx = -vx;

        boolean collidesTopWall = CollisionLogic.checkBallCollidesTopWall(this);
        if (collidesTopWall)
            vy = -vy;

        boolean collidesBottomWall = CollisionLogic.checkBallCollidesBottomWall(this);
        if (collidesBottomWall)
            throw new RuntimeException("skill issue");
    }

    void updateBlockCollisions() {

        for (Block block : gp.blocks)
            evaluateBlockCollision(block);
    }



    void evaluateBlockCollision(Block block) {

        boolean collidesBlockX = CollisionLogic.checkBallCollidesRectAxisX(this, block);
        if (collidesBlockX)
            x = -x;

        boolean collidesBlockY = CollisionLogic.checkBallCollidesRectAxisY(this, block);
        if (collidesBlockY)
            y = -y;
    }

}

package game;

import base.panel.GamePanel;
import game.logic.CollisionLogic;
import utils.GameObject;

import java.awt.*;

import static base.setting.GameSettings.*;
import static base.setting.GeneralSettings.*;

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
        g2.setColor(BALL_COLOR);
        g2.fillOval((int) (x - radius), (int) (y - radius), (int) (radius * 2), (int) (radius * 2));
    }



    void updateVelocity() {
        x += vx;
        y += vy;
    }

    void updatePlatformBounce() {

        boolean collidesPlatformX = CollisionLogic.checkBallCollidesRectX(this, platform);
        boolean collidesPlatformY = CollisionLogic.checkBallCollidesRectY(this, platform);

        if (collidesPlatformY || collidesPlatformX) {

            if (collidesPlatformX)
                x -= vx;

            y -= vy;
            vy = -vy;

            boolean collidesPlatformX2 = CollisionLogic.checkBallCollidesRectX(this, platform);
            boolean collidesPlatformY2 = CollisionLogic.checkBallCollidesRectY(this, platform);
            if (collidesPlatformX2 || collidesPlatformY2)
                System.err.println("fuck, it still collides with the bouncy platform, the ball you knowww \n");

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

        for (int i = 0; i < gp.blocks.size(); i++) {

            Block block = gp.blocks.get(i);
            boolean hit = evaluateBlockCollision(block);
            if (hit) {
                gp.blocks.remove(i);
                break;
            }
        }

    }



    boolean evaluateBlockCollision(Block block) {

        boolean collidesX = CollisionLogic.checkBallCollidesRectX(this, block);
        boolean collidesY = CollisionLogic.checkBallCollidesRectY(this, block);

        boolean onlyCollidesX = (collidesX && !collidesY);
        boolean onlyCollidesY = (collidesY && !collidesX);
        boolean bothCollides  = (collidesX && collidesY);

        if (onlyCollidesX) {
            vx = -vx;
            return true;
        }
        if (onlyCollidesY)  {
            vy = -vy;
            return true;
        }
        if (bothCollides) {

            boolean xIsDominant = Math.abs(vx) > Math.abs(vy);
            if (xIsDominant)
                vx = -vx;
            else
                vy = -vy;

            return true;
        }

        return false;
    }

}

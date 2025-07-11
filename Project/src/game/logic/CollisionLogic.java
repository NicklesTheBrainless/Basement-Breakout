package game.logic;

import game.Ball;

import java.awt.*;

import static base.setting.GeneralSettings.GAME_HEIGHT;
import static base.setting.GeneralSettings.GAME_WIDTH;
import static java.lang.Math.clamp;

public abstract class CollisionLogic {



    public static boolean checkBallCollidesLeftWall(Ball ball) {
        return (ball.x - ball.radius) < 0;
    }

    public static boolean checkBallCollidesRightWall(Ball ball) {
        return (ball.x + ball.radius) > GAME_WIDTH;
    }

    public static boolean checkBallCollidesTopWall(Ball ball) {
        return (ball.y - ball.radius) < 0;
    }

    public static boolean checkBallCollidesBottomWall(Ball ball) {
        return (ball.y + ball.radius) > GAME_HEIGHT;
    }



    public static boolean checkBallCollidesRectX(Ball ball, Rectangle rect) {

        double closestX = clamp(ball.x, rect.x, rect.x + rect.width);
        double closestY = clamp(ball.y, rect.y, rect.y + rect.height);

        double dx = ball.x - closestX;
        double dy = ball.y - closestY;

        boolean isColliding = (dx * dx + dy * dy) < (ball.radius * ball.radius);
        if (!isColliding)
            return false;

        return Math.abs(dx) > Math.abs(dy);
    }

    public static boolean checkBallCollidesRectY(Ball ball, Rectangle rect) {

        double closestX = clamp(ball.x, rect.x, rect.x + rect.width);
        double closestY = clamp(ball.y, rect.y, rect.y + rect.height);

        double dx = ball.x - closestX;
        double dy = ball.y - closestY;

        boolean isColliding = (dx * dx + dy * dy) < (ball.radius * ball.radius);
        if (!isColliding)
            return false;

        return Math.abs(dy) > Math.abs(dx);
    }

}

package game.logic;

import game.Ball;

import java.awt.*;

import static base.setting.Settings.HEIGHT;
import static base.setting.Settings.WIDTH;

public abstract class CollisionLogic {



    public static boolean checkBallCollidesLeftWall(Ball ball) {
        return (ball.x - ball.radius) < 0;
    }

    public static boolean checkBallCollidesRightWall(Ball ball) {
        return (ball.x + ball.radius) > WIDTH;
    }

    public static boolean checkBallCollidesTopWall(Ball ball) {
        return (ball.y - ball.radius) < 0;
    }

    public static boolean checkBallCollidesBottomWall(Ball ball) {
        return (ball.y + ball.radius) > HEIGHT;
    }



    public static boolean checkBallCollidesRectAxisX(Ball ball, Rectangle rect) {

        double closestX = clamp(ball.x, rect.x, rect.x + rect.width);
        double closestY = clamp(ball.y, rect.y, rect.y + rect.height);

        double dx = ball.x - closestX;
        double dy = ball.y - closestY;

        boolean isColliding = (dx * dx + dy * dy) < (ball.radius * ball.radius);
        if (!isColliding)
            return false;

        double leftDistance  = Math.abs(ball.x - rect.x);
        double rightDistance = Math.abs(ball.x - (rect.x + rect.width));

        return leftDistance < ball.radius || rightDistance < ball.radius;
    }

    public static boolean checkBallCollidesRectAxisY(Ball ball, Rectangle rect) {

        double closestX = clamp(ball.x, rect.x, rect.x + rect.width);
        double closestY = clamp(ball.y, rect.y, rect.y + rect.height);

        double dx = ball.x - closestX;
        double dy = ball.y - closestY;

        boolean isColliding = (dx * dx + dy * dy) < (ball.radius * ball.radius);
        if (!isColliding)
            return false;

        double topDistance = Math.abs(ball.y - rect.y);
        double bottomDistance = Math.abs(ball.y - (rect.y + rect.height));

        return topDistance < ball.radius || bottomDistance < ball.radius;
    }



    private static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

}

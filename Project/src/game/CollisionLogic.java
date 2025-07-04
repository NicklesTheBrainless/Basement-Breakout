package game;

import java.awt.*;

import static base.setting.Settings.HEIGHT;
import static base.setting.Settings.WIDTH;

public abstract class CollisionLogic {



    public static boolean checkBallCollidesWallsX(Ball ball) {

        double leftEdge  = ball.x - ball.radius;
        double rightEdge = ball.x + ball.radius;

        return (leftEdge < 0 || rightEdge > WIDTH);
    }

    public static boolean checkBallCollidesWallsY(Ball ball) {

        double topEdge    = ball.y - ball.radius;
        double bottomEdge = ball.y + ball.radius;

        return (topEdge < 0 || bottomEdge > HEIGHT);
    }



    public static boolean checkBallCollidesRectX(Ball ball, Rectangle rect) {
        double closestX = clamp(ball.x, rect.x, rect.x + rect.width);
        double dx = ball.x - closestX;
        return (dx * dx) < (ball.radius * ball.radius);
    }

    public static boolean checkBallCollidesRectY(Ball ball, Rectangle rect) {
        double closestY = clamp(ball.y, rect.y, rect.y + rect.height);
        double dy = ball.y - closestY;
        return (dy * dy) < (ball.radius * ball.radius);
    }



    private static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

}

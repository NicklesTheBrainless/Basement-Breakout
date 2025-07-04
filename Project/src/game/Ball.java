package game;

import utils.GameObject;

import java.awt.*;

import static base.setting.Settings.STANDARD_BALL_RADIUS;

public class Ball implements GameObject {

    public double x;
    public double y;

    public double vx;
    public double vy;

    public double radius = STANDARD_BALL_RADIUS;

    public Ball(double x, double y, double vx, double vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }



    @Override
    public void update(double delta) {

    }

    @Override
    public void draw(Graphics2D g2) {

    }



}

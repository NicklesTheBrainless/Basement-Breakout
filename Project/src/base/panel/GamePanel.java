package base.panel;

import base.listeners.KeyHandler;
import base.setting.Settings;
import game.Ball;
import game.Block;
import game.Platform;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static base.setting.Settings.*;

public class GamePanel extends BasePanel {

    // input listeners
    public KeyHandler   keyH   = new KeyHandler();

    // game objects
    public Platform platform = new Platform(this);
    public List<Ball> balls = new ArrayList<>();
    public List<Block> blocks = new ArrayList<>();

    public GamePanel() {

        super(FPS);

        this.setPreferredSize(new Dimension(Settings.WIDTH, Settings.HEIGHT));
        this.setBackground(BACKGROUND_COLOR);

        this.setDoubleBuffered(true);
        this.setFocusable(true);

        this.addKeyListener(keyH);
    }



    @Override
    protected void update(double delta) {

        platform.update(delta);

        for (Ball ball : balls)
            ball.update(delta);
        for (Block block : blocks)
            block.update(delta);

    }

    @Override
    protected void draw(Graphics2D g2) {

        platform.draw(g2);

        for (Ball ball : balls)
            ball.draw(g2);
        for (Block block : blocks)
            block.draw(g2);

    }

}
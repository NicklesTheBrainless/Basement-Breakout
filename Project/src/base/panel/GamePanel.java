package base.panel;

import base.listeners.KeyHandler;
import base.setting.GeneralSettings;
import game.Ball;
import game.Block;
import game.Platform;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static base.setting.GameSettings.BLOCK_HEIGHT;
import static base.setting.GameSettings.BLOCK_WIDTH;
import static base.setting.GeneralSettings.*;

public class GamePanel extends BasePanel {

    // input listeners
    public KeyHandler   keyH   = new KeyHandler();

    // game objects
    public Platform platform = new Platform(this);
    public List<Ball> balls = new ArrayList<>();
    public List<Block> blocks = new ArrayList<>();

    public GamePanel() {

        super(FPS);

        this.setPreferredSize(new Dimension(GeneralSettings.GAME_WIDTH, GeneralSettings.GAME_HEIGHT));
        this.setBackground(BACKGROUND_COLOR);

        this.setDoubleBuffered(true);
        this.setFocusable(true);

        this.addKeyListener(keyH);
    }



    @Override
    protected void onStart() {

        for (int iy = 0; iy < 6; iy++) {
            for (int ix = 0; ix < 14; ix++) {

                Block block = new Block(ix * BLOCK_WIDTH + BLOCK_WIDTH, iy * BLOCK_HEIGHT + BLOCK_HEIGHT * 2, iy % 3, 0);
                blocks.add(block);
            }
        }

    }

    @Override
    protected void update(double delta) {

        platform.update(delta);

        for (Ball ball : balls)
            ball.update(delta);
        for (Block block : blocks)
            block.update(delta);

        keyH.update();
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
package base.panel;

import base.listeners.KeyHandler;

import java.awt.*;

import static base.setting.Settings.*;

public class GamePanel extends BasePanel {

    // input listeners
    public KeyHandler   keyH   = new KeyHandler();

    public GamePanel() {

        super(SETTING_FPS);

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(BACKGROUND_COLOR);

        this.setDoubleBuffered(true);
        this.setFocusable(true);

        this.addKeyListener(keyH);
    }



    @Override
    protected void update(double delta) {

    }

    @Override
    protected void draw(Graphics2D g2) {

    }

}
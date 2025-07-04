package base.panel;

import base.listeners.KeyHandler;
import base.setting.Settings;

import java.awt.*;

import static base.setting.Settings.*;

public class GamePanel extends BasePanel {

    // input listeners
    public KeyHandler   keyH   = new KeyHandler();

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

    }

    @Override
    protected void draw(Graphics2D g2) {

    }

}
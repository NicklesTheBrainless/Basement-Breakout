package base.setting;

import java.awt.*;

public abstract class Settings {

    // WINDOW
    public static final String TITLE = "Basement-Breakout";

    // FPS
    public static final int FPS = 50;

    // SCREEN
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final Color BACKGROUND_COLOR = new Color(20, 22, 30);

    // BALL
    public static final Color BALL_COLOR = Color.WHITE;
    public static final double STANDARD_BALL_RADIUS = 12;

    // PLATFORM
    public static final Color PLATFORM_COLOR = Color.LIGHT_GRAY;
    public static final int PLATFORM_SPEED = 6;
    public static final int PLATFORM_X = WIDTH / 2;
    public static final int PLATFORM_Y = 725;
    public static final int PLATFORM_WIDTH  = 50;
    public static final int PLATFORM_HEIGHT = 8;

}

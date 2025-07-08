package base.setting;

import java.awt.*;

public abstract class Settings {

    // WINDOW
    public static final String TITLE = "Basement-Breakout";

    // FPS
    public static final int FPS = 50;

    // SCREEN
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;
    public static final Color BACKGROUND_COLOR = new Color(22, 22, 30);

    // BALL
    public static final Color BALL_COLOR = Color.WHITE;
    public static final double STANDARD_BALL_SPEED = 9;
    public static final double STANDARD_BALL_RADIUS = 10;

    // PLATFORM
    public static final Color PLATFORM_COLOR = Color.LIGHT_GRAY;
    public static final int PLATFORM_SPEED = 14;
    public static final int PLATFORM_WIDTH  = 100;
    public static final int PLATFORM_HEIGHT = 8;
    public static final int PLATFORM_X = (GAME_WIDTH + PLATFORM_WIDTH) / 2;
    public static final int PLATFORM_Y = 560;

    // BOUNCE
    public static final double MAX_BOUNCE_ANGLE = Math.toRadians(60);

    // BLOCK
    public static final int BLOCK_COLOR_COUNT = 3;
    public static final int BLOCK_TYPE_COUNT  = 4;
    public static final int ORIGINAL_BLOCK_WIDTH  = 16;
    public static final int ORIGINAL_BLOCK_HEIGHT = 8;
    public static final int BLOCK_WIDTH  = ORIGINAL_BLOCK_WIDTH  * 4;
    public static final int BLOCK_HEIGHT = ORIGINAL_BLOCK_HEIGHT * 4;

}

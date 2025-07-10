package base.setting;

import java.awt.*;

import static base.setting.GeneralSettings.GAME_WIDTH;

public abstract class GameSettings {

    // BLOCK
    public static final int BLOCK_COLOR_COUNT = 3;
    public static final int BLOCK_TYPE_COUNT  = 4;
    public static final int ORIGINAL_BLOCK_WIDTH  = 16;
    public static final int ORIGINAL_BLOCK_HEIGHT = 8;
    public static final int BLOCK_WIDTH  = (int) (ORIGINAL_BLOCK_WIDTH  * 3.5);
    public static final int BLOCK_HEIGHT = (int) (ORIGINAL_BLOCK_HEIGHT * 3.5);

    // BLOCK COLOR
    public static final int BLUE_ID  = 0;
    public static final int RED_ID   = 1;
    public static final int GREEN_ID = 2;

    // BALL
    public static final Color BALL_COLOR = Color.WHITE;
    public static final double STANDARD_BALL_SPEED = 7;
    public static final double STANDARD_BALL_RADIUS = 10;

    // PLATFORM
    public static final Color PLATFORM_COLOR = Color.WHITE;
    public static final int PLATFORM_SPEED = 11;
    public static final int PLATFORM_WIDTH  = 120;
    public static final int PLATFORM_HEIGHT = 8;
    public static final int PLATFORM_X = (GAME_WIDTH + PLATFORM_WIDTH) / 2;
    public static final int PLATFORM_Y = 640;

    // BOUNCE
    public static final double MAX_BOUNCE_ANGLE = Math.toRadians(60);
}

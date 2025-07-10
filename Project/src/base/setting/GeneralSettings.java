package base.setting;

import java.awt.*;

import static base.setting.GameSettings.BLOCK_HEIGHT;
import static base.setting.GameSettings.BLOCK_WIDTH;

public abstract class GeneralSettings {

    // WINDOW
    public static final String TITLE = "Basement-Breakout";

    // FPS
    public static final int FPS = 60;

    // SCREEN
    public static final int GAME_WIDTH_IN_BLOCKS = 16;
    public static final int GAME_HEIGHT_IN_BLOCKS = 24;
    public static final int GAME_WIDTH = BLOCK_WIDTH * GAME_WIDTH_IN_BLOCKS;
    public static final int GAME_HEIGHT = BLOCK_HEIGHT * GAME_HEIGHT_IN_BLOCKS;
    public static final Color BACKGROUND_COLOR = new Color(22, 22, 30);


}

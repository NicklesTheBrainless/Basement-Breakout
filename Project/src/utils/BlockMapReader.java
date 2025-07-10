package utils;

import game.Block;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static base.setting.GameSettings.*;
import static base.setting.GeneralSettings.GAME_HEIGHT_IN_BLOCKS;
import static base.setting.GeneralSettings.GAME_WIDTH_IN_BLOCKS;

public abstract class BlockMapReader {

    public static List<Block> read(String filePath) {

        List<Block> blocks = new ArrayList<>();

        try {
            BufferedImage mapImage = ImageIO.read(Objects.requireNonNull(BlockMapReader.class.getResourceAsStream(filePath)));

            for (int y = 0; y < GAME_HEIGHT_IN_BLOCKS; y++) {
                for (int x = 0; x < GAME_WIDTH_IN_BLOCKS; x++) {

                    int rgb = mapImage.getRGB(x, y);
                    int colorId = getColorId(rgb);

                    blocks.add(new Block(x * BLOCK_WIDTH, y * BLOCK_HEIGHT, colorId, 0));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return blocks;
    }

    private static int getColorId(int rgb) {

        Color color = new Color(rgb);

        int red   = color.getRed();
        int green = color.getGreen();
        int blue  = color.getBlue();

        if (red >= green   &&   red >= blue)
            return RED_ID;
        if (green >= red   &&   green >= blue)
            return GREEN_ID;

        return BLUE_ID;
    }

}

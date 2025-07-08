package base.resource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static base.setting.Settings.*;

public abstract class Resources {

    private static final BufferedImage BLOCK_TEXTURE_SET = readImage("/block_set.png");
    public static final BufferedImage[][] BLOCK_TEXTURE_TABLE = // [first index = block color] [second index = block type]
            splitSet(BLOCK_TEXTURE_SET, BLOCK_COLOR_COUNT, BLOCK_TYPE_COUNT, ORIGINAL_BLOCK_WIDTH, ORIGINAL_BLOCK_HEIGHT);



    private static BufferedImage readImage(String filePath) {
        try {
            return ImageIO.read(Objects.requireNonNull(Resources.class.getResourceAsStream(filePath)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static BufferedImage[][] splitSet(BufferedImage textureSet, int setWidth, int setHeight, int partWidth, int partHeight) {

        BufferedImage[][] textureTable = new BufferedImage[setWidth][setHeight];

        for (int iy = 0; iy < setHeight; iy++) {
            for (int ix = 0; ix < setWidth; ix++) {
                textureTable[ix][iy] = textureSet.getSubimage(ix * partWidth, iy * partHeight, partWidth, partHeight);
            }
        }

        return textureTable;
    }
}

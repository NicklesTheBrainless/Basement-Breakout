package game;

import utils.GameObject;

import java.awt.*;

import static base.resource.Resources.BLOCK_TEXTURE_TABLE;
import static base.setting.GameSettings.BLOCK_HEIGHT;
import static base.setting.GameSettings.BLOCK_WIDTH;
import static base.setting.GeneralSettings.*;

public class Block extends Rectangle implements GameObject {

    int colorId;
    int typeId;

    public Block(int x, int y, int colorId, int typeId) {
        this.x = x;
        this.y = y;
        this.colorId = colorId;
        this.typeId = typeId;
        this.width  = BLOCK_WIDTH;
        this.height = BLOCK_HEIGHT;
    }



    @Override
    public void update(double delta) {

    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(BLOCK_TEXTURE_TABLE[colorId][typeId], x, y, width, height, null);
    }
}

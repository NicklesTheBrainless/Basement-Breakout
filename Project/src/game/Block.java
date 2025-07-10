package game;

import utils.interfaces.DrawObject;

import java.awt.*;

import static base.resource.Resources.BLOCK_TEXTURE_TABLE;
import static base.setting.GameSettings.BLOCK_HEIGHT;
import static base.setting.GameSettings.BLOCK_WIDTH;

public class Block extends Rectangle implements DrawObject {

    int colorId;
    int typeId;

    public boolean broken = false;
    public int disappearStep = 10;

    public Block(int x, int y, int colorId, int typeId) {
        this.x = x;
        this.y = y;
        this.colorId = colorId;
        this.typeId = typeId;
        this.width  = BLOCK_WIDTH;
        this.height = BLOCK_HEIGHT;
    }



    @Override
    public void draw(Graphics2D g2) {
        float opacity = (float) disappearStep / 10;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        g2.drawImage(BLOCK_TEXTURE_TABLE[colorId][typeId], x, y, width, height, null);
    }

}

package game.manage;

import base.panel.GamePanel;
import game.Block;
import utils.interfaces.UpdateObject;

public class BlockManager implements UpdateObject {

    GamePanel gp;

    public BlockManager(GamePanel gp) {
        this.gp = gp;
    }



    @Override
    public void update(double delta) {

        for (int i = 0; i < gp.blocks.size(); i++) {

            Block block = gp.blocks.get(i);
            if (block.broken) {
                block.disappearStep--;
                if (block.disappearStep <= 0) {
                    gp.blocks.remove(i);
                    i--;
                }
            }
        }
    }

}

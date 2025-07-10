package utils.interfaces;

import java.awt.*;

public interface GameObject extends DrawObject, UpdateObject {

    void update(double delta);
    void draw(Graphics2D g2);
}

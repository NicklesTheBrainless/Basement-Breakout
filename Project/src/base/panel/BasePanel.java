package base.panel;

import javax.swing.*;
import java.awt.*;

public abstract class BasePanel extends JPanel implements Runnable {

    // FPS
    protected final int maxFPS;

    // Constants
    private final static int NANOSECONDS_PER_SECOND = 1_000_000_000;

    Thread gameThread;

    protected BasePanel(int maxFps) {
        maxFPS = maxFps;
    }

    public void startProgramThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }



    protected abstract void update(double delta);

    protected abstract void draw(Graphics2D g2);



    @Override
    public void run() {

        double frameInterval = (double) NANOSECONDS_PER_SECOND / maxFPS;
        double delta = 0;

        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / frameInterval;
            lastTime = currentTime;

            if (delta >= 1) {

                update(delta);
                repaint();

                delta--;
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        // draws everything
        this.draw(g2);

        g2.dispose();
    }

}

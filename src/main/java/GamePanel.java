import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class GamePanel extends JPanel implements Runnable {

    // Screen Config

    // 16x16 tile
    final int orignalTileSize = 16;
    final int scale = 3;

    final int tileSize = orignalTileSize * scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    Thread gameThread;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // Game loop
        while(gameThread != null) {

            //System.out.println("Game thread started");

            // 1 Update info such as character positions
            update();
            // 2 Draw the screen with updated info
            repaint();
        }

    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.white);
        g2d.fillRect(100, 100, tileSize, tileSize);
        g2d.dispose();
    }
    public void update() {
    }

}

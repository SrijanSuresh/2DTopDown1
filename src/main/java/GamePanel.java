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

        }

    }

}

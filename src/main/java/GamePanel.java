import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class GamePanel extends JPanel implements Runnable {
    private static final int FPS = 60;

    // Screen Config

    // 16x16 tile
    final int orignalTileSize = 16;
    final int scale = 3;

    final int tileSize = orignalTileSize * scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;

    // Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 100;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true); // game panel can be focused to receive key input
    }

    public void startGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // Game loop
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;

        while(gameThread != null) {

             currentTime = System.nanoTime();

             delta += (currentTime - lastTime)/drawInterval;
             timer += (currentTime - lastTime);
             lastTime = currentTime;

             if(delta >= 1) {
                 // 1 Update info such as character positions
                 update();
                 // 2 Draw the screen with updated info
                 repaint();
                 // reset delta for next run
                 delta--;
                 drawCount++;
             }
            if(timer >= 1000000000) {
                System.out.println("FPS:"+ drawCount);
                drawCount = 0;
                timer = 0;
            }
        }

    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.white);
        g2d.fillRect(playerX, playerY, tileSize, tileSize);
        g2d.dispose();
    }
    public void update() {

        if(keyHandler.upPressed == true){
            playerY -= playerSpeed;
        }
        else if(keyHandler.downPressed == true){
            playerY += playerSpeed;
        }
        else if(keyHandler.leftPressed == true){
            playerX -= playerSpeed;
        }
        else if(keyHandler.rightPressed == true){
            playerX += playerSpeed;
        }

    }

}

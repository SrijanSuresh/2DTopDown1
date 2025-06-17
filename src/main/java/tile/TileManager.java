package tile;

import game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;

public class TileManager {

    GamePanel gamePanel;
    Tile[] tile;

    public TileManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        tile = new Tile[10];
        getTileImage();
    }

    public void getTileImage(){
        try{
            // Grass
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResource("/tiles/Tiles1/FieldsTile_38.png"));

            // Wall
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResource("/tiles/Tiles1/FieldsTile_01.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(tile[0].image, 0, 0, gamePanel.tileSize,  gamePanel.tileSize, null);
        g2d.drawImage(tile[1].image, 48, 0, gamePanel.tileSize,  gamePanel.tileSize, null);
    }

}

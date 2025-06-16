package entity;

import game.GamePanel;
import game.KeyHandler;

import java.awt.*;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler kh;

    public Player(GamePanel gp, KeyHandler kh) {
        this.gp = gp;
        this.kh = kh;

        setDefaultValues();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update(){
        if(kh.upPressed == true){
            y -= speed;
        }
        else if(kh.downPressed == true){
            y += speed;
        }
        else if(kh.leftPressed == true){
            x -= speed;
        }
        else if(kh.rightPressed == true){
            x += speed;
        }

    }
    public void draw(Graphics2D g2d){
        g2d.setColor(Color.white);
        g2d.fillRect(x, y, gp.tileSize, gp.tileSize);

    }
}

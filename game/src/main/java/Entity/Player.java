package Entity;

import java.awt.Color;
import java.awt.Graphics2D;

import javagame.GamePanel;
import javagame.MovementHandler;

public class Player extends Entity {
    
    GamePanel gamePanel;
    MovementHandler movementH;

    public Player(GamePanel gp, MovementHandler movementH){
        this.gamePanel = gp;
        this.movementH = movementH;
        setDefualtValues();
    }

    public void setDefualtValues(){
        x = 100;
        y = 100;
        speed = 5;
    }

    public void update(){
        if(movementH.upPress == true){
            y -= speed;
        }
        if(movementH.downPress == true){
            y += speed;
        }
        if(movementH.leftPress == true){
            x -= speed;
        
            
        }
        if(movementH.rightPress == true){
            x += speed;
            
         }
    }

    public void paintComponent(Graphics2D g) {
        
        
        g.setColor(Color.BLUE);
        g.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
        
    }
}

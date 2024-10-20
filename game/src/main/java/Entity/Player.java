package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javagame.GamePanel;
import javagame.MovementHandler;

public class Player extends Entity {
    
    GamePanel gamePanel;
    MovementHandler movementH;

    public Player(GamePanel gp, MovementHandler movementH){
        this.gamePanel = gp;
        this.movementH = movementH;
        setDefualtValues();
        getPolayerChar();
    }

    public void setDefualtValues(){
        x = 100;
        y = 100;
        speed = 5;
        spriteCounter = 0;
        spriteNum = 1;
        direction = "down";
    }

    public void getPolayerChar(){
        try{
            up1 = ImageIO.read(GamePanel.class.getResource("/resources/player/up_1.png"));         
            up2 = ImageIO.read(getClass().getResourceAsStream("/resources/player/up_2.png"));         
            down1 = ImageIO.read(GamePanel.class.getResource("/resources/player/down_1.png"));         
            down2 = ImageIO.read(getClass().getResourceAsStream("/resources/player/down_2.png"));         
            right1 = ImageIO.read(getClass().getResourceAsStream("/resources/player/right_1.png"));         
            right2 = ImageIO.read(getClass().getResourceAsStream("/resources/player/right_2.png"));         
            left1 = ImageIO.read(getClass().getResourceAsStream("/resources/player/left_1.png"));         
            left2 = ImageIO.read(getClass().getResourceAsStream("/resources/player/left_2.png"));         

        } catch(Exception e) {

        }
    }

    public void update(){
        if(movementH.upPress == true || movementH.downPress == true || 
        movementH.rightPress == true || movementH.leftPress == true){
            if(movementH.upPress == true){
                y -= speed;
                direction = "up";
    
            }
            if(movementH.downPress == true){
                y += speed;
                direction = "down";
    
            }
            if(movementH.leftPress == true){
                x -= speed;
                direction = "left";
            
                
            }
            if(movementH.rightPress == true){
                x += speed;
                direction = "right";
                
             }
    
    
             spriteCounter++;
             if(spriteCounter > 13){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
    
                spriteCounter = 0;
             }
        }
       
    }

    public void paintComponent(Graphics2D g) {
        
        BufferedImage image = null;
        // g.setColor(Color.BLUE);
        // g.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
        
        switch (direction) {
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if (spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
        }
  
        g.drawImage(image,x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }


    
}

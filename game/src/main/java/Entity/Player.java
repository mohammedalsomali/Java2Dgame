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
        direction = "down";
    }

    public void getPolayerChar(){
        try{
            up1 = ImageIO.read(GamePanel.class.getResource("/resources/up_1.png"));         
            up2 = ImageIO.read(getClass().getResourceAsStream("/resources/up_2.png"));         
            down1 = ImageIO.read(GamePanel.class.getResource("/resources/down_1.png"));         
            down2 = ImageIO.read(getClass().getResourceAsStream("/resources/down_2.png"));         
            right1 = ImageIO.read(getClass().getResourceAsStream("/resources/right_1.png"));         
            right2 = ImageIO.read(getClass().getResourceAsStream("/resources/right_2.png"));         
            left1 = ImageIO.read(getClass().getResourceAsStream("/resources/left_1.png"));         
            left2 = ImageIO.read(getClass().getResourceAsStream("/resources/left_2.png"));         

        } catch(Exception e) {

        }
    }

    public void update(){
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
    }

    public void paintComponent(Graphics2D g) {
        
        BufferedImage image = null;
        // g.setColor(Color.BLUE);
        // g.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
        
        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "right":
                image = right1;
                break;
            case "left":
                image = left1;
                break;
        }
  
        g.drawImage(image,x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }


    
}

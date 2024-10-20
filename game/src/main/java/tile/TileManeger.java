package tile;
import javagame.GamePanel;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;

public class TileManeger {
    GamePanel gamePanel;
    tile[] tile;

    public TileManeger(GamePanel gp){
        this.gamePanel = gp;
        tile = new tile[10];
        getTileImage();
    }

    public void getTileImage(){
        try {
            tile[0] = new tile();
            tile[1] = new tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/resources/enviroment/grass.png"));
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/resources/enviroment/water.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void drawImage(Graphics2D g){
        g.drawImage(tile[0].image, 0, 0, gamePanel.tileSize, gamePanel.tileSize, null);
        g.drawImage(tile[1].image, 200, 200, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}

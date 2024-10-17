package javagame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    
    //screen settings
    final int originalTileSize = 16;
    final int scale = 3;

    final int titleSize = originalTileSize*scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = titleSize * maxScreenCol;
    final int screenHeight = titleSize * maxScreenRow;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.YELLOW);
        this.setDoubleBuffered(true);
    }

    @Override
    public void run() {
        //the game loop
        
    }
}

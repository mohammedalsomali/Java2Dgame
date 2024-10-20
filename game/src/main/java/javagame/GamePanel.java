package javagame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Entity.Player;
import tile.TileManeger;
import tile.tile;



public class GamePanel extends JPanel implements Runnable {
    
    //screen settings
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize*scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    Thread gameThread;
    MovementHandler movementH = new MovementHandler();
    TileManeger TM = new TileManeger(this);

    Player player = new Player(this, movementH);

    //set defualt p1 position and movement
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 5;

    //set FBS
    int FBS = 60;
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(movementH);
        this.setFocusable(true);
    }


    public void gameStartThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        //the game loop
        double timeInterval = 1000000000/FBS; //nano second devided by the frames per second
        double nextUpdate = System.nanoTime() + timeInterval; //nano second devided by the frames per second
        while (gameThread != null) {

            // System.out.println("loop is running");
            long currentTime = System.nanoTime();


            //updating the game information
            update();

            //paint the updated information
            repaint();


            try {
                double remainingTime = nextUpdate - currentTime;
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime/1000000);

                nextUpdate +=  timeInterval;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }

    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        TM.drawImage(g2);

        player.paintComponent(g2);
        g2.dispose();
    }
}

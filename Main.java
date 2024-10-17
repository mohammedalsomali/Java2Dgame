package Java2Dgame;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        // creating the screen
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D game");

        GmaePanel gamePanel = new GmaePanel();
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}

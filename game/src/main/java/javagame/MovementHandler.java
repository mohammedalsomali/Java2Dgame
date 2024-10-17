package javagame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementHandler implements KeyListener {
    public boolean upPress, downPress, leftPress, rightPress;
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_W){
            upPress = true;
        }
        if(keyCode == KeyEvent.VK_A){
            leftPress = true;
            
        }
        if(keyCode == KeyEvent.VK_D){
            rightPress = true;
            
        }
        if(keyCode == KeyEvent.VK_S){
            downPress = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_W){
            upPress = false;
        }
        if(keyCode == KeyEvent.VK_A){
            leftPress = false;
            
        }
        if(keyCode == KeyEvent.VK_D){
            rightPress = false;
            
        }
        if(keyCode == KeyEvent.VK_S){
            downPress = false;
        }
    }
    
}

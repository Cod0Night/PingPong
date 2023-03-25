
import java.awt.*;
import java.awt.event.*;
import java.security.Key;
import java.util.*;
import javax.swing.*;
public class PongPaddle extends Rectangle{
    int id;
    int yLocation;
    int speed = 10;

    PongPaddle(int xLocation,int yLocation,int width,int height,int id){
        super(xLocation,yLocation,width,height);
        this.id = id;
    }

    //move the paddle up or down

    public void draw(Graphics g){
       if(id==1)
           g.setColor(Color.BLUE);
       else
           g.setColor(Color.red);
       g.fillRect(x,y,width,height);

    }
    public void keyPressed(KeyEvent e){
        switch (id){
            case 1: if(e.getKeyCode()==KeyEvent.VK_W)
                       setYDirection(-speed);
                    if(e.getKeyCode()==KeyEvent.VK_S)
                        setYDirection(speed);
                    break;

            case 2: if(e.getKeyCode()==KeyEvent.VK_UP)
                       setYDirection(-speed);
                    if(e.getKeyCode()==KeyEvent.VK_DOWN)
                        setYDirection(speed);
                    break;
        }
    }
    public void KeyReleased(KeyEvent e){
        switch (id){
            case 1: if(e.getKeyCode()==KeyEvent.VK_W)
                      setYDirection(0);
                    if(e.getKeyCode()==KeyEvent.VK_S)
                        setYDirection(0);
                    break;

            case 2: if(e.getKeyCode()==KeyEvent.VK_UP)
                       setYDirection(0);
                    if(e.getKeyCode()==KeyEvent.VK_DOWN)
                       setYDirection(0);
                    break;
        }
    }

    private void setYDirection(int speed) {
        yLocation = speed;
    }
    public void move(){
        y+=yLocation;
    }

}

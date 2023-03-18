
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class PongPaddle extends Rectangle{
    int id;

    PongPaddle(int xLocation,int yLocation,int width,int height,int id){
        super(xLocation,yLocation,width,height);
        this.id = id;
    }
    public void draw(Graphics g){
       if(id==1)
           g.setColor(Color.BLUE);
       else
           g.setColor(Color.red);

    }
}

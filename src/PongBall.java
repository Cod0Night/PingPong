
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class PongBall extends Rectangle{

    int ballSpeed = 2;
    int diameter;
    int xVelocity;
    int yVelocity;
    Random random;
    PongBall(int x,int y,int ballDiameter){
        super(x,y,ballDiameter,ballDiameter);
        this.diameter=ballDiameter;

        random = new Random();
        int randomXDirection = random.nextInt(2);
        if(randomXDirection == 0)
            randomXDirection--;
        setXDirection(randomXDirection*ballSpeed);

        int randomYDirection = random.nextInt(2);
        if(randomYDirection == 0)
            randomYDirection--;
        setYDirection(randomYDirection*ballSpeed);

    }

    public void setXDirection(int randomXDirection) {
        xVelocity = randomXDirection;
    }
    public void setYDirection(int randomYDirection) {
        yVelocity = randomYDirection;
    }
    public void move() {
        x += xVelocity;
        y += yVelocity;
    }


    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x,y,diameter,diameter);
    }


}

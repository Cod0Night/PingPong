
import java.awt.*;
import java.util.*;

public class PongBall extends Rectangle{

    int ballSpeed = 2;
    int diameter;
    double xVelocity;
    double yVelocity;
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

    public void setXDirection(double randomXDirection) {
        xVelocity = randomXDirection;
    }
    public void setYDirection(double randomYDirection) {
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

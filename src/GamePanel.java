
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

    static final int game_Width = 1000;
    static final int game_Height = (int)(game_Width*(0.555));
    static final Dimension gameDimension = new Dimension(game_Width,game_Height);
    static final int paddleWidth = 20;
    static final int paddleHeight = 200;
    Thread gameThread;
    PongPaddle Player1;
    PongPaddle Player2;
    PongBall pongBall;


    GamePanel(){

        //newPingPongPadles();
        this.setPreferredSize(gameDimension);
        this.setBackground(Color.black);
        this.setFocusable(true);

        gameThread = new Thread(this);
        gameThread.start();


    }

 /*   private void newPingPongPadles() {
        Player1 = new PongPaddle(0,(game_Height/2) - (paddleHeight/2),paddleWidth,paddleHeight,1);
    }

    public void

    public void move(){

    }
    private void checkCollision(){

    }

    public void repaint(){

    }
    */

    @Override
    public void run() {
        long lastUpdate = System.currentTimeMillis();
        double fps = 1000/60;
        double delta = 0;

        while (true){
            Long currentTime = System.currentTimeMillis();
            delta += (currentTime - lastUpdate) / fps;
            lastUpdate = currentTime;
            if (delta>=1){
               // move();
                //checkCollision();
                //repaint();
                //delta--;
                System.out.println("refresh");
            }
        }
    }


}

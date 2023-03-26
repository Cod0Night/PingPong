
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

    static final int game_Width = 1000;
    static final int game_Height = (int)(game_Width*(0.555));
    static final Dimension gameDimension = new Dimension(game_Width,game_Height);
    static final int paddleWidth = 20;
    static final int paddleHeight = 100;
    static final int ballDiameter = 20;
    Thread gameThread;
    PongPaddle PlayerBlue;
    PongPaddle PlayerRed;
    PongBall pongBall;
    Graphics graphic;
    Image image;
    GameScore scoreCard;
    Boolean pause;


    GamePanel(){

        newPingPongPadles();
        newPingPongBall();
        newScoreCard();
        this.pause=false;
        this.setPreferredSize(gameDimension);
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new AllListeners());

        gameThread = new Thread(this);
        gameThread.start();



    }

    public void reset_Paused() {
       //System.out.println("need a reset");
       // gameThread.
        pause=true;
       // newPingPongBall();
       // newPingPongPadles();
        //newScoreCard();
    }
    private void newScoreCard() {
        scoreCard = new GameScore(game_Width,game_Height);
    }

    private void newPingPongBall() {
        pongBall = new PongBall(game_Width/2,game_Height/2,ballDiameter);
    }

    private void newPingPongPadles() {
        PlayerBlue = new PongPaddle(0,(game_Height/2) - (paddleHeight/2),paddleWidth,paddleHeight,1);
        PlayerRed = new PongPaddle(game_Width-paddleWidth,(game_Height/2) - (paddleHeight/2),paddleWidth,paddleHeight,2);
    }

    public void paint(Graphics g){
        image = createImage(game_Width,getHeight());
        graphic = image.getGraphics();
        draw(graphic);
        g.drawImage(image,0,0,this);
    }

    public void draw(Graphics g){
         PlayerBlue.draw(g);
         PlayerRed.draw(g);
         pongBall.draw(g);
         scoreCard.draw(g);
         if(scoreCard.drawWinner(g, gameThread)){
             reset_Paused();
         }

    }
    public void move(){
         PlayerBlue.move();
         PlayerRed.move();
         pongBall.move();
    }
    private void checkCollision(){
        //ChecKing Paddle colliding with edges
        if(PlayerBlue.y<0){
            PlayerBlue.y = 0;
        }else if(PlayerBlue.y> game_Height-paddleHeight){
            PlayerBlue.y = game_Height-paddleHeight;
        }
        if (PlayerRed.y<0) {
            PlayerRed.y = 0;
        }else if(PlayerRed.y>game_Height-paddleHeight){
            PlayerRed.y = game_Height-paddleHeight;
        }

        //Ball colliding with upper & Lower edges
        if(pongBall.y<0){
            pongBall.setYDirection(-pongBall.yVelocity);
        } else if (pongBall.y>game_Height-ballDiameter) {
            pongBall.setYDirection(-pongBall.yVelocity);
        }

        //When Ball collides with paddles
        if (pongBall.intersects(PlayerBlue)) {
            pongBall.setXDirection(-pongBall.xVelocity*1.25);
        } else if (pongBall.intersects(PlayerRed)) {
            pongBall.setXDirection(-pongBall.xVelocity*1.25);
        }

        //Ball collides with side edges and tally score.
        if(pongBall.x<0){
            scoreCard.player1Score++;
            newPingPongBall();
        } else if (pongBall.x>(game_Width+ballDiameter)) {
            scoreCard.player2Score++;
            newPingPongBall();
        }
        
        //Winnner
        if(scoreCard.player1Score==10){
                scoreCard.winnerName ="Player Red Won";
                scoreCard.winner = true;
        } else if (scoreCard.player2Score==10) {
                scoreCard.winnerName = "Player Blue Won";
                scoreCard.winner = true;
        }
    }

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
                if(!pause) {
                    move();
                    checkCollision();
                    repaint();
                }
                delta--;
                //System.out.println("refresh");
            }
        }
    }
    public class AllListeners extends KeyAdapter{
          public void keyPressed(KeyEvent e){
               PlayerBlue.keyPressed(e);
               PlayerRed.keyPressed(e);

          }
          public void keyReleased(KeyEvent e){
              PlayerBlue.KeyReleased(e);
              PlayerRed.KeyReleased(e);
          }
    }

}

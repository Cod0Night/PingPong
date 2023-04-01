
import java.awt.*;

public class GameScore extends Rectangle {

    int player1Score;
    int player2Score;
    int width;
    int height;
    Font font;
    Font secondFont;
    boolean winner;
    String winnerName;

    GameScore(int x, int y) {
        this.width = x;
        this.height = y;
        this.player1Score = 0;
        this.player2Score = 0;
        this.winner = false;
        font = new Font("Consolas", Font.BOLD, 50);
        secondFont = new Font("Consolas", Font.BOLD, 20);
    }

    public void draw(Graphics g) {

        g.setFont(font);
        g.drawString(Integer.toString(player1Score), (width / 2) - 80, 40);
        g.drawString(Integer.toString(player2Score), (width / 2) + 50, 40);
    }

    public boolean drawWinner(Graphics g) {
        g.setColor(Color.white);
        if (winner) {
            g.drawString(winnerName, (width / 2) - 250, (height / 2) - 40);
            g.setFont(secondFont);
            g.drawString("Press Enter to Start",(width/2)-250,(height/2)+40);
            return  true;
        }
        g.drawLine(width / 2, 0, width / 2, height);
        return false;
    }
}
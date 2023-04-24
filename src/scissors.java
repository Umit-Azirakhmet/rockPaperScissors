import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class scissors {
    int x;
    int y;
    int w, h;
    boolean moveStart;
    int leftEdge, rightEdge, topEdge, bottomEdge;
    int speed;
    double scale;
    ImageIcon rockImageIcon;
    Image rockImage;

    public scissors(int argX, int argY, int argLeftEdge, int argRightEdge, int argTopEdge, int argBottomEdge) {
        x = argX;
        y = argY;
        scale = 0.5;
        w = (int) (120*scale);
        h = (int) (140*scale);
        moveStart = false;

        leftEdge = argLeftEdge;
        rightEdge = argRightEdge;
        topEdge = argTopEdge;
        bottomEdge = argBottomEdge;
        speed = 3;

        rockImageIcon = new ImageIcon(scissors.class.getResource("scissors.png"));
        rockImage = rockImageIcon.getImage();


    }

    public void drawSelf(Graphics g) {
        g.drawImage(rockImage, x, y, w, h, null);
    }

    public void move() {
        if(moveStart) {
            Random random = new Random();
            if(x >= rightEdge || x <= leftEdge || y <= topEdge || y >= bottomEdge) {
                if (x >= rightEdge) {
                    x-=speed;
                }
                if(x <= leftEdge) {
                    x+=speed;
                }
                if(y <= topEdge) {
                    y+=speed;
                }
                if(y >= bottomEdge) {
                    y-=speed;
                }
            } else {
                x = x + random.nextInt(2*speed + 1) - speed;
                y = y + random.nextInt(2*speed + 1) - speed;
            }

        }

    }
    public void arrowKeyPressed(String direction, boolean pressed) {
        if(direction.equals("START")) moveStart = pressed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
}


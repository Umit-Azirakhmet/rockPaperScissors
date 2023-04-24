import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class paper {
    int x, y;
    int w, h;
    boolean moveRight, moveLeft, moveUp, moveDown, moveStart;
    int leftEdge, rightEdge, topEdge, bottomEdge;
    int speed;
    double scale;
    ImageIcon rockImageIcon;
    Image rockImage;

    public paper(int argX, int argY, int argLeftEdge, int argRightEdge, int argTopEdge, int argBottomEdge) {
        x = argX;
        y = argY;
        scale = 0.5;
        w = (int) (120*scale);
        h = (int) (140*scale);
        moveStart = false;
        moveRight = false;
        moveLeft = false;
        moveDown = false;
        moveUp = false;
        leftEdge = argLeftEdge;
        rightEdge = argRightEdge;
        topEdge = argTopEdge;
        bottomEdge = argBottomEdge;
        speed = 3;

        rockImageIcon = new ImageIcon(paper.class.getResource("paper.jpg"));
        rockImage = rockImageIcon.getImage();


    }

    public void drawSelf(Graphics g) {
        g.drawImage(rockImage, x, y, w, h, null);
    }
    public void move() {

        if(moveRight) {
            if(x+speed+w <= rightEdge) x+=speed;
        }
        if(moveLeft) {
            if (x-speed >= leftEdge) x -= speed;
        }
        if(moveUp) {
            if(y-speed >= topEdge) y-=speed;
        }
        if(moveDown) {
            if(y+speed+h <= bottomEdge) y += speed;
        }
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
        if(direction.equals("START")) {
            moveStart = pressed;
        }
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


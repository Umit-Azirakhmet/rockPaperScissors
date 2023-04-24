import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;


public class Main extends JComponent implements KeyListener, MouseListener {
    //dimensions of the frame
    private static final String BACKGROUND_IMAGE_PATH = "background.jpg";
    private Image backgroundImage;
    private static Clip clip;
    private static File soundFile;
    private String message = "It's my first time using JComponent for a program and with my final exams, ";
    private String message2 = "I was not able to fully immerse myself in this project. But I still tried my best!";
    private String message3 = "I hope you won't judge too harshly)";
    private int WIDTH;
    private int HEIGHT;
    private rock rock1;
    private rock rock2;
    private rock rock3;

    private paper paper1;
    private paper paper2;
    private paper paper3;

    private scissors scissors1;
    private scissors scissors2;
    private scissors scissors3;
    public Main() {
        WIDTH = 1000;
        HEIGHT = 500;
        loadBackgroundImage();


        JFrame gui = new JFrame();  //box
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //can be closed
        gui.setTitle("Rock-Paper-Scissors");  //title
        gui.setPreferredSize(new Dimension(WIDTH+5, HEIGHT+30));
        gui.setResizable(false);
        gui.getContentPane().add(this); //for drawing

        gui.pack(); //packs everything together
        gui.setLocationRelativeTo(null); //aligns box at the center
        gui.setVisible(true);
        gui.addKeyListener(this);
        gui.addMouseListener(this);

        try {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource("sound.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        rock1 = new rock(200, 100, 0, WIDTH, 0, HEIGHT);
        rock2 = new rock(400, 150, 0, WIDTH, 0, HEIGHT);
        rock3 = new rock(700, 10, 0, WIDTH, 0, HEIGHT);

        paper1 = new paper(50, 200, 0, WIDTH, 0, HEIGHT);
        paper2 = new paper(400, 400, 0, WIDTH, 0, HEIGHT);
        paper3 = new paper(900, 200, 0, WIDTH, 0, HEIGHT);

        scissors1 = new scissors(10, 10, 0, WIDTH, 0, HEIGHT);
        scissors2 = new scissors(300, 250, 0, WIDTH, 0, HEIGHT);
        scissors3 = new scissors(650, 300, 0, WIDTH, 0, HEIGHT);
    }
    private void loadBackgroundImage() {
        try {
            backgroundImage = ImageIO.read(getClass().getResource(BACKGROUND_IMAGE_PATH));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //for drawings
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        g.drawString(message, 5, HEIGHT - 40);
        g.drawString(message2, 5, HEIGHT - 25);
        g.drawString(message3, 5, HEIGHT - 10);
        if (rock1 != null) rock1.drawSelf(g);
        if (rock2 != null) rock2.drawSelf(g);
        if (rock3 != null) rock3.drawSelf(g);

        if (paper1 != null) paper1.drawSelf(g);
        if (paper2 != null) paper2.drawSelf(g);
        if (paper3 != null) paper3.drawSelf(g);

        if (scissors1 != null) scissors1.drawSelf(g);
        if (scissors2 != null) scissors2.drawSelf(g);
        if (scissors3 != null) scissors3.drawSelf(g);

        if (paper1.getX() <= scissors1.getX() && (paper1.getX() + paper1.getW()) >= scissors1.getX()) {

            paper1.rockImageIcon = new ImageIcon(paper.class.getResource("scissors.png"));
            paper1.rockImage = paper1.rockImageIcon.getImage();
        }
        if (paper2.getX() <= scissors2.getX() && (paper2.getX() + paper2.getW()) >= scissors2.getX()) {

            paper2.rockImageIcon = new ImageIcon(paper.class.getResource("scissors.png"));
            paper2.rockImage = paper1.rockImageIcon.getImage();
        }
        if (paper3.getX() <= scissors3.getX() && (paper3.getX() + paper3.getW()) >= scissors3.getX()) {

            paper3.rockImageIcon = new ImageIcon(paper.class.getResource("scissors.png"));
            paper3.rockImage = paper1.rockImageIcon.getImage();
        }

        if (rock1.getX() <= paper1.getX() && (rock1.getX() + rock1.getW()) >= paper1.getX()) {

            rock1.rockImageIcon = new ImageIcon(rock.class.getResource("paper.jpg"));
            rock1.rockImage = rock1.rockImageIcon.getImage();
        }
        if (rock2.getX() <= paper2.getX() && (rock2.getX() + rock2.getW()) >= paper2.getX()) {

            rock2.rockImageIcon = new ImageIcon(rock.class.getResource("paper.jpg"));
            rock2.rockImage = rock1.rockImageIcon.getImage();
        }
        if (rock3.getX() <= paper3.getX() && (rock3.getX() + rock3.getW()) >= paper3.getX()) {

            rock3.rockImageIcon = new ImageIcon(rock.class.getResource("paper.jpg"));
            rock3.rockImage = rock1.rockImageIcon.getImage();
        }

        if (scissors1.getX() <= rock1.getX() && (scissors1.getX() + scissors1.getW()) >= rock1.getX()) {

            scissors1.rockImageIcon = new ImageIcon(scissors.class.getResource("asyk.jpg"));
            scissors1.rockImage = scissors1.rockImageIcon.getImage();
        }
        if (scissors2.getX() <= rock2.getX() && (scissors2.getX() + scissors2.getW()) >= rock2.getX()) {

            scissors2.rockImageIcon = new ImageIcon(scissors.class.getResource("asyk.jpg"));
            scissors2.rockImage = scissors1.rockImageIcon.getImage();
        }
        if (scissors3.getX() <= rock3.getX() && (scissors3.getX() + scissors3.getW()) >= rock3.getX()) {

            scissors3.rockImageIcon = new ImageIcon(scissors.class.getResource("asyk.jpg"));
            scissors3.rockImage = scissors1.rockImageIcon.getImage();
        }
    }

    public void loop() {
        rock1.move();
        rock2.move();
        rock3.move();
        paper1.move();
        paper2.move();
        paper3.move();
        scissors1.move();
        scissors2.move();
        scissors3.move();
        //redraws entire frame(if you draw)
        repaint();
    }
    public void keyPressed(KeyEvent e) {

    }
    public void keyTyped(KeyEvent e) {

    }
    public void keyReleased(KeyEvent e) {

    }
    public void mousePressed(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }
    public void mouseClicked(MouseEvent e) {

        rock1.arrowKeyPressed("START", true);
        rock2.arrowKeyPressed("START", true);
        rock3.arrowKeyPressed("START", true);

        paper1.arrowKeyPressed("START", true);
        paper2.arrowKeyPressed("START", true);
        paper3.arrowKeyPressed("START", true);

        scissors1.arrowKeyPressed("START", true);
        scissors2.arrowKeyPressed("START", true);
        scissors3.arrowKeyPressed("START", true);
        //playSound();
    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }

    public void start(final int ticks) {
        Thread gameThread = new Thread() {
            public void run() {
                while(true) {
                    loop();
                    try {
                        Thread.sleep(1000/ticks);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        gameThread.start();
    }

    public static void main(String[] args) {
        //loadSound();

        Main g = new Main();
        g.start(60);
    }
}
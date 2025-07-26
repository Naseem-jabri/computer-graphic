import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.File;
import java.util.Random;
import javax.sound.sampled.*;

public class SuperMario extends JPanel implements KeyListener, ActionListener {

    // Constants and variables
    static int w = 900;
    static int h = 600;

    Image mario;
    Image bgImage;

    Timer gameTimer;
    Timer randomAppearanceTimer;

    int mariox = 100;
    int marioy = 400;
    int speed = 0;
    int gravity = 0;
    boolean jumping = false;

    int coinX = 400;
    int coinY = 300;
    int coinSize = 30;
    int coinsTotal = 0;

    int obstacleX = 0;
    int obstacleY = 0;
    int obstacleSize = 50;
    boolean isObstacleVisible = false;

    Rectangle2D.Double marioBounds;
    Ellipse2D.Double coin;
    Rectangle2D.Double randomObstacle;

    Random random = new Random();
    int groundHeight = 100;

    // Main method
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(w, h);
        frame.setTitle("Super Mario Game");
        frame.add(new SuperMario());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Constructor
    public SuperMario() {
        this.setSize(new Dimension(w, h));
        addKeyListener(this);
        setFocusable(true);

        mario = new ImageIcon("C:\\Users\\96655\\Desktop\\java project\\lab four\\mario.png").getImage();
        bgImage = new ImageIcon("C:\\Users\\96655\\Desktop\\java project\\lab four\\background.png").getImage();

        gameTimer = new Timer(10, this);
        gameTimer.start();

        scheduleRandomAppearance();

        playSound("C:\\Users\\96655\\Desktop\\java project\\lab four\\background.wav");
    }

    // Play sound method
    public void playSound(String soundFile) {
        try {
            File file = new File(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Schedule obstacles randomly
    public void scheduleRandomAppearance() {
        randomAppearanceTimer = new Timer(random.nextInt(2000) + 1000, e -> {
            if (!isObstacleVisible) {
                obstacleX = 0;
                obstacleY = random.nextInt(h - groundHeight - obstacleSize);
                isObstacleVisible = true;
            }
            randomAppearanceTimer.setDelay(random.nextInt(2000) + 1000);
        });
        randomAppearanceTimer.start();
    }

    // Paint graphics
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(3));

        // Background
        g2d.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);

        // Mario
        g2d.drawImage(mario, mariox, marioy, null);
        marioBounds = new Rectangle2D.Double(mariox, marioy, mario.getWidth(null), mario.getHeight(null));

        // Coin
        coin = new Ellipse2D.Double(coinX, coinY, coinSize, coinSize);
        g2d.setColor(Color.YELLOW);
        g2d.fill(coin);
        g2d.setColor(Color.RED);
        g2d.draw(coin);

        // Score Text
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Chalkboard", Font.BOLD | Font.ITALIC, 30));
        g2d.drawString("Coins = " + coinsTotal, 10, 30);

        // Coin collision
        if (coin.intersects(marioBounds)) {
            coinX = random.nextInt(w - coinSize);
            coinY = random.nextInt(h - groundHeight - coinSize);
            coinsTotal++;
            playSound("C:\\Users\\96655\\Desktop\\java project\\lab four\\smb_coin.wav");
        }

        // Obstacle
        if (isObstacleVisible) {
            randomObstacle = new Rectangle2D.Double(obstacleX, obstacleY, obstacleSize, obstacleSize);
            g2d.setColor(new Color(0xBD5827));
            g2d.fill(randomObstacle);
            g2d.setColor(Color.BLACK);
            g2d.draw(randomObstacle);

            if (randomObstacle.intersects(marioBounds)) {
                g2d.setColor(Color.RED);
                g2d.setFont(new Font("Chalkboard", Font.BOLD | Font.ITALIC, 80));
                g2d.drawString("GAME OVER", 250, 350);
                gameTimer.stop();
                playSound("C:\\Users\\96655\\Desktop\\java project\\lab four\\smb_mariodie.wav");
            }
        }
    }

    // Game loop
    @Override
    public void actionPerformed(ActionEvent e) {
        // Gravity & Jumping
        gravity += 1;
        marioy += gravity;

        if (marioy >= getHeight() - mario.getHeight(null) - groundHeight) {
            marioy = getHeight() - mario.getHeight(null) - groundHeight;
            jumping = false;
        }

        // Horizontal movement
        mariox += speed;
        if (mariox + mario.getWidth(null) > getWidth() || mariox < 0) {
            speed *= -1;
        }

        // Obstacle movement
        if (isObstacleVisible) {
            obstacleX += 3;
            if (obstacleX > getWidth()) {
                isObstacleVisible = false;
            }
        }

        repaint();
    }

    // Keyboard controls
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                speed = -3;
                break;
            case KeyEvent.VK_RIGHT:
                speed = 3;
                break;
            case KeyEvent.VK_SPACE:
                if (!jumping) {
                    gravity = -35;
                    jumping = true;
                    playSound("C:\\Users\\96655\\Desktop\\java project\\lab four\\smb_jump-small.wav");
                }
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }
}
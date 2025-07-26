import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NewJeansGame extends Component implements KeyListener, ActionListener {

    // Images
    Image herean;
    Image bg;

    // Image coordinates
    int hereanx = 400;
    int hereany = 195;
    int hereanw = 80;
    int hereanH = 100;

    // Frame dimensions
    static int h = 600;
    static int w = 900;

    // Rotation angle
    double rotation = 0;

    // Optional: flip image horizontally
    boolean flipHorizontal = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame(); // Create a JFrame container
        frame.setSize(w, h); // Set frame size (width, height)
        frame.setTitle("NewJeans Game"); // Set frame title
        frame.add(new NewJeansGame()); // Add component to the JFrame
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true); // Show frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
    }

    // Constructor
    public NewJeansGame() {
        this.setSize(new Dimension(w, h));
        addKeyListener(this);
        setFocusable(true);

        // Load images
        herean = new ImageIcon("C:\\Users\\96655\\Desktop\\java project\\lab five\\tinywow_change_be_photo_66892773.png").getImage();
        bg = new ImageIcon("C:\\Users\\96655\\Desktop\\java project\\lab five\\photo_2024-10-15_01-07-27.jpg").getImage();
    }

    // Paint method
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Draw background
        g2d.drawImage(bg, 0, 0, getWidth(), getHeight(), null);

        // Apply rotation
        g2d.rotate(Math.toRadians(rotation), hereanx + hereanw / 2.0, hereany + hereanH / 2.0);

        // Draw image (flipped or normal)
        if (flipHorizontal) {
            g2d.drawImage(herean, hereanx + hereanw, hereany, -hereanw, hereanH, null);
        } else {
            g2d.drawImage(herean, hereanx, hereany, hereanw, hereanH, null);
        }

        // Undo rotation
        g2d.rotate(-Math.toRadians(rotation), hereanx + hereanw / 2.0, hereany + hereanH / 2.0);
    }

    // Move method with boundary checking
    private void moveHerean(int dx, int dy) {
        int gameFrameX = 280;
        int gameFrameY = 140;
        int gameFrameWidth = 340;
        int gameFrameHeight = 190;

        // Check horizontal boundaries
        if (hereanx + dx < gameFrameX || hereanx + dx + hereanw > gameFrameX + gameFrameWidth) {
            dx = 0;
        }

        // Check vertical boundaries
        if (hereany + dy < gameFrameY || hereany + dy + hereanH > gameFrameY + gameFrameHeight) {
            dy = 0;
        }

        // Update position
        hereanx += dx;
        hereany += dy;
        repaint();
    }

    // Key events
    @Override
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();

        // Movement
        if (key == KeyEvent.VK_UP) {
            moveHerean(0, -10);
        } else if (key == KeyEvent.VK_DOWN) {
            moveHerean(0, 10);
        } else if (key == KeyEvent.VK_LEFT) {
            moveHerean(-10, 0);
        } else if (key == KeyEvent.VK_RIGHT) {
            moveHerean(10, 0);
        }

        // Resize larger
        if (key == KeyEvent.VK_1) {
            if (hereanx + hereanw + 10 <= w && hereany + hereanH + 10 <= h) {
                hereanw += 10;
                hereanH += 10;
            }
            repaint();
        }

        // Resize smaller
        if (key == KeyEvent.VK_2) {
            hereanw = Math.max(10, hereanw - 10);
            hereanH = Math.max(10, hereanH - 10);
            repaint();
        }

        // Rotate
        if (key == KeyEvent.VK_R) {
            rotation += 15;
            repaint();
        }

        // Flip horizontal (optional)
        if (key == KeyEvent.VK_F) {
            flipHorizontal = !flipHorizontal;
            repaint();
        }
    }

    // Required by KeyListener (not used)
    @Override
    public void keyReleased(KeyEvent ke) {}
    @Override
    public void keyTyped(KeyEvent ke) {}

    // Required by ActionListener (not used)
    @Override
    public void actionPerformed(ActionEvent e) {}
}
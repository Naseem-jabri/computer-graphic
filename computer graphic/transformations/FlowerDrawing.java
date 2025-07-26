import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class FlowerDrawing extends JPanel {

    private void drawFlowerAt(Graphics2D g2d, int centerX, int centerY, int radius, double degrees) {
        double angle = Math.toRadians(degrees);
        int x = centerX + (int)(radius * Math.cos(angle)) - 50;
        int y = centerY + (int)(radius * Math.sin(angle)) - 50;

        AffineTransform originalTransform = g2d.getTransform();

        g2d.translate(x + 50, y + 50);
        g2d.translate(-50, -50);

        drawFlower(g2d, 0, 0);  

        g2d.setTransform(originalTransform);
        g2d.setColor(Color.GREEN);
        g2d.setFont(new Font("Chalkboard", Font.BOLD, 25));
        g2d.drawString("Super Flower", x + 40, y + 240);

        g2d.setTransform(originalTransform);
    }

    private void drawFlower(Graphics2D g2d, int x, int y) {
        AffineTransform originalTransform = g2d.getTransform();

        Color[] petalColors = {
            Color.PINK, Color.CYAN, Color.ORANGE, Color.BLUE, Color.RED, Color.MAGENTA
        };

        int[] angles = {0, 60, 120, 180, 240, 300};

        for (int i = 0; i < angles.length; i++) {
            g2d.setTransform(originalTransform);
            g2d.translate(x + 50, y + 50);
            g2d.rotate(Math.toRadians(angles[i]));
            g2d.translate(-50, -50);
            g2d.setColor(petalColors[i % petalColors.length]);
            g2d.fillOval(x, y, 50, 50);
        }

        g2d.setTransform(originalTransform);
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(x + 25, y + 25, 50, 50); 

        g2d.setColor(Color.BLACK);
        g2d.fillOval(x + 35, y + 35, 10, 10);
        g2d.fillOval(x + 50, y + 35, 10, 10); 
        g2d.drawArc(x + 30, y + 45, 30, 15, 0, -180); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = 150;

        drawFlowerAt(g2d, centerX, centerY, radius, 0);
        drawFlowerAt(g2d, centerX, centerY, radius, 72);
        drawFlowerAt(g2d, centerX, centerY, radius, 144);
        drawFlowerAt(g2d, centerX, centerY, radius, 216);
        drawFlowerAt(g2d, centerX, centerY, radius, 288);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flower Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(new FlowerDrawing());
        frame.setVisible(true);
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class StarComponent extends JComponent {

    // 1. الدالة الرئيسية لتشغيل البرنامج
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rotating Stars with Smiley Faces");
        StarComponent starComponent = new StarComponent();
        frame.add(starComponent);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // 2. دالة paintComponent ترسم كل النجوم بالدوران
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = 200;

        drawStarWithTransform(g2d, centerX, centerY, radius, 0);
        drawStarWithTransform(g2d, centerX, centerY, radius, 30);
        drawStarWithTransform(g2d, centerX, centerY, radius, 60);
        drawStarWithTransform(g2d, centerX, centerY, radius, 90);
        drawStarWithTransform(g2d, centerX, centerY, radius, 120);
        drawStarWithTransform(g2d, centerX, centerY, radius, 150);
        drawStarWithTransform(g2d, centerX, centerY, radius, 180);
        drawStarWithTransform(g2d, centerX, centerY, radius, 210);
        drawStarWithTransform(g2d, centerX, centerY, radius, 240);
        drawStarWithTransform(g2d, centerX, centerY, radius, 270);
        drawStarWithTransform(g2d, centerX, centerY, radius, 300);
        drawStarWithTransform(g2d, centerX, centerY, radius, 330);
    }

    // 3. دالة رسم النجمة مع التدوير والكتابة
    private void drawStarWithTransform(Graphics2D g2d, int centerX, int centerY, int radius, int angleDegrees) {
        AffineTransform originalTransform = g2d.getTransform();

        double angle = Math.toRadians(angleDegrees);
        int x = centerX + (int) (radius * Math.cos(angle)) - 25;
        int y = centerY + (int) (radius * Math.sin(angle)) - 25;

        g2d.translate(x + 25, y + 25);
        g2d.rotate(angle);
        g2d.translate(-25, -25);

        drawStaticStar(g2d, 25, 25, 50);

        g2d.setColor(Color.WHITE); // Set painting color
        g2d.setFont(new Font("Chilanka", Font.BOLD, 10)); // Set font (font, style, size)
        g2d.drawString("QUALITY", 8, 40);

        g2d.setColor(new Color(0x0000FF)); // Set painting color
        g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 10)); // Set font (font, style, size)
        g2d.drawString("INNOVATION", 0, 50);

        g2d.setTransform(originalTransform);
    }

    // 4. دالة رسم نجمة ثابتة
    private void drawStaticStar(Graphics2D g2d, int x, int y, int size) {
        g2d.setColor(Color.YELLOW);
        int[] xPoints = new int[10];
        int[] yPoints = new int[10];

        for (int i = 0; i < 10; i++) {
            double angle = Math.toRadians(i * 36); // 360 / 10
            int r = (i % 2 == 0) ? size : size / 2;
            xPoints[i] = (int) (x + r * Math.cos(angle));
            yPoints[i] = (int) (y + r * Math.sin(angle));
        }

        g2d.fillPolygon(xPoints, yPoints, 10);
        drawFace(g2d, x - size / 4, y - size / 4, size / 2);
    }

    // 5. دالة رسم وجه (عيون وفم)
    private void drawFace(Graphics2D g2d, int x, int y, int size) {
        g2d.setColor(Color.BLACK);
        g2d.fillOval(x + 3, y + 3, 10, 10);
        g2d.fillOval(x + size - 13, y + 3, 10, 10);
        g2d.drawArc(x + 3, y + 5, size - 6, size - 10, 0, -180);
    }
}

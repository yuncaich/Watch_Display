package watch;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SwingWatchDisplay extends JPanel implements WatchDisplay  {
    
    private final Image background;
    private Point[] points = new Point[0];

    public SwingWatchDisplay() {
        this.background = load("background.jpg");
    }
    

    
    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, this);
        g.setColor(Color.black);
        int width = 1;
        for (Point point : points) {
            g2(g).setStroke(new BasicStroke(width++));
            g.drawLine(ox(), oy(), ox() + point.x, oy() - point.y);
        }
    }
    
    private int ox() {
        return getWidth() / 2;
    }
    
    private int oy() {
        return getHeight()/ 2;
    }
    
    private Graphics2D g2(Graphics g) {
        return (Graphics2D) g;
    }

    private Image load(String filename) {
        try {
            return ImageIO.read(new File(filename));
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public void show(double hours, double minutes, double seconds) {
        points = new Point[3];
        points[0] = pointAt(200, seconds);
        points[1] = pointAt(150, minutes);
        points[2] = pointAt(100, hours);
        repaint();
    }

    private Point pointAt(int length, double angle) {
        return new Point((int)(length * cos(angle)), (int)(length * sin(angle)));
    }

    
}

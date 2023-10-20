import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MovingObjects extends JFrame implements MouseMotionListener {
    private int rectx = 50;
    private int recty = 50;

    public MovingObjects() {
        super("Move It");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        getContentPane().setBackground(Color.decode("#5f3c69"));
        addMouseMotionListener(this);
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(rectx, recty, 50, 50);
    }
    public static void main(String[] args) {
        MovingObjects tryIt = new MovingObjects();
        tryIt.setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        rectx = e.getX();
        recty = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

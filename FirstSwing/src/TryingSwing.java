import javax.swing.*;
public class TryingSwing extends JFrame {
    public TryingSwing() {
        super("My first window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        Runnable initFrame = new Runnable() {
            public void run() {
                new TryingSwing();
            }
        };
        SwingUtilities.invokeAndWait(initFrame);
    }
}

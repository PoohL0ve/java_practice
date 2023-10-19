import javax.swing.*;
public class TryingSwing extends JFrame {
    public TryingSwing() {
        super("My first window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null); // centers the window

        // call the method that contains all components
        testingComponents();
    }
    private void testingComponents() {
        JLabel myTest = new JLabel();
        myTest.setText("Test window!");
        myTest.setBounds(40, 20, 100, 30);
        add(myTest);

        JTextField textBox = new JTextField();
        textBox.setBounds(160, 20, 100, 30);
        add(textBox);
    }
    public static void main(String[] args) throws Exception {
        //new TryingSwing();
        Runnable initFrame = new Runnable() {
            public void run() {
                new TryingSwing();
            }
        };
        SwingUtilities.invokeAndWait(initFrame);
    }
}

import javax.swing.*;
import java.awt.*;

public class TryingSwing extends JFrame {
    public TryingSwing() {
        super("My first window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
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

        JPanel tealPanel = new JPanel();
        tealPanel.setLayout(new BorderLayout());
        tealPanel.setBounds(40, 150, 220, 70);
        tealPanel.setBackground(Color.decode("#00939d"));
        add(tealPanel);

        JLabel helloLabel = new JLabel("Hello");
        helloLabel.setBounds(50,20, 100,30);
        helloLabel.setHorizontalAlignment(SwingConstants.CENTER); // aligns label
        helloLabel.setVerticalAlignment(SwingConstants.CENTER);

        Font font = new Font("Courier", Font.BOLD,12);
        helloLabel.setFont(font);
        helloLabel.setFont(helloLabel.getFont().deriveFont(16f));

        tealPanel.add(helloLabel); // adding label to the panel

        JButton acceptButton = new JButton("Accept");
        acceptButton.setBounds(100,70,100,30);
        add(acceptButton);

        acceptButton.addActionListener(e -> {
            String helloText = "Hello";
            String name = textBox.getText();
            if (name != null && !name.trim().isEmpty()) {
                helloText += String.format(", %s", name);
            }
            helloLabel.setText(helloText);
        });
    }
    public static void main(String[] args) throws Exception {
        //new TryingSwing();
        Runnable initFrame = TryingSwing::new;
        SwingUtilities.invokeAndWait(initFrame);
    }
}

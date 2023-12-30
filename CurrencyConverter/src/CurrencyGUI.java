import javax.swing.*;
import java.awt.*;
public class CurrencyGUI extends JFrame {
    private final double conversion = 0.82;
    // Constructor for the window
    CurrencyGUI() {
        this.setTitle("USD to GBP Converter");
        this.setSize(350, 200);
        this.setVisible(true);
        this.setResizable(false); // window size can not be changed
        this.setLocationRelativeTo(null); // centers the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.decode("#283044"));
        this.getContentPane().setBackground(Color.decode("#283044"));

        // calling components method
        windowComponents(); // contains other elements such as labels, panes and buttons
    }
    private void windowComponents() {
        // creating a label

        JLabel usd = new JLabel(); // USD label
        usd.setText("USD: ");
        usd.setFont(new Font("Futura", Font.BOLD, 14));
        usd.setForeground(new Color(230,233,242)); // rgb uses int
        usd.setBounds(20, 8, 75, 15);
        //add(usd);

        JLabel gbp = new JLabel(); // EUROS label
        gbp.setText("GBP: ");
        gbp.setFont(new Font("Futura", Font.BOLD, 14));
        gbp.setForeground(new Color(230, 233, 242 ));
        gbp.setBounds(20, 8, 150, 15);
        gbp.setHorizontalAlignment(SwingConstants.CENTER); // aligns label
        gbp.setVerticalAlignment(SwingConstants.CENTER);
        //add(gbp);

        // Using a panel to hold components
        JPanel usdPanel = new JPanel(); // USD Panel
        usdPanel.setLayout(null);//(new FlowLayout());
        usdPanel.setBounds(75, 20, 200, 90);
        usdPanel.setBackground(new Color(128, 42, 44));
        usdPanel.add(usd);
        add(usdPanel);

        JPanel gbpPanel = new JPanel(); // Pounds Panel
        gbpPanel.setLayout(null);//(new FlowLayout());
        gbpPanel.setBounds(75, 125, 200, 30);
        gbpPanel.setBackground(new Color(128, 42, 44));
        gbpPanel.add(gbp);
        add(gbpPanel);

        // Adding text-fields
        JTextField usdText = new JTextField();
        usdText.setFont(new Font("Futura", Font.PLAIN, 12));
        usdText.setBounds(85, 3, 100, 25);
        usdText.setVisible(true);
        usdPanel.add(usdText);

        // Convert Button
        JButton convert = new JButton("CONVERT");
        convert.setVisible(true);
        convert.setBounds(37, 40, 125, 40);
        convert.setFont(new Font("Futura", Font.BOLD, 12));
        convert.setFocusable(false);
        convert.setForeground(new Color(251, 176, 45));
        convert.setBackground(Color.WHITE);
        convert.setBorder(BorderFactory.createEtchedBorder());
        add(convert);
        usdPanel.add(convert);

        // doing the conversion
        convert.addActionListener(e -> {
            try {
                double usdAmount = Double.parseDouble(usdText.getText());
                double gbpAmount = usdAmount * conversion; // accesses the value from the model
                String conversionText = String.valueOf(gbpAmount);
                String returnText = String.format("GBP: %s", conversionText);
                gbp.setText(returnText); // returns the text to the view
            } catch (NumberFormatException ex) {
                // Handle the exception
                JOptionPane.showMessageDialog(this,
                        "Invalid input. Please enter a valid number.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

    }
}

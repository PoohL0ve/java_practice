import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PlayingwithWindows extends JFrame {
    private class CheckExit extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            CallWindow dialogue = new CallWindow();
            dialogue.setVisible(true);
        }
    }
    private class CallWindow extends JFrame implements ActionListener {
        public CallWindow() {
            setSize(250, 100);
            setLayout(new BorderLayout());

            JLabel confirmExit = new JLabel("Are you sure you want to leave?",
                    SwingConstants.CENTER);
            add(confirmExit, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout());

            JButton exitButton = new JButton("Yes");
            exitButton.addActionListener(this);
            buttonPanel.add(exitButton);

            JButton cancelButton = new JButton("No");
            cancelButton.addActionListener(this);
            buttonPanel.add(cancelButton);

            add(buttonPanel,BorderLayout.SOUTH);
        }
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();

            if (action.equals("Yes")) {
                System.exit(0);
            } else if (action.equals("No")) {
                dispose();
            }
        }
    }
    public PlayingwithWindows() {
        setSize(300,300);
        setTitle("Window Listener");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new CheckExit());
    }
    public static void main(String[] args) {
        PlayingwithWindows demoWindow = new PlayingwithWindows();
        demoWindow.setVisible(true);
    }
}

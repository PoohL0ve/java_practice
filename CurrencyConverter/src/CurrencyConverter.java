import javax.swing.*;
import java.awt.*;

public class CurrencyConverter {
    public static void main(String [] args) {
       new CurrencyGUI();
        /*// SwingUtilities.invoke ensures the application
        // is run using the EDT
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CurrencyGUI();
            }
        });*/
    }
}

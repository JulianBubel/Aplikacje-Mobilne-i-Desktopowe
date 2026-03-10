import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main(String login, String role) {

        setTitle("system obsługi sklepu");
        setSize(500,167);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu sprzedaz = new JMenu("sprzedaż");
        JMenu raporty = new JMenu("raporty");
        JMenu zarzadzanie = new JMenu("zarządzanie użytkownikami");

        menuBar.add(sprzedaz);
        menuBar.add(raporty);
        menuBar.add(zarzadzanie);

        if(role.equals("User")){

            raporty.setEnabled(false);
            menuBar.remove(zarzadzanie);

        }

        setJMenuBar(menuBar);

        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel statusLabel = new JLabel(
                "zalogowano jako: " + login + " | rola: " + role
        );

        statusBar.add(statusLabel);

        add(statusBar, BorderLayout.SOUTH);

        setVisible(true);
    }
}
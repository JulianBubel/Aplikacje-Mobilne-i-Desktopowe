import java.awt.*;
import javax.swing.*;

public class EkranLogowania extends JFrame {

    public EkranLogowania() {
        super("ekran logowania");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);

        JPanel panelGlowny = new JPanel();
        panelGlowny.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel etykietaUzytkownik = new JLabel("Użytkownik:");
        JTextField poleUzytkownik = new JTextField(15);

        JLabel etykietaHaslo = new JLabel("Hasło:");
        JPasswordField poleHaslo = new JPasswordField(15);

        panelGlowny.add(etykietaUzytkownik);
        panelGlowny.add(poleUzytkownik);
        panelGlowny.add(etykietaHaslo);
        panelGlowny.add(poleHaslo);

        add(panelGlowny, BorderLayout.CENTER);

        JPanel panelPrzyciski = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton przyciskZaloguj = new JButton("Zaloguj");
        JButton przyciskAnuluj = new JButton("Anuluj");
        panelPrzyciski.add(przyciskZaloguj);
        panelPrzyciski.add(przyciskAnuluj);
        add(panelPrzyciski, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }
}
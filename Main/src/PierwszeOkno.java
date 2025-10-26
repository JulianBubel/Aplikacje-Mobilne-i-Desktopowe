import javax.swing.*;

public class PierwszeOkno extends JFrame {
    public PierwszeOkno() {
        super("Pierwsze okno - Javastart");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // wyśrodkowanie
        setVisible(true);
    }
}
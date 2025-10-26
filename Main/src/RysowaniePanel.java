import javax.swing.*;
import java.awt.*;

public class RysowaniePanel extends JFrame {

    public RysowaniePanel() {
        super("Rysowanie na panelu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        add(new PanelRysowania());

        setVisible(true);
    }

    // Wewnętrzna klasa panelu rysującego
    class PanelRysowania extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.fillRect(50, 50, 100, 60);

            g.setColor(Color.RED);
            g.fillOval(200, 100, 80, 80);

            g.setColor(Color.BLACK);
            g.drawString("To jest rysowanie!", 120, 30);
        }
    }
}
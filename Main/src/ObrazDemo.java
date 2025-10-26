import javax.swing.*;
import java.awt.*;

public class ObrazDemo extends JFrame {

    private Image image;

    public ObrazDemo() {
        super("Wyświetlanie obrazu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        image = Toolkit.getDefaultToolkit().getImage("img.jpg");

        add(new PanelObrazu());

        setVisible(true);
    }

    class PanelObrazu extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 50, 30, 300, 200, this);
            } else {
                g.drawString("Nie znaleziono obrazu!", 100, 100);
            }
        }
    }
}
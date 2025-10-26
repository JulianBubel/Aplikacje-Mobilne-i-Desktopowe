import javax.swing.*;
import java.awt.event.*;

public class ObslugaMyszyDemo extends JFrame implements MouseListener {

    JLabel label;

    public ObslugaMyszyDemo() {
        super("Obsługa myszy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(null);

        label = new JLabel("Kliknij w okno!");
        label.setBounds(100, 70, 150, 30);
        add(label);

        addMouseListener(this);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        label.setText("Kliknięto: " + e.getX() + ", " + e.getY());
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}

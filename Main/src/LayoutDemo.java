import javax.swing.*;
import java.awt.*;

public class LayoutDemo extends JFrame {
    public LayoutDemo() {
        super("Layout Manager Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        add(new JButton("Północ"), BorderLayout.NORTH);
        add(new JButton("Południe"), BorderLayout.SOUTH);
        add(new JButton("Wschód"), BorderLayout.EAST);
        add(new JButton("Zachód"), BorderLayout.WEST);
        add(new JButton("Środek"), BorderLayout.CENTER);

        setVisible(true);
    }
}
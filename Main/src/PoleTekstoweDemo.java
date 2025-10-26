import javax.swing.*;

class PolaTekstoweDemo extends JFrame {

    public PolaTekstoweDemo() {
        super("Pola tekstowe");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JTextField pole = new JTextField();
        pole.setBounds(50, 30, 200, 25);
        add(pole);

        JButton button = new JButton("Pokaż tekst");
        button.setBounds(80, 70, 140, 25);
        add(button);

        button.addActionListener(e -> {
            String tekst = pole.getText();
            JOptionPane.showMessageDialog(this, "Wpisałeś: " + tekst);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
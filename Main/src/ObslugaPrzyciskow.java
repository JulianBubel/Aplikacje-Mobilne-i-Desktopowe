import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ObslugaPrzyciskow extends JFrame {

    public ObslugaPrzyciskow() {
        super("Obsługa przycisków");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton przycisk = new JButton("Kliknij mnie!");
        przycisk.setBounds(80, 60, 140, 40);
        add(przycisk);

        przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Przycisk został kliknięty!");
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
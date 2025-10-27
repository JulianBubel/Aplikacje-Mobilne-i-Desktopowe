import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularzWeryfikacji extends JFrame {

    private JTextField poleWieku;
    private JCheckBox regulamin;
    private JButton zatwierdz;

    public FormularzWeryfikacji() {
        super("Formularz Weryfikacji");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelWiek = new JLabel("Wiek:");
        poleWieku = new JTextField(10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelWiek, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(poleWieku, gbc);

        regulamin = new JCheckBox("Akceptuję regulamin");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(regulamin, gbc);

        zatwierdz = new JButton("Zatwierdź");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(zatwierdz, gbc);

        zatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int wiek = Integer.parseInt(poleWieku.getText());

                    if (wiek >= 18 && regulamin.isSelected()) {
                        JOptionPane.showMessageDialog(FormularzWeryfikacji.this,
                                "Rejestracja pomyślna!",
                                "Sukces",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(FormularzWeryfikacji.this,
                                "Wymagany wiek 18+ i akceptacja regulaminu!",
                                "Błąd",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(FormularzWeryfikacji.this,
                            "Podaj poprawną wartość liczbową dla wieku!",
                            "Błąd",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormularzWeryfikacji::new);
    }
}
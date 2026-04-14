import javax.swing.*;
import java.awt.*;

public class BMICalculator extends JFrame {
    private JPanel mainPanel;
    private JTextField weightField;
    private JTextField heightField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public BMICalculator() {
        this.setContentPane(mainPanel);
        this.setTitle("BMI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setMinimumSize(new Dimension(200, 150));
        this.setPreferredSize(new Dimension(200, 150));
        this.setSize(200, 150);

        calculateButton.addActionListener(e -> {
            try {
                String wText = weightField.getText().replace(",", ".");
                String hText = heightField.getText().replace(",", ".");

                double weight = Double.parseDouble(wText);
                double heightCm = Double.parseDouble(hText);

                double heightM = heightCm / 100.0;
                double bmi = weight / (heightM * heightM);

                resultLabel.setText(String.format("BMI: %.2f", bmi));

            } catch (Exception ex) {
                resultLabel.setText("błąd");
            }
        });

        this.pack();
        this.setLocationRelativeTo(null);
    }
}
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZawieszajacaApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Zawieszająca Aplikacja");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 180);
        frame.setLayout(null);

        JButton startButton = new JButton("Start");
        JLabel statusLabel = new JLabel("Status: ");

        startButton.setBounds(100, 50, 100, 30);
        statusLabel.setBounds(100, 100, 200, 30);

        frame.add(startButton);
        frame.add(statusLabel);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(1000);
                        statusLabel.setText("Pracuję... " + (i + 1) + "s");
                    }
                    statusLabel.setText("Zakończono blokadę.");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.setVisible(true);
    }
}

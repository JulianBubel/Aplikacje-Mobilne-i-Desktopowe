import javax.swing.*;
import java.awt.*;

public class SimpleTest extends JFrame {

    private JPanel mainPanel;
    private JLabel myLabel;
    private JButton actionButton;

    public SimpleTest() {

        this.setTitle("Test GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        myLabel = new JLabel("Oczekiwanie...");
        actionButton = new JButton("Kliknij mnie");

        mainPanel.add(myLabel);
        mainPanel.add(actionButton);

        this.setContentPane(mainPanel);

        actionButton.addActionListener(e -> {
            myLabel.setText("witam w swing");
        });

        this.pack();
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
    }
}
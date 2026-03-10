import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Logowanie extends JFrame {
    private JTextField loginField;
    private JPasswordField passwordField;
    public Logowanie() {
        setTitle("logowanie");
        setSize(500,167);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,2,10,10));
        add(new JLabel("login:"));
        loginField = new JTextField();
        add(loginField);
        add(new JLabel("hasło:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginButton = new JButton("zaloguj");
        loginButton.addActionListener(this::login);
        add(new JLabel());
        add(loginButton);
        setVisible(true);
    }
    private void login(ActionEvent e) {
        String login = loginField.getText();
        String password = new String(passwordField.getPassword());
        if(login.equals("bubel") && password.equals("bubel123")){
            new Main(login,"Admin");
            dispose();

        } else if(login.equals("user") && password.equals("user123")){
            new Main(login,"User");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                    "błąd loginu lub hasła",
                    "stop rabusiom",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Logowanie::new);
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ZadanieView extends JFrame {
    private JList<String> listaZadan;
    private DefaultListModel<String> listModel;
    private JTextField zadanieTextField;
    private JButton dodajButton, usunButton;

    public ZadanieView() {
        setTitle("Lista To-Do");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        listaZadan = new JList<>(listModel);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(new JScrollPane(listaZadan), BorderLayout.CENTER);

        zadanieTextField = new JTextField(20);
        panel.add(zadanieTextField, BorderLayout.NORTH);

        dodajButton = new JButton("Dodaj");
        usunButton = new JButton("Usuń");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(dodajButton);
        buttonPanel.add(usunButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    public void updateList(List<Zadanie> zadania) {
        listModel.clear();
        for (Zadanie zadanie : zadania) {
            listModel.addElement(zadanie.toString());
        }
    }

    public String getZadanieText() {
        return zadanieTextField.getText();
    }

    public int getSelectedTaskIndex() {
        return listaZadan.getSelectedIndex();
    }

    public void addDodajListener(ActionListener listener) {
        dodajButton.addActionListener(listener);
    }

    public void addUsunListener(ActionListener listener) {
        usunButton.addActionListener(listener);
    }
}

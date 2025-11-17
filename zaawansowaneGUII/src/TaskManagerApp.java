import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManagerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TaskManagerApp().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Zadania");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        List<Task> lista = new ArrayList<>();
        lista.add(new Task("Zakupy", false, "Średni"));
        lista.add(new Task("Sprawko", true, "Wysoki"));
        lista.add(new Task("Poodkurzac", false, "Niski"));

        TaskTableModel model = new TaskTableModel(lista);
        JTable tabela = new JTable(model);

        tabela.getColumnModel().getColumn(1).setCellRenderer(TaskRenderers.getStatusRenderer());
        tabela.getColumnModel().getColumn(2).setCellRenderer(TaskRenderers.getPriorityRenderer());

        tabela.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JCheckBox()));

        JPanel panelLewy = new JPanel();
        panelLewy.setLayout(new BoxLayout(panelLewy, BoxLayout.Y_AXIS));

        JButton btnDodaj = new JButton("Dodaj Zadanie");
        JButton btnUsun = new JButton("Usuń Wybrane");

        panelLewy.add(Box.createVerticalStrut(0));
        panelLewy.add(btnDodaj);
        panelLewy.add(Box.createVerticalStrut(5));
        panelLewy.add(btnUsun);
        panelLewy.add(Box.createVerticalGlue());

        btnDodaj.addActionListener(e -> {
            String nazwa = JOptionPane.showInputDialog(frame, "Podaj nazwę zadania:");
            if (nazwa != null && !nazwa.trim().isEmpty()) {
                String[] priorytety = {"Niski", "Średni", "Wysoki"};
                String priorytet = (String) JOptionPane.showInputDialog(
                        frame, "Wybierz priorytet:", "Priorytet",
                        JOptionPane.QUESTION_MESSAGE, null, priorytety, "Średni");
                if (priorytet != null)
                    model.addTask(new Task(nazwa, false, priorytet));
            }
        });

        btnUsun.addActionListener(e -> {
            int selected = tabela.getSelectedRow();
            if (selected >= 0) model.removeTask(selected);
        });

        JScrollPane scrollPane = new JScrollPane(tabela);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLewy, scrollPane);
        splitPane.setDividerLocation(150);

        frame.add(splitPane);
        frame.setVisible(true);
    }
}

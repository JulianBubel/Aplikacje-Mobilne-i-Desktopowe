import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {

    // ================= MODEL =================
    static class Task {
        int id;
        String title;
        String description;
        boolean isDone;

        Task(int id, String t, String d, boolean b) {
            id = id;
            title = t;
            description = d;
            isDone = b;
        }
    }

    // ================= REPOSITORY =================
    interface TaskRepository {
        List<Task> getAll() throws Exception;
        boolean add(String title, String desc) throws Exception;
    }

    static class MySQLRepo implements TaskRepository {

        private Connection conn() throws Exception {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testowanie",
                    "root",
                    ""
            );
        }

        public List<Task> getAll() throws Exception {
            List<Task> list = new ArrayList<>();

            try (Connection c = conn();
                 Statement s = c.createStatement();
                 ResultSet rs = s.executeQuery("SELECT * FROM tasks")) {

                while (rs.next()) {
                    list.add(new Task(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getBoolean("is_done")
                    ));
                }
            }
            return list;
        }

        public boolean add(String t, String d) throws Exception {
            try (Connection c = conn();
                 PreparedStatement ps = c.prepareStatement(
                         "INSERT INTO tasks(title, description, is_done) VALUES (?, ?, ?)")) {

                ps.setString(1, t);
                ps.setString(2, d);
                ps.setBoolean(3, false);

                return ps.executeUpdate() > 0;
            }
        }
    }

    // ================= CONTROLLER (DI) =================
    static class TaskController {
        private final TaskRepository repo;

        TaskController(TaskRepository r) {
            this.repo = r;
        }

        List<Task> load() throws Exception {
            return repo.getAll();
        }

        boolean add(String t, String d) throws Exception {
            if (t == null || t.length() < 3)
                throw new IllegalArgumentException("Za krótki tytuł");

            return repo.add(t, d);
        }
    }

    // ================= GUI =================
    JTable table;
    DefaultTableModel model;
    JLabel status;

    TaskController controller;

    public Main() {

        controller = new TaskController(new MySQLRepo());

        setTitle("Task Manager");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        model = new DefaultTableModel(
                new Object[]{"ID", "Tytuł", "Opis", "Done"}, 0
        );

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel top = new JPanel();

        JButton load = new JButton("Load");
        JButton add = new JButton("Add");

        top.add(load);
        top.add(add);

        add(top, BorderLayout.NORTH);

        status = new JLabel("Ready");
        add(status, BorderLayout.SOUTH);

        // LOAD
        load.addActionListener(e -> {
            new SwingWorker<List<Task>, Void>() {
                protected List<Task> doInBackground() throws Exception {
                    return controller.load();
                }

                protected void done() {
                    try {
                        List<Task> list = get();
                        model.setRowCount(0);

                        for (Task t : list) {
                            model.addRow(new Object[]{
                                    t.id, t.title, t.description, t.isDone
                            });
                        }

                        status.setText("Loaded: " + list.size());

                    } catch (Exception ex) {
                        status.setText("Error: " + ex.getMessage());
                    }
                }
            }.execute();
        });

        // ADD
        add.addActionListener(e -> {

            String t = JOptionPane.showInputDialog("Title:");
            String d = JOptionPane.showInputDialog("Description:");

            new SwingWorker<Boolean, Void>() {
                protected Boolean doInBackground() throws Exception {
                    return controller.add(t, d);
                }

                protected void done() {
                    try {
                        if (get()) {
                            status.setText("Added!");
                        }
                    } catch (Exception ex) {
                        status.setText("Error: " + ex.getMessage());
                    }
                }
            }.execute();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
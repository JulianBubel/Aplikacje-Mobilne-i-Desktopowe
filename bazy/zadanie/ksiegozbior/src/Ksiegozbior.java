import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;

public class Ksiegozbior extends JFrame {
    JTable table;
    DefaultTableModel mod;
    JTextField Tytul, Autor, Rok_wydania;
    Connection conn;

    public Ksiegozbior() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ksiegozbior?useSSL=false&serverTimezone=UTC",
                    "root", ""
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "BŁĄD POŁĄCZENIA: " + e.getMessage());
        }

        mod = new DefaultTableModel(new String[]{"ID","Tytuł","Autor","Rok_wydania"},0);
        table = new JTable(mod);

        Tytul = new JTextField(10);
        Autor = new JTextField(10);
        Rok_wydania = new JTextField(5);

        JButton btnDodaj = new JButton("Dodaj");
        JButton btnUsun = new JButton("Usuń");
        JButton btnAkt = new JButton("Aktualizuj");

        btnDodaj.addActionListener(e -> dodaj());
        btnUsun.addActionListener(e -> usun());
        btnAkt.addActionListener(e -> aktualizuj());

        JPanel p = new JPanel();
        p.add(Tytul); p.add(Autor); p.add(Rok_wydania);
        p.add(btnDodaj); p.add(btnUsun); p.add(btnAkt);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(p, BorderLayout.SOUTH);

        setSize(600,400);
        setVisible(true);
        odswiez();
    }

    void odswiez() {
        mod.setRowCount(0);
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ksiazki");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                mod.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("tytul"),
                        rs.getString("autor"),
                        rs.getInt("rok_wydania")
                });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void dodaj() {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO ksiazki(tytul, autor, rok_wydania) VALUES(?,?,?)"
            );
            ps.setString(1, Tytul.getText());
            ps.setString(2, Autor.getText());
            ps.setInt(3, Integer.parseInt(Rok_wydania.getText()));
            ps.executeUpdate();
            odswiez();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void usun() {
        int r = table.getSelectedRow();
        if (r < 0) return;
        int id = (int) mod.getValueAt(r, 0);
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM ksiazki WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            odswiez();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void aktualizuj() {
        int r = table.getSelectedRow();
        if (r < 0) return;
        int id = (int) mod.getValueAt(r, 0);
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE ksiazki SET tytul=?, autor=?, rok_wydania=? WHERE id=?"
            );
            ps.setString(1, Tytul.getText());
            ps.setString(2, Autor.getText());
            ps.setInt(3, Integer.parseInt(Rok_wydania.getText()));
            ps.setInt(4, id);
            ps.executeUpdate();
            odswiez();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Ksiegozbior();
    }
}

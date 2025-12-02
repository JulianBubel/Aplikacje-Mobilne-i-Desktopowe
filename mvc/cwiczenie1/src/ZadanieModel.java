import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZadanieModel {
    private Connection connection;

    public ZadanieModel() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/todo?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "";

            connection = DriverManager.getConnection(url, user, password);

            createTableIfNotExists();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists() throws SQLException {
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS zadania (
                id INT AUTO_INCREMENT PRIMARY KEY,
                tresc VARCHAR(255) NOT NULL,
                status BOOLEAN NOT NULL DEFAULT FALSE
            )
        """;

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
        }
    }

    public void dodajZadanie(String tresc) {
        String sql = "INSERT INTO zadania (tresc, status) VALUES (?, false)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tresc);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void usunZadanie(int id) {
        String sql = "DELETE FROM zadania WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Zadanie> pobierzWszystkieZadania() {
        List<Zadanie> lista = new ArrayList<>();

        String sql = "SELECT * FROM zadania ORDER BY id ASC";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String tresc = rs.getString("tresc");
                boolean status = rs.getBoolean("status");
                lista.add(new Zadanie(id, tresc, status));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void zamienStatus(int id) {
        String sql = "UPDATE zadania SET status = NOT status WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

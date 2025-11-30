import java.sql.*;

public class SklepApp {
    private static final String URL = "jdbc:mysql://localhost:3306/sklep";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Zmień na swoje hasło

    public static void main(String[] args) {

        // 1. Wstawianie danych
        String sqlInsert = "INSERT INTO produkty (nazwa, cena) VALUES ('Kawa', 19.99)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            int rowsAffected = stmt.executeUpdate(sqlInsert);
            System.out.println("Wstawiono " + rowsAffected + " produkt(y).");

            // 2. Odczyt danych
            czytajProdukty(conn);

        } catch (SQLException e) {
            System.err.println("Błąd bazy danych: " + e.getMessage());
        }
    }

    private static void czytajProdukty(Connection conn) throws SQLException {
        String sqlSelect = "SELECT id, nazwa, cena FROM produkty";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlSelect)) {

            System.out.println("\n--- Lista Produktów ---");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nazwa = rs.getString("nazwa");
                double cena = rs.getDouble("cena");
                System.out.printf("ID: %d | Nazwa: %s | Cena: %.2f%n", id, nazwa, cena);
            }
            System.out.println("-----------------------");
        }
    }
}
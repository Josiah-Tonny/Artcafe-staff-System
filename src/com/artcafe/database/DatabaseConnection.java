import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String SUPABASE_URL = "your_supabase_url";
    private static final String SUPABASE_KEY = "your_supabase_key";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(SUPABASE_URL, SUPABASE_KEY, "");
    }
}

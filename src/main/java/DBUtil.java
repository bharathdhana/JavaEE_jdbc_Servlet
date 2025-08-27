import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection;
        connection = DriverManager.getConnection("jdbc:mysql-744eeba-bharathdhanavan2612-cb02.b.aivencloud.com", "avnadmin", "{AVNS_ceFEcw6rbutZvpVoxgG}");
        return connection;
    }
}

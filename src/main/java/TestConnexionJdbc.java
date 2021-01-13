import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class TestConnexionJdbc {
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/compta";
    private static final String DB_USER = "root";
    private static final String DB_PWD = "";
    public static void main(String[] args) {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle( "db" );
            //Class.forName("org.mariadb.jdbc.Driver");
            Connection connexion = DriverManager.getConnection(bundle.getString("db.url"), bundle.getString("db.user"), bundle.getString("db.password"));
            System.out.println(connexion);
            connexion.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}






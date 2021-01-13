import java.sql.*;
import java.util.ResourceBundle;

public class TestDelete {
    private static void deleteUserWithResources() {

        ResourceBundle bundle = ResourceBundle.getBundle( "db" );
        try (Connection connection = DriverManager
                .getConnection( bundle.getString( "db.url" ), bundle.getString( "db.user" ), bundle
                        .getString( "db.password" ));
             Statement st = connection.createStatement();
        ) {
            int nb = st.executeUpdate( "DELETE FROM FOURNISSEUR where ID = 4" );
            System.out.println(nb);
        } catch ( SQLException e ) {
            e.printStackTrace();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        System.out.println("fin");
    }

    public static void main( String[] args ) {
        deleteUserWithResources();
    }
}

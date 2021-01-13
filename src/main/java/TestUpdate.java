import java.sql.*;
import java.util.ResourceBundle;

public class TestUpdate {
    private static void updateUserWithResources() {

        ResourceBundle bundle = ResourceBundle.getBundle( "db" );
        try (Connection connection =DriverManager
                .getConnection( bundle.getString( "db.url" ), bundle.getString( "db.user" ), bundle
                        .getString( "db.password" ));
             Statement st = connection.createStatement();
        ) {
            int nb = st.executeUpdate( "UPDATE FOURNISSEUR SET NOM = 'LA MAISON DES PEINTURES' where ID = 4" );
            System.out.println(nb);
        } catch ( SQLException e ) {
            e.printStackTrace();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        System.out.println("fin");
    }

    public static void main( String[] args ) {
        updateUserWithResources();
    }
}

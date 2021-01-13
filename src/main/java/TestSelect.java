import java.sql.*;
import java.util.ResourceBundle;
import java.util.ArrayList;

public class TestSelect {

    private static ResultSet selectUserWithResources() {

        ResourceBundle bundle = ResourceBundle.getBundle( "db" );
        try (Connection connection = DriverManager
                .getConnection( bundle.getString( "db.url" ), bundle.getString( "db.user" ), bundle
                        .getString( "db.password" ));
             Statement st = connection.createStatement();
        ) {
            ResultSet nb = st.executeQuery( "SELECT * FROM FOURNISSEUR" );
            System.out.println(nb);
            return nb;
        } catch ( SQLException e ) {
            e.printStackTrace();
            return null;
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main( String[] args ) {

        ResultSet nb = selectUserWithResources();

        ArrayList<Fournisseur> ListeFour = new ArrayList<Fournisseur>();

        try {
            while(nb.next()) {
            ListeFour.add( new Fournisseur( nb.getInt(1) , nb.getString(2) ) );
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println(ListeFour);
    }
}

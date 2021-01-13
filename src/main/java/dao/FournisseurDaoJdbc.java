package dao;

import entities.Fournisseur;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class FournisseurDaoJdbc implements FournisseurDao {

    private static FournisseurDaoJdbc single;

    public static FournisseurDaoJdbc getSingle() {
        if ( null == single ) {
            single = new FournisseurDaoJdbc();
        }
        return single;
    }

    @Override
    public List<Fournisseur> extraire() {
        List<Fournisseur> result = new ArrayList<>();

        try {
            PreparedStatement statement = DBConnection.getSingle().getConnection().prepareStatement("SELECT * FROM fournisseur");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Fournisseur fournisseur = new Fournisseur(resultSet.getInt("id"), resultSet.getString("nom"));
                result.add(fournisseur);
            }
        } catch (SQLException e) {
            result = null;
            System.out.println("Une erreur est survenue : " + e.getStackTrace());
        }

        return result;
    }

    @Override
    public void insert(Fournisseur fournisseur) {
        try {
            PreparedStatement st = DBConnection.getSingle().getConnection().prepareStatement("INSERT INTO fournisseur VALUES (?, ?)");
            st.setInt(1, fournisseur.getId());
            st.setString(2, fournisseur.getNom());
            st.executeQuery();
        } catch (SQLException e){
            System.out.println("Une erreur est survenue lors de l'insertion en base de "+ fournisseur.toString() +" : " + e.getMessage());
        }
    }

    @Override
    public int update(String old_name, String new_name) {
        int result = 0;

        try {
            PreparedStatement st = DBConnection.getSingle().getConnection().prepareStatement("UPDATE fournisseur SET NOM = ? WHERE NOM = ?");
            st.setString(1, new_name);
            st.setString(2, old_name);
            st.executeQuery();
            result = 1;
        } catch (SQLException e){
            System.out.println("Une erreur est survenue lors de la mise a jour en base : " + e.getStackTrace());
        }

        return result;
    }

    @Override
    public boolean delete(Fournisseur fournisseur) {
        boolean result = false;

        try {
            PreparedStatement st = DBConnection.getSingle().getConnection().prepareStatement("DELETE FROM fournisseur WHERE NOM = ? AND ID = ?");
            st.setString(1, fournisseur.getNom());
            st.setInt(2, fournisseur.getId());
            st.executeQuery();
            result = true;
        } catch (SQLException e){
            System.out.println("Une erreur est survenue lors de la suppression : " + e.getStackTrace());
        }

        return result;
    }
}

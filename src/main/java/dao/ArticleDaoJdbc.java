package dao;

import entities.Article;
import entities.Fournisseur;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

public class ArticleDaoJdbc implements ArticleDao {
    private static ArticleDaoJdbc single; // single?

    public static ArticleDaoJdbc getSingle(){
        if ( null == single ) {
            single = new ArticleDaoJdbc();
        }
        return single;
    }

    @Override
    public List<Article> extract() {
        List<Article> result = new ArrayList<>();
        Fournisseur fournisseur;

        try {
            PreparedStatement statement = DBConnection.getSingle().getConnection().prepareStatement( "SELECT * FROM ARTICLE" );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Optional<Fournisseur> fou = FournisseurDaoJdbc.getSingle().findById(resultSet.getInt("id"));
                Article article = new Article(resultSet.getInt("id" ), resultSet.getString( "ref" ), resultSet.getString( "designation" ), resultSet.getFloat("prix"), fournisseur)
                result.add(article);
            }
        } catch (SQLException e) {
            result = null;
            System.out.println("An error has occured : " + e.getStackTrace());
        }

        return result;
    }

    @Override
    public void insert(Article article) {
        try{
            PreparedStatement st = DBConnection.getSingle().getConnection().prepareStatement( "INSERT INTO ARTICLE VALUES (?, ?, ?, ?, ?)" );
            st.setInt(1, article.getId());
            st.setString(2, article.getRef());
            st.setString(3, article.getDesignation());
            st.setFloat(4, article.getPrice());
            st.setInt(5, article.getFournisseur().getId());

        } catch (SQLException e){
            System.out.println("Une erreur est survenue lors de l'insertion en base de "+ article.toString() +" : " + e.getMessage());
        }
    }

    @Override
    public boolean update(String old_designation, String new_designation) {
        boolean result = false;

        try{
            PreparedStatement st = DBConnection.getSingle().getConnection().prepareStatement( "UPDATE ARTICLE SET DESIGNATION = ? WHERE DESIGNATION = ?" );
            st.setString(1, old_designation);
            st.setString(2, new_designation);
            st.executeQuery();
            result = true;
        } catch (SQLException e){
            System.out.println("Une erreur est survenue lors de la mise a jour en base : " + e.getStackTrace());
        }

        return result;
    }

    @Override
    public boolean delete(Article article) {
        boolean result = false;

        try {
            PreparedStatement st = DBConnection.getSingle().getConnection().prepareStatement( "DELETE FROM fournisseur WHERE ID = ?" );
            st.setInt(1, article.getId());
            st.executeQuery();
            result = true;
        } catch (SQLException e){
            System.out.println("Une erreur est survenue lors de la suppression : " + e.getStackTrace());
        }

        return result;
    }
}

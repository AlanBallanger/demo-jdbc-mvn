package dao;

import entities.Article;

import java.util.List;

public interface ArticleDao {

    List<Article> extract();
    void insert(Article article);
    boolean update(String old_designation, String new_designation);
    boolean delete(Article article);

}



package dao;

import entities.Fournisseur;

import java.util.List;

public interface FournisseurDao {

    List<Fournisseur> extraire();
    void insert(Fournisseur fournisseur);
    int update(String old_name, String new_name);
    boolean delete(Fournisseur fournisseur);

}


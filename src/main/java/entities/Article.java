package entities;

public class Article {
    private int id;
    private String ref;
    private String designation;
    private float price;
    private Fournisseur fournisseur;

    public Article (int id, String ref, String designation, float price, Fournisseur fournisseur){
        this.id = id;
        this.ref = ref;
        this.designation = designation;
        this.price = price;
        this.fournisseur = fournisseur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String name) {
        this.designation = designation;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(float price) {
        this.fournisseur = fournisseur;
    }



    @Override
    public String toString(){
        return this.getName() + " (" + this.getId() + ")";
    }
}

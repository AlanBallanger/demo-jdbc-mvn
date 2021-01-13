public class Fournisseur {
    int ID;
    String Nom;
    public  Fournisseur(int ID, String Nom) {
        this.ID = ID;
        this.Nom = Nom;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fournisseur{");
        sb.append("ID=").append(ID);
        sb.append(", Nom='").append(Nom).append('\'');
        sb.append('}');
        return sb.toString();
    }}

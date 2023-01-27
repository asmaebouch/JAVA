package presentation.model;


import java.util.Objects;

public class Utilisateur {
    public static long compteur = 1;
    protected Long id;
    protected String prenom, nom;
    protected String login, motDePasse, role;


    public Long         getId() {
        return id;
    }
    public void         setId(Long id) {
        this.id = compteur++;
    }
    public long getCompteur(){return compteur;}
    public void setId2(Long id){this.id=id;}
    public String       getNomComplet() {
        return prenom + " " + nom;
    }
    public String       getNom() {
        return nom;
    }
    public String       getPrenom() {
        return prenom;
    }
    public void         setNom(String nom) {
        this.nom = nom;
    }
    public void         setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getLogin() {
        return login;
    }
    public String getMotDePasse() {
        return motDePasse;
    }
    public String getRole() {
        return role;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public  Utilisateur(){setId(id);}

    public  Utilisateur(String login, String pass, String role){
        setId(id);
        this.login          = login;
        this.motDePasse     = pass;
        this.role           = role;
    }
    public boolean isValid(String lg, String pass) {

        return login.equals(lg) && motDePasse.equals(pass);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(id, that.id);
    }
            /* public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(nom, that.nom);
    }*/
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

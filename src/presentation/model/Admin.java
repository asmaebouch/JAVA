package presentation.model;

public class Admin  extends Utilisateur {

    private static Admin ADMIN = new Admin();

    public Admin() {

        login = "admin";
        motDePasse = "1234";
        role = "Admin";
        nom = "Admin";
        prenom = "Omar";

    }

    public static Admin getInstance() {

        return ADMIN;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Utilisateur)
            return this.getLogin().equals(((Utilisateur) obj).getLogin()) && this.getMotDePasse().equals(((Utilisateur) obj).getMotDePasse()) && this.getRole().equals(((Utilisateur) obj).getRole())&& this.getNom().equals(((Utilisateur)obj).getRole()) && this.getPrenom().equals(((Utilisateur)obj).getPrenom());
        else {
            return false;
        }
    }
}




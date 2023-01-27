package presentation.model;

public class Admin  extends Utilisateur {

    private static Admin ADMIN = new Admin();

    public Admin() {

        login = "admin";
        motDePasse = "1234";
        role = "Admin";
        nom = "Prof";
        prenom = "Omar";

    }

    public static Admin getInstance() {

        return ADMIN;
    }

    public boolean isValid(String lg, String pass) {
        return login.equals(lg) && motDePasse.equals(pass);
    }
}




package metier.authetification;

import metier.Verifiable;
import presentation.model.Admin;
import presentation.model.Banque;
import presentation.model.Client;
import presentation.model.Utilisateur;

import java.util.Scanner;

public class Authentificationconsole implements IAuth {
    public String login;
    public String password;
    Verifiable v = new Verifiable() {
        @Override
        public Admin isAdmin(String lg, String pass, Banque bq) {
            Admin admin = Admin.getInstance();
            if (admin.isValid(lg, pass)) {
                return admin;
            } else {
                return null;
            }
        }
    };
    Verifiable v2 = new Verifiable() {
        @Override
        public boolean isClient(String lg, String pass , Banque bq){
            return bq.getClientsDeBanque().stream()
                    .anyMatch(client -> client.getLogin().equals(lg) && client.getMotDePasse().equals(pass));
        }

    };

    private static Banque bg=new Banque();
    Admin admin = new Admin();


    public Authentificationconsole(Banque b1){this.bg=b1;}
    @Override
    public String seConnecter() {
        Utilisateur U = new Utilisateur();
        Scanner clavier = new Scanner(System.in);
        System.out.println("*****************************************");
        System.out.println("**********  FORMULAIRE DE LOGIN *********");
        System.out.println("*****************************************");

        System.out.println("| Login d'utilisateur  : ");
        String Login = clavier.next();
        U.setLogin(Login);
        System.out.println("| Mot de passe         : ");
        String password = clavier.next();
        U.setMotDePasse(password);
        System.out.println("| Administrateur(oui/non)  : ");
        String prenom = clavier.next();
        U.setPrenom(prenom);
        System.out.println("*****************************************");
        //Client client=new Client(Login,password);

        if (v.isAdmin(Login, password, bg) != null && v.isAdmin(Login, password, bg).isValid(Login, password) && prenom.equals("oui")) {
            return "admin";
        }

      else if (v2.isClient(Login,password,bg)) {

            return "client";
        } else {

            return "erreur";
        }

    }

    @Override
    public void SeDéconnecter() {
        login = "";
        password = "";
        System.out.println("You have been logged out.");
    }


}

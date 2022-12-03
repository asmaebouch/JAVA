package metier.authetification;

import presentation.model.Admin;
import presentation.model.Banque;
import presentation.model.Client;
import presentation.model.Utilisateur;

import java.util.Scanner;

public class Authentificationconsole implements IAuth {
    private static Banque banque=new Banque();
    Admin admin = new Admin();
    Client client = new Client();
    public Authentificationconsole(Banque b1){this.banque=b1;}
    @Override
    public String seConnecter() {
        Utilisateur U = new Utilisateur();
        Scanner clavier = new Scanner(System.in);
        System.out.println("Insere votre Login : ");
        String Login = clavier.next();
        U.setLogin(Login);
        System.out.println("Insere votre mot de pass : ");
        String password = clavier.next();
        U.setMotDePasse(password);
        System.out.println("Insere votre role : ");
        String role = clavier.next();
        System.out.println("Insere votre nom : ");
        String nom = clavier.next();
        U.setNom(nom);
        System.out.println("Insere votre prenom : ");
        String prenom = clavier.next();
        U.setPrenom(prenom);
        U.setRole(role);
        if (admin.equals(U)) {
           return U.getRole();
        }

        else {
         return "erreur";
        }
    }

    @Override
    public void SeDéconnecter() {

    }
}
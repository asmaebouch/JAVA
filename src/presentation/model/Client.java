package presentation.model;

import presentation.model.Compte;
import presentation.model.Sexe;
import presentation.model.Utilisateur;

import java.util.*;
import java.util.regex.Pattern;


public class Client extends Utilisateur {
    private String email, cin, tel;
    private Sexe sexe;
    private List<Compte> comptesClient;


    public String       getCin() {
        return cin;
    }
    public String       getTel() {
        return tel;
    }
    public String       getEmail() {
        return email;
    }
    public List<Compte> getComptesClient() {
        return comptesClient;
    }
    public Sexe getSexe() {
        return sexe;
    }
    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }
    public void         setEmail(String email) {
        this.email = email;
    }
    public void         setTel(String tel) {
        this.tel = tel;
    }
    public void         setCin(String cin) {
        this.cin = cin;
    }
    public void         setComptesClient(List<Compte> comptesClient) {
        this.comptesClient = comptesClient;
    }

    public Client(){

        comptesClient = new ArrayList<>();
    }

    public Client(String login, String pass){
        super(login, pass, "Client");
        comptesClient = new ArrayList<>();
    }

    public Client(String login, String pass, String n, String p){
        super(login, pass, "Client");
        setNom(n);
        setPrenom(p);
        comptesClient = new ArrayList<>();
    }
    public Client(String login, String pass, String n, String p, String mail, String cin, String tel, Sexe sexe) {
        super(login, pass, "Client");
        setNom(n);
        setPrenom(p);
        setTel(tel);
        setEmail(mail);
        setCin(cin);
        setSexe(sexe);
        comptesClient = new ArrayList<Compte>();
    }
    public static String valEmail(String input) {
        if (input == null || input.isEmpty()) {
            return "Invalid";
        }
        String emailReegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9]+\\.)+[a-zA-Z]{2,7}$";
        Pattern emailPat = Pattern.compile(emailReegex);
        if (emailPat.matcher(input).matches()) {
            return input;
        } else {
            return "Invalid";
        }

    }
    public void Ajouter(Compte e){
        this.comptesClient.add(e);
    }
    public String afficherCompte(){
        for (Compte c:comptesClient) {
            return c.toString();
        }
        return comptesClient.toString();
    }
    @Override
    public String toString() {
        String      clientStr  = "------------------------------------------------------\n";
        clientStr += afficherCompte();
        clientStr += "| Identifiant du Client     : "   + this.id        + "\n";
        clientStr += "| Nom Complet               : "   + this.getNomComplet() + "\n" ;
        clientStr += "| Adresse email             : "   + this.email     + "\n" ;
        clientStr += "| Numéro téléphone          : "   + this.tel       + "\n" ;
        clientStr += "| Numéro de CIN             : "   + this.cin       + "\n" ;
        clientStr += "------------------------------------------------------\n";
        return clientStr;
    }
   /*     public static void main(String[] args) {
        Compte e=new Compte(300.0);
        Compte e1=new Compte(300.0);
        Client client=new Client("aaaa","aaa","aaaaa","aaaa","aaaaa","aaa","aaa",Sexe.HOMME);
        client.Ajouter(e);
        Client client2=new Client("zzzz","zzzzzz","rrrrr","rrrrr","rrrrr","ttt","tttt",Sexe.HOMME);
        client2.Ajouter(e1);
        System.out.println(client.toString());
        System.out.println(client2.toString());
    }*/


}

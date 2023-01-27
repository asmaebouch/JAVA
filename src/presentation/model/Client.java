package presentation.model;

import presentation.model.Compte;
import presentation.model.Sexe;
import presentation.model.Utilisateur;

import java.util.*;
import java.util.regex.Pattern;


public class Client extends Utilisateur implements AffichageInfos {
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
    public Client(Long id,String login, String pass, String n, String p, String mail, String cin, String tel, Sexe sexe) {
       // super(login, pass, "Client");
        setId2(id);
        setNom(n);
        setPrenom(p);
        setTel(tel);
        setEmail(mail);
        setCin(cin);
        setSexe(sexe);
        setLogin(login);
        setMotDePasse(pass);
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

    @Override
    public boolean equals(Object o) {
        if (o instanceof Utilisateur)
            return this.getLogin().equals(((Utilisateur) o).getLogin()) && this.getMotDePasse().equals(((Utilisateur) o).getMotDePasse()) ;
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        String      clientStr  = "------------------------------------------------------\n";
        clientStr += "| Identifiant du Client     : "   + this.id        + "\n";
        clientStr += "| Nom Complet               : "   + this.getNomComplet() + "\n" ;
        clientStr += "| Adresse email             : "   + this.email     + "\n" ;
        clientStr += "| Numéro téléphone          : "   + this.tel       + "\n" ;
        clientStr += "| Numéro de CIN             : "   + this.cin       + "\n" ;
        clientStr += "------------------------------------------------------\n";
        return clientStr;
    }
    @Override
    public void afficherBref() {
        String      clientStr  = "------------------------------------------------------\n";
        clientStr += "| Identifiant du Client     : "   + this.id        + "\n";
        clientStr += "| Nom Complet               : "   + this.getNomComplet() + "\n" ;
        System.out.println(clientStr);
        System.out.println("-------------------------------------------------------------------");
    }
    @Override
    public void afficherLesLogs() {
        for (Compte c:comptesClient) {
             c.afficherLesLogs();
        }
    }

    @Override
    public void afficherInformations() {
        System.out.println("-------------------------------------------------------------------");
        System.out.println(toString());
        for (Compte c:comptesClient) {c.afficherBref();}
        System.out.println("-------------------------------------------------------------------");

    }

    @Override
    public void afficherInformationsDétaillées() {
        afficherLesLogs();
        afficherInformations();
    }



}

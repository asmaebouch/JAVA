package presentation.model;

import metier.Verifiable;

import java.util.*;

public class Banque implements AffichageInfos{

    public static long          compteur = 1;
    private Long                 idBanque;
    private String              nomBanque;
    private String              adresseBanque;
    private String              telBanque;
    private String              emailBanque;
    private List<Client> clientsDeBanque = new ArrayList<>();

    public Banque()
    {
        idBanque = compteur++;
    }
    public Banque(String nom, String adresse, String tel, String mail)
    {
        idBanque        = compteur++;
        nomBanque       = nom;
        telBanque       = tel;
        adresseBanque   = adresse;
        emailBanque     = mail;
    }

    public Long             getIdBanque() {
        return idBanque;
    }
    public String           getNomBanque() {
        return nomBanque;
    }
    public String           getEmailBanque() {
        return emailBanque;
    }
    public String           getTelBanque() {
        return telBanque;
    }
    public String           getAdresseBanque() {
        return adresseBanque;
    }
    public List<Client>     getClientsDeBanque() {
        return clientsDeBanque;
    }

    public void             setIdBanque(Long idBanque) {
        this.idBanque = idBanque;
    }
    public void             setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }
    public void             setEmailBanque(String emailBanque) {
        this.emailBanque = emailBanque;
    }
    public void             setAdresseBanque(String adresseBanque) {
        this.adresseBanque = adresseBanque;
    }
    public void             setTelBanque(String telBanque) {
        this.telBanque = telBanque;
    }
    public void             setClientsDeBanque(List<Client> clientsDeBanque) {
        this.clientsDeBanque = clientsDeBanque;
    }
    public void  ajouter(Client client){
    clientsDeBanque.add(client);
}


    @Override
    public String toString() {
        return "Nom de la banque : "+nomBanque+
                " { Id  banque=" + idBanque +
                ", Adresse Banque='" + adresseBanque + '\'' +
                ", Tel Banque='" + telBanque + '\'' +
                ", Email Banque='" + emailBanque + '\'' +
                ", \nClients De Banque= \n" + clientsDeBanque + "\n"+
                '}';
    }

    @Override
    public void afficherBref() {
        System.out.println("Nom de la banque : "+nomBanque+
                           " { Id  banque=" + idBanque+" }");
    }

    @Override
    public void afficherLesLogs() {
        for (Client client:clientsDeBanque) {
            client.afficherLesLogs();
        }
    }

    @Override
    public void afficherInformations() {
        System.out.println(toString());
        for (Client client:clientsDeBanque) {
            client.afficherInformations();
        }
    }

    @Override
    public void afficherInformationsDétaillées() {
        afficherInformations();
        afficherLesLogs();
    }


    /*  public void afficherclient(){
        for (Client client:clientsDeBanque) {
            System.out.println(client.toString());
        }
    }*/

}

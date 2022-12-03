package presentation.model;

import java.util.*;

public class Banque {

    private static long          compteur = 1;
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
    public void  add(Client client){
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
  /*  public void afficherclient(){
        for (Client client:clientsDeBanque) {
            System.out.println(client.toString());
        }
    }*/

    public static void main(String[] args) {
        Banque banque=new Banque("alakhdar","aaaaa","aaaaa","aaaaaa");
            Compte e=new Compte(300.0);
            Compte e1=new Compte(300.0);
            Client client=new Client("aaaa","aaa","aaaaa","aaaa","aaaaa","aaa","aaa",Sexe.HOMME);
            client.Ajouter(e);
            Client client2=new Client("zzzz","zzzzzz","rrrrr","rrrrr","rrrrr","ttt","tttt",Sexe.HOMME);
            client2.Ajouter(e1);
            banque.add(client);
            banque.add(client2);
            System.out.println(banque.toString());

    }
}

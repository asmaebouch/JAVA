package metier.clients;

import presentation.model.Banque;
import presentation.model.Client;
import presentation.model.Compte;
import presentation.model.TypeLog;

import java.util.Scanner;

public class ServiceClient implements IServiceClient{
    Banque banque=new Banque();
    ServiceClient(){}
    public ServiceClient(Banque banque1){
        this.banque=banque1;
    }
    @Override
    public boolean versement() {
        Scanner clavie = new Scanner(System.in);
        Float mantant;
        while (true) {
            System.out.println("Donnez le mantant a verser  ");

            try {
                mantant = Float.parseFloat(clavie.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int or float value!");
            }
        }
        Long idCompte;
        while (true) {
            System.out.println("Donnez le ID DE COMPTE   ");
            try {
                idCompte = Long.valueOf(clavie.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int or float value!");
            }
        }
        for (Client j : banque.getClientsDeBanque())
            for (Compte c : j.getComptesClient())
                if (c.getNumeroCompte().equals(idCompte)) {
                    c.setSolde(c.getSolde() + mantant);
                    c.setLog(TypeLog.valueOf("VERSEMENT"), "mantant" + mantant);
                    c.afficherInformationsDétaillées();
                    System.out.println("Versement est terminer!!!!!!!!!!!");
                    return true;
                }
                     return false;
    }

    @Override
    public boolean retrait() {
        Scanner clavie = new Scanner(System.in);
        Float  mantant;
        while (true) {
            System.out.println("Donnez le mantant a retirer  ");

            try {
                mantant = Float.parseFloat(clavie.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int or float value!");
            }
        }
        Long idCompte;
        while (true) {
            System.out.println("Donnez le ID DE COMPTE   ");
            try {
                idCompte = Long.valueOf(clavie.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int or float value!");
            }
        }
        for (Client j : banque.getClientsDeBanque())
            for (Compte c : j.getComptesClient())
                if (c.getNumeroCompte().equals(idCompte)) {
                   c.setSolde(c.getSolde()-mantant);
                    c.setLog(TypeLog.valueOf("RETRAIT"), "mantant" + mantant);
                    c.afficherInformationsDétaillées();
                    System.out.println("Traitement est terminer!!!!!!!!!!!");
                    return true;
                        }
                 return false;
    }

    @Override
    public boolean retrait(int choixRetrait) {
        return false;
    }

    @Override
    public boolean virement() {
        Scanner clavie = new Scanner(System.in);
        Float montant;
        while (true) {
            System.out.println("Donnez le mantant pour faire le virement  ");
            try {
                montant = Float.parseFloat(clavie.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int or float value!");
            }
        }
        Long idCompte;
        while (true) {
            System.out.println("Donnez le ID DE COMPTE 1  ");
            try {
                idCompte = Long.valueOf(clavie.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int or float value!");
            }
        }
        Double c1;
        for (Client j : banque.getClientsDeBanque())
            for (Compte c : j.getComptesClient())
                if (c.getNumeroCompte().equals(idCompte)) {
                        if ( c.getSolde()> montant) {
                            c.setSolde(c.getSolde()-montant);
                        }}


        Long idCompte2;
        while (true) {
            System.out.println("Donnez le ID DE COMPTE 2  ");
            try {
                idCompte2 = Long.valueOf(clavie.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int or float value!");
            }
        }
        for (Client j : banque.getClientsDeBanque())
            for (Compte c : j.getComptesClient())
                if (c.getNumeroCompte().equals(idCompte2)) {
               c.setSolde(c.getSolde()+montant);
               c.setLog(TypeLog.valueOf("VIRSEMENT"),"montant"+montant);
                    c.afficherInformationsDétaillées();
                    System.out.println("Versement est terminer!!!!!!!!!!!");
                    return true;
                    }
                return false;
    }

    @Override
    public boolean modifierProfile(String choixModification) {
        System.out.println(" -------Modify Client ----------- : ");
        String choix;
        Client clie = new Client();
        Scanner clavier = new Scanner(System.in);
        choix = clavier.next();
        label:
        for (Client j : banque.getClientsDeBanque()) {
                switch (choix) {
                    case "nom":
                        System.out.println("Vous pouvez donner le nouveaux nom");
                        String nom = clavier.next();
                        j.setNom(nom);
                        System.out.println(j.toString());
                        break label;
                    case "prenom":
                        System.out.println("Vous pouvez donner le nouveaux prenom");
                        String prenom = clavier.next();
                        j.setPrenom(prenom);
                        System.out.println(j.toString());
                        break label;
                    case "email":
                        System.out.println("Vous pouvez donner le nouveaux email ");
                        String email = clavier.next();
                        j.setEmail(email);
                        System.out.println(j.toString());
                        break label;
                    case "cin":
                        System.out.println("Vous pouvez donner le nouveaux cin ");
                        String cin=clavier.next();
                        j.setCin(cin);
                        System.out.println(j.toString());
                        break label;
                    case "tel":
                        System.out.println("Vous pouvez donner le nouveaux telephone");
                        String tel=clavier.next();
                        j.setTel(tel);
                        System.out.println(j.toString());
                        break label;
                }
                clie = j;
                // System.out.println("exist client");
                System.out.println(j.toString());
                break;
        }
        System.out.println("Au revoir !!!!!!!!");
        return true;
    }

    @Override
    public void dernièresOpérations() {
    }

    @Override
    public Double afficherSolde() {
        return null;
    }

    @Override
    public Compte choisirCompte() {
        return null;
    }

    @Override
    public void afficherTicket() {

    }
}

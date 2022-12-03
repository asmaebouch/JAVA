package metier.clients;

import presentation.model.Banque;
import presentation.model.Client;
import presentation.model.Compte;
import presentation.model.TypeLog;

import java.util.Scanner;

public class ServiceClient implements IServiceClient{
    Banque banque=new Banque();
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
    public boolean modifierProfile(int choixModification) {
        System.out.println(" -------Modify Client ----------- : ");
        String choix;
        Client clie = new Client();
        Scanner clavier = new Scanner(System.in);
        Long idClient;
        while (true) {
            System.out.println("Donnez l'id de compte ");
            try {
                idClient = Long.valueOf((clavier.next()));
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int  value!");
            }
        }
        System.out.println("vous voulez Modifier le nom/prenom/email? ");
        choix = clavier.next();
        for (Client j : banque.getClientsDeBanque()) {
            if (j.getId().equals(idClient)) {
                if (choix.equals("nom")) {
                    System.out.println("Vous pouvez donner le nouveaux nom");
                    String nom = clavier.next();
                    j.setNom(nom);
                    System.out.println(j.toString());
                    break;
                } else if (choix.equals("prenom")) {
                    System.out.println("Vous pouvez donner le nouveaux prenom");
                    String prenom = clavier.next();
                    j.setPrenom(prenom);
                    System.out.println(j.toString());
                    break;
                } else if (choix.equals("email")) {
                    System.out.println("Vous pouvez donner le nouveaux email ");
                    String email = clavier.next();
                    j.setEmail(email);
                    System.out.println(j.toString());
                    break;
                }
                clie = j;
                // System.out.println("exist client");
                System.out.println(j.toString());
                break;

            }

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

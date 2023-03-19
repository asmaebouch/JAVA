package metier.admin;

import metier.authetification.ServiceIHM;
import presentation.model.Banque;
import presentation.model.Client;

import java.time.LocalDateTime;
import java.util.Scanner;
import metier.authetification.Authentificationconsole;
public class ServiceIHMAdmin implements IServiceIHMAdmin {

    Scanner clavier = new Scanner(System.in);
    Banque banque = new Banque();
    ServiceAdmin serviceAdmin = new ServiceAdmin(banque);
    Authentificationconsole authentificationconsole=new Authentificationconsole(banque);
    ServiceIHM serviceIHM=new ServiceIHM(banque);
    ServiceIHMAdmin() {
    }

    public ServiceIHMAdmin(Banque banque1) {
        this.banque = banque1;
    }

    @Override
    public int menuModification() {

        String choice = "aaa";
        do {
            System.out.println("= Enter [nom]     if you want modify name of client            =");
            System.out.println("= Enter [prenom]  if you want modify last name of client       =");
            System.out.println("= Enter [email]   if you want modify email of client           =");
            System.out.println("= Enter [cin]     if you want modify cin of client             =");
            System.out.println("= Enter [tel]     if you want modify telephone of client       =");
            System.out.println("= Enter [exit]    exit                                         =");
            System.out.println("============================================================");

            Scanner keyboard = new Scanner(System.in);
            System.out.println("Entrer votre choix ");
            choice = keyboard.nextLine();
            switch (choice) {
                case "nom": {
                    serviceAdmin.modifierClient(choice);
                   break;
                }
                case "prenom": {
                    serviceAdmin.modifierClient(choice);
                    break;
                }
                case "email": {
                    serviceAdmin.modifierClient(choice);
                    break;
                }
                case "cin": {
                    serviceAdmin.modifierClient(choice);
                    break;
                }
                case "tel": {
                    serviceAdmin.modifierClient(choice);
                    break;
                }
                default:
                    System.out.println("Bad entry GoodBy !!!!!!!!!!");
                    break;

            }
        }while (choice =="exit");
        return 1;
    }

    @Override
    public int menuRecherche() {
        System.out.println("= Enter [nom] if you want serche name of client                   =");
        System.out.println("= Enter [prenom]  if you want serche last name of client          =");
        System.out.println("= Enter [email]  if you want serche email of client               =");
        System.out.println("= Enter [cin]  if you want serche cin of client                   =");
        System.out.println("= Enter [solde]  if you want serche telephone of client           =");
        System.out.println("= Enter [date creation]  if you want serche telephone of client   =");
        // System.out.println("= Enter [proprietaire]  if you want serche telephone of client    =");
        System.out.println("============================================================");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Entrer votre choix ");

        String choice = keyboard.nextLine();
        switch (choice) {
            case "nom": {
               // System.out.println("entrer le nom pour chercher ");
               // String nom =keyboard.next();
                serviceAdmin.chercherClientParNom();
              break;
            }
            case "prenom": {
                //System.out.println("entrer le prenom pour chercher ");
               // String nom = keyboard.next();
                serviceAdmin.chercherClientParPrénom();
                break;
            }
            case "email": {
              //  System.out.println("entrer le email pour chercher ");
                //String email =keyboard.next();
                serviceAdmin.chercherClientParEmail();
                break;
            }
            case "cin": {
                //System.out.println("entrer le cin pour chercher ");
               // String cin = keyboard.next();
                serviceAdmin.chercherClientParCin();
                break;
            }
            case "solde": {
               // System.out.println("entrer le cin pour chercher ");
                //double cin = Double.parseDouble(keyboard.next());
                serviceAdmin.chercherCompteParSolde();
                break;
            }
            case "date creation": {
                //System.out.println("entrer le cin pour chercher ");
              //  LocalDateTime date = LocalDateTime.parse(keyboard.next());
                serviceAdmin.chercherCompteParDateCreation();
                break;
            }

        }
        return 2;
    }

    @Override
    public int menuInformations() {
        System.out.println("= Enter [1] if you want consult  information bref of client       =");
        System.out.println("= Enter [2] if you want consult  information logs  of client      =");
        System.out.println("= Enter [3] if you want consult  informations of client           =");
        System.out.println("= Enter [4]  if you want consult  detail informations of client   =");
        System.out.println("= Enter [5]  if you want consult information bref of banque       =");
        System.out.println("= Enter [6]  if you want consult  informations of banque          =");
        System.out.println("= Enter [7]  if you want consult  datail information of banque     =");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Entrer votre choix ");

        Integer choice = Integer.valueOf(keyboard.nextLine());
        switch (choice) {
            case 1: {
                for (Client j : banque.getClientsDeBanque()) {
                    j.afficherBref();
                }
                break;
            }
            case 2: {
                banque.afficherLesLogs();
                break;

            }
            case 3: {
                for (Client j : banque.getClientsDeBanque()) {
                    j.afficherInformations();
                }
                break;

            }
            case 4: {
                for (Client j : banque.getClientsDeBanque()) {
                    j.afficherInformationsDétaillées();
                }
                break;

            }
            case 5: {
                banque.afficherBref();
                break;

            }
            case 6: {
                banque.afficherInformations();
                break;

            }
            case 7: {
                banque.afficherInformationsDétaillées();
                break;

            }
        }
        return 3;
    }
    @Override
    public int menuAjout() {
        String choice = "aaa";
        do {
            System.out.println("= Enter [client]  if you want add  client    =");
            System.out.println("= Enter [account] if you want add account    =");
            System.out.println("= Enter [exit]    exit                       =");
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Entrer votre choix ");
            choice = String.valueOf(keyboard.nextLine());
            switch (choice) {
                case "client": {
                    serviceAdmin.nouveauClient();
                    break;
                }
                case "account": {
                    serviceAdmin.nouveauCompteClientExistant();
                    break;
                }
                default:
                    System.out.println("Bad entry GoodBy !!!!!!!!!!");
                    break;

            }
        }while (choice=="exit");
        return 4;
    }

    @Override
    public int menuSuppression() {
        System.out.println("= Enter [client]  if you want delete  client    =");
        System.out.println("= Enter [account] if you want delete account    =");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Entrer votre choix ");
        String choice = String.valueOf(keyboard.nextLine());
        switch (choice) {
            case "client": {
               // Long idClient;
                //System.out.println("Entrer l 'id de client a supprime");
                //idClient = Long.valueOf(clavier.next());
                serviceAdmin.supprimerClient();
                break;
            }
            case "account": {
                Long idCompte;
                //System.out.println("Entrer l 'id de compte a supprime");
                //idCompte = Long.valueOf(clavier.next());
                serviceAdmin.supprimerClient();
                serviceAdmin.nouveauCompteClientExistant();
                break;
            }
        }
        return 5;
    }

    @Override
    public int tableauDeBord() {
        return 0;
    }

    @Override
    public int menuTrie() {
        System.out.println("= Enter [nom]     si vous voulez  trier client par nom      =");
        System.out.println("= Enter [cin]     si vous voulez trier client  par cin      =");
        System.out.println("= Enter [email]   si vous voulez trier client  par email    =");
        // System.out.println("= Enter [adresse] si vous voulez trier client  par adresse  =");
        System.out.println("= Enter [csolde]  si vous voulez trier client  par solde    =");
        System.out.println("= Enter [solde]   si vous voulez trier compte  par solde    =");
        Scanner keyboard = new Scanner(System.in);
        String choice = String.valueOf(keyboard.nextLine());
        switch (choice) {
            case "nom": {
               System.out.println(serviceAdmin.trierClientParNom());
               break;
            }
            case "cin": {
              System.out.println(serviceAdmin.trierClientParCin());
              break;
            }
            case "email": {
                System.out.println(serviceAdmin.trierClientParEmail());
                break;
            }
            case "csolde": {
               System.out.println(serviceAdmin.trierClientParSoldeCompte());
               break;
            }
            case "solde": {
               System.out.println(serviceAdmin.trierComptesParSolde());
               break;
            }
        }
        return 6;
    }

    @Override
    public int menuComptabilité() {
        Scanner keyboard = new Scanner(System.in);
        Integer choice = -1;
        do {
            System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=*");
            System.out.println("=*=>   M E N U CRUD                                      *=*");
            System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=*");
            System.out.println("=*=                                                      *=*");
            System.out.println("= Tapez [1] pour le [Menu de Recherche]                    =");
            System.out.println("= Tapez [2] pour le [Menu de Modification]                 =");
            System.out.println("= Tapez [3] pour le [Menu d'ajout]                         =");
            System.out.println("= Tapez [4] pour le [Menu de Suppression]                  =");
            System.out.println("= Tapez [5] pour retourner au menu global                  =");
            System.out.println("=*=>   M E N U CRUD                                      *=*");
            System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=*");
            System.out.println("=>Entrez votre choix : ");
            choice = Integer.valueOf(keyboard.nextLine());
            switch (choice) {
                case 1: {
                    menuRecherche();
                    break;
                }
                case 2: {
                    menuModification();
                    break;
                }
                case 3: {
                    menuAjout();
                    break;
                }
                case 4: {
                    menuSuppression();
                    break;
                }
                default:
                    System.out.println("Bad entry GoodBy !!!!!!!!!!");
                    break;

            }
        } while (choice != 5);

        return 6;
    }
    @Override
    public int menuGlobal() {
        Scanner keyboard = new Scanner(System.in);
        Integer choice=-1;
        do {
            System.out.println("= Tapez [1]   pour le [Service CRUD]                       =");
            System.out.println("= Tapez [2]   pour le [Service INFORMATION]                =");
            System.out.println("= Tapez [3]  pour le [Service TRIE]                        =");
            System.out.println("= Tapez [4]  pour se déconnecter                           =");
            System.out.println("=*=>   M E N U CRUD                                      *=*");
            System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=*");
            System.out.println("=>Entrer votre choix :  ");
            choice = Integer.valueOf(keyboard.nextLine());
            switch (choice) {
                case 1: {
                    menuComptabilité();
                    break;
                }
                case 2: {
                    menuInformations();
                    break;
                }
                case 3: {
                    menuTrie();
                    break;
                }
                case 4:{
                    authentificationconsole.SeDéconnecter();
                    serviceIHM.menuGlobal();
                    break;
                }
                default:
                    System.out.println("Bad entry GoodBy !!!!!!!!!!");
                    break;

            }
        } while (choice != 4);

        return 7;
    }
}

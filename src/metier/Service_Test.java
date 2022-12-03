package metier;
import metier.admin.ServiceAdmin;
import metier.authetification.Authentificationconsole;
import presentation.model.Admin;
import presentation.model.Banque;
import presentation.model.Client;

import java.util.Scanner;

public class Service_Test {
    //Service_Banque sb;
    public static void main(String[] args) {
        Banque banque = new Banque();
        ServiceAdmin S=    new ServiceAdmin(banque);
       // new Service_client(banque);

        Authentificationconsole A=new Authentificationconsole(banque);
        Scanner clavierr = new Scanner(System.in);
        for (; ; ) {
            if (A.seConnecter().equals("Admin") ){
                int i = -1;
                do {
                    System.out.println("------------------------------------------------------------\n ------- \t\tWelcom to you bank \t\t-------\n " +
                            "-----------------------------------------------------------------------");
                    System.out.println("= Entrer (1)    create and add new account             = \n ");
                    System.out.println("= Entrer (2)    create and add new client              = \n ");
                    System.out.println("= Entrer (3)    chercherClient par Prénom              = \n ");
                    System.out.println("= Entrer (4)    chercher un client par id              = \n ");
                    System.out.println("= Entrer (5)    chercher un client par Nom             = \n ");
                    System.out.println("= Entrer (6)    chercher client par cin                = \n ");
                    System.out.println("= Entrer (7)    trier client par nom                   = \n ");
                    System.out.println("= Entrer (8)    supprimer client                       = \n ");
                    System.out.println("= Entrer (9)   chercher Client Par Email               = \n ");
                    System.out.println("= Entrer (10)   modifier Client                        = \n ");
                    System.out.println("= Entrer (11)   calculer Et AfficherStatistiques()     = \n ");
                    System.out.println("= Entrer (12)    to exit                               = \n ");
                    System.out.println("------------------------------------------------------------- \n ");
                    System.out.println("------------------------------------------------------------- \n ");
                    Scanner clavier = new Scanner(System.in);
                    while (true) {
                        System.out.println(" Entrer votre choix \n");
                        try {
                            i = Integer.parseInt(clavier.next());
                            break;
                        } catch (NumberFormatException ignore) {
                            System.out.println("Invalid input please answer a int value!");
                        }
                    }
                    switch (i) {
                        case 1:
                            S.nouveauCompteClientExistant();
                            // Service_Banque.affichercompte();
                            break;
                        case 2:
                            S.nouveauClient();
                            break;
                        case 3:
                            S.chercherClientParPrénom();
                            break;
                        case 4:
                            S.chercherClientParId();
                            break;
                        case 5:
                            S.chercherClientParNom();
                            break;
                       case 6:
                            S.chercherClientParCin();
                            break;
                         case 7:
                            S.trierClientParNom();
                            break;
                     case 8:
                            S.supprimerClient();
                            break;
                          case 9:
                           S.chercherClientParEmail();
                            break;
                        case 10:
                            S.modifierClient();
                            break;
                       case 11:
                            S.calculerEtAfficherStatistiques();
                            break;
                        default:
                            System.out.println("Bad entry GoodBy !!!!!!!!!!");

                            break;
                    }
                } while (i != 12);
            }
            else if (A.seConnecter().equals("client")) {
                int i = -1;

                    System.out.println("------------------------------------------------------------- \n ------- \t\tWelcom to you bank \t\t-------\n " +
                            "-----------------------------------------------------------");
                    System.out.println("= Entrer (1)    consulter Détail Client     = ");
                    System.out.println("= Entrer (2)    consulter Détail COMPTE     = ");
                    System.out.println("= Entrer (3)    modifier client             = ");
                    System.out.println("= Entrer (4)    modifier compte             = ");
                    System.out.println("= Entrer (5)    Verser                      = ");
                    System.out.println("= Entrer (6)    Retirer                     = ");
                    System.out.println("= Entrer (7)    Virement                    = ");
                    System.out.println("------------------------------------------------------------- \n ");
                    System.out.println("------------------------------------------------------------- \n ");
                    Scanner clavier = new Scanner(System.in);
                    int id;
                    while (true) {
                        System.out.println("entrer votre identifiant :");
                        try {
                            id = Integer.parseInt(clavier.next());
                            break;
                        } catch (NumberFormatException ignore) {
                            System.out.println("Invalid input please answer a int value!");
                        }
                    }
                    while (true) {
                        System.out.println(" Entrer votre choix \n");
                        try {
                            i = Integer.parseInt(clavier.next());
                            break;
                        } catch (NumberFormatException ignore) {
                            System.out.println("Invalid input please answer a int value!");
                        }

                }
            }
                    /*switch (i) {
                        case 1:
                            Service_client.consulterDétailClient(id);
                            break;
                        case 2:
                            Service_client.consulterDétailCompte(id);
                            break;
                        case 3:
                            Service_client.modifyClient(id);
                            break;
                        case 4:
                            Service_client.modifierCompte(id);
                            break;
                        case 5:
                            Service_client.verser(id);
                            break;
                        case 6:
                            Service_client.retire(id);
                            break;
                        case 7:
                            Service_client.virement(id);
                            break;
                        default:
                            System.out.println("Au revoir ");
                            break;
                    }
                } while (i != 8);
            }*/
            else {
                System.out.println("Repeter votre login et mot de passe et votre role");
            }
        }
    }
}





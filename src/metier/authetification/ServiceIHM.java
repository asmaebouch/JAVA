package metier.authetification;

import metier.admin.ServiceAdmin;
import metier.admin.ServiceIHMAdmin;
import metier.clients.ServiceClient;
import metier.clients.ServiceIHMClient;
import presentation.model.Admin;
import presentation.model.Banque;
import presentation.model.Client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ServiceIHM implements IServiceIHM {
    private  Banque banque = new Banque();
        public ServiceIHM(Banque banque){
            this.banque=banque;
        }
        @Override
        public int menuGlobal() {

            ServiceIHMAdmin serviceIHMAdmin = new ServiceIHMAdmin(banque);
            ServiceIHMClient serviceIHMClient =new ServiceIHMClient(banque);
            ServiceClient serviceClient = new ServiceClient(banque);
           // Client client
            //banque.ajouter(client)

            Authentificationconsole A = new Authentificationconsole(banque);
            String role = A.seConnecter();
            for(;;) {
                if (role.equals("client")) {
                    System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=*");
                    System.out.println("*             BIENVENUE CHER(E) CLIENT(E) ^_^              *");
                    System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=*");

                    System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=*");
                  //  System.out.println("Session ouvertee pour [Client : " + banque.getClientsDeBanque(). + client.getPrenom() + "]");
                    System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=*");
                //    System.out.println("*=*=*=*=*=*=  Veuillez choisir un compte parmi " + client.getComptesClient().size() + " comptes trouvés *=*=*=*=*=*=*=*=*=*");
                    System.out.println("=*=                                " + String.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy :: HH:mm:ss"))) + "=*=");
                    System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=*");
                    System.out.println("=*=                                                      *=*");
                    serviceIHMClient.menuGlobal();
                break;
                } else if (role.equals("admin")) {
                    System.out.println("Session opened for [ Admin : " + Admin.getInstance().getPrenom() + " " + Admin.getInstance().getNom() + "]");
                    System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=*");
                    System.out.println("*             BIENVENUE CHER(E) ADMIN ^_^                  *");
                    System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=*");

                    System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=*");
                    System.out.println("*=*=*=*=*=*=    M E N U [ADMINISTRATEUR] *=*=*=*=*=*=*=*=*=*");
                    LocalDateTime date = null;
                    System.out.println("=*=                                " + String.valueOf(date.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy :: HH:mm:ss"))) + "=*=");
                    System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=*");
                    System.out.println("=*=                                                      *=*");

                    serviceIHMAdmin.menuGlobal();
                    break;
                } else {

                    break;
                }
            }

            return 0;
        }
    }



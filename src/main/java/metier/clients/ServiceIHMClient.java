package metier.clients;

import presentation.model.Banque;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ServiceIHMClient implements IServiceIHMClient{
    Banque banque=new Banque();

    ServiceClient serviceClient=new ServiceClient(banque);
  //  ServiceIHMClient serviceIHMClient=new ServiceIHMClient(banque);

    public ServiceIHMClient(Banque banque) {
        this.banque=banque;
    }

    @Override
    public int menuGlobal() {
        System.out.println("Entrer votre id client");
        Scanner clavier = new Scanner(System.in);
        Long idClient = (long) Integer.parseInt(clavier.next());
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println("*=*=*=*=*=*=*=*=   M E N U [PRINCIPALE]   *=*=*=*=*=*=*=*=*=");
        LocalDateTime date = null;
        System.out.println("=*=                                "+String.valueOf(date.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy :: HH:mm:ss")))+"=*=");
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=**=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println("*=*                                                      *=*");
        System.out.println("= Tapez 1 pour faire un versement                          =");
        System.out.println("= Tapez 2 pour faire un retrait                            =");
        System.out.println("= Tapez 3 pour faire un viremeent                          =");
        System.out.println("= Tapez 4 pour modifier votre profile                      =");
        System.out.println("= Tapez 5 pour afficher des informations du compte         =");
        System.out.println("= Tapez 6 pour afficher le solde actuel  du compte         =");
        System.out.println("= Tapez 7 pour changer  de compte                          =");
        System.out.println("= Tapez 8 pour se déconnecter                              =");
        return 0;
    }

    @Override
    public int menuModification() {
        System.out.println("= Enter [nom] if you want modify name of client            =");
        System.out.println("= Enter [prenom]  if you want modify last name of client   =");
        System.out.println("= Enter [email]  if you want modify email of client        =");
        System.out.println("= Enter [cin]  if you want modify cin of client            =");
        System.out.println("= Enter [tel]  if you want modify telephone of client      =");
        System.out.println("============================================================");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Entrer votre choix ");

        String choice = keyboard.nextLine();
        switch (choice) {
            case "nom": {
                serviceClient.modifierProfile(choice);

            }
            case "prenom": {
                serviceClient.modifierProfile(choice);
            }
            case "email": {
                serviceClient.modifierProfile(choice);
            }
            case "cin": {
                serviceClient.modifierProfile(choice);
            }
            case "tel": {
                serviceClient.modifierProfile(choice);
            }

        }
        return 1;
    }

    @Override
    public int menuRetrait() {
        System.out.println("= Enter [nom] if you want modify name of client            =");
        System.out.println("= Enter [prenom]  if you want modify last name of client   =");
        System.out.println("= Enter [email]  if you want modify email of client        =");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Entrer votre choix ");

        String choice = keyboard.nextLine();
        switch (choice) {
        }
        return 0;
    }

    @Override
    public int menuInformations() {
        return 0;
    }
}

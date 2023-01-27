package metier.admin;

import presentation.model.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ServiceAdmin implements IServiceAdmin {
    Banque banque = new Banque();

    public ServiceAdmin(Banque b1) {
        this.banque = b1;
    }
    @Override
    public Client nouveauClient() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Creation et l'ajout de client : ");
        String choix;
        Client Co = new Client();
        System.out.println("Entrer le nom : ");
        String nom = clavier.next();
        System.out.println("Entrer le prenom : ");
        String prenom = clavier.next();
        System.out.println("Entrer le cin : ");
        String cin = clavier.next();
        System.out.println("Entrer le telephone : ");
        String tel = clavier.next();
        System.out.println("Entrer le sexe FEMME/HOMME: ");
        Sexe sexe = Sexe.valueOf(clavier.next());
        System.out.println("Entrer l'email : ");
        String email = clavier.next();
        while (Co.valEmail(email) == "Invalid") {
            System.out.println("Erreur de syntaxe pour l'email ");
            System.out.println("Entrer l'email : ");
            email = clavier.next();
            Co.valEmail(email);
        }
        System.out.println("Insere votre Login : ");
        String Login = clavier.next();
        System.out.println("Insere votre mot de pass : ");
        String password = clavier.next();
        System.out.println("Insere votre role : ");
        String role = clavier.next();

        Co.setEmail(email);
        Co.setNom(nom);
        Co.setPrenom(prenom);
        Co.setLogin(Login);
        Co.setMotDePasse(password);
        Co.setRole(role);
        Co.setCin(cin);
        Co.setSexe(sexe);
        Co.setTel(tel);
      /*  if(banque.getClientsDeBanque().contains(Co)){
            System.err.println("Ajout de client n°"+Co.getId()+" a echoué, un client avec le même contenue existe déjà dans la collection");}
       */
        banque.ajouter(Co);

        System.out.println(Co.toString());
        System.out.println("Au revoir !!!!!!!!");
        return Co;
    }
    @Override
    public Client nouveauCompteClientExistant() {
        System.out.println("Creation et l'ajout de compte : ");
        String choix;
        int nb = 0;
        Scanner clavier = new Scanner(System.in);
        Long idClient;
        while (true) {
            System.out.println("Donnez l'id de client");
            try {
                idClient = (long) Integer.parseInt(clavier.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int  value!");
            }
        }
        float solde;
        Client c = new Client();
        for (Client j : banque.getClientsDeBanque()) {
            for (; ; ) {
                if (j.getId().equals(idClient)) {
                    while (true) {
                        System.out.println("Entrer le solde : ");
                        try {
                            solde = Float.parseFloat(clavier.next());
                            if (solde > 0) {
                                break;
                            } else {
                                System.out.println("Solde est negative!!!!!!");
                            }
                        } catch (NumberFormatException ignore) {
                            System.out.println("Invalid input please answer a float or int  value!");
                        }
                    }
                    Compte C = new Compte((double) solde);
                    j.Ajouter(C);
                    System.out.println(j.toString());
                    c = j;
                    break;
                } else {
                    break;
                }
            }
        }
        System.out.println("Au revoir !!!!!!!!");
        return c;
    }
    @Override
    public Client chercherClientParId() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("\t\t\t\t------ Chercher client -----");
        Long idClient;
        Client client=new Client();
        while (true) {
            System.out.println("Donnez l'id de client");
            try {
                idClient = Long.valueOf((clavier.next()));
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int  value!");
            }
        }
        for (Client j : banque.getClientsDeBanque()) {
            for(;;) {
                if (j.getId().equals(idClient)) {
                    System.out.println("exist client");
                    System.out.println(j.toString());
                    client = j;
                    break;
                } else {
                    break;
                }

            }

        }
        return client;
    }
    @Override
    public List<Client> chercherClientParNom() {
        List<Client> clients = new ArrayList<>();

        Scanner clavier = new Scanner(System.in);
        System.out.println("\t\t\t\t------ Chercher client -----");
        String nomClient;
        while (true) {
            System.out.println("Donnez le nom de client");
            try {
                nomClient = clavier.next();
                break;
            } catch (StringIndexOutOfBoundsException ignore) {
                System.out.println("Invalid input please answer a String  value!");
            }
        }
        for (Client j : banque.getClientsDeBanque()) {

            if (j.getNom().equals(nomClient)) {
                System.out.println("exist client");
                Object O = nomClient;
                clients.addAll(banque.getClientsDeBanque().stream().filter(c -> c.getPrenom().equals(O)).collect(Collectors.toList()));
                clients.forEach(client -> System.out.println("=> " + client));
                //return clients;
                break;
            } else {

                return null;
            }
        }

        System.out.println("THE END OF SEARCHING!!!!!!!!!!!!!!!!");
        return clients;
    }
    @Override
    public List<Client> chercherClientParPrénom() {
        List<Client> clients = new ArrayList<>();
        Scanner clavier = new Scanner(System.in);
        System.out.println("\t\t\t\t------ Chercher client -----");
        String prenomClient;
        while (true) {
            System.out.println("Donnez le prenom de client");
            try {
                prenomClient = clavier.next();
                break;
            } catch (StringIndexOutOfBoundsException ignore) {
                System.out.println("Invalid input please answer a String  value!");
            }
        }
        for (Client j : banque.getClientsDeBanque()) {
            if (j.getPrenom().equals(prenomClient)) {
                System.out.println("exist client");
                Object O = prenomClient;
                clients.addAll(banque.getClientsDeBanque().stream().filter(c -> c.getPrenom().equals(O)).collect(Collectors.toList()));
                clients.forEach(client -> System.out.println("=> " + client));
                //return clients;
                break;
            } else {
                System.out.println("N'existe pas ");
                return null;
            }
        }

        System.out.println("THE END OF SEARCHING!!!!!!!!!!!!!!!!");
        return clients;
    }
    @Override
    public Client chercherClientParCin() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("\t\t\t\t------ Chercher client -----");
        String cinClient;
        Client client = new Client();
        while (true) {
            System.out.println("Donnez le cin de client");
            try {
                cinClient = clavier.next();
                break;
            } catch (StringIndexOutOfBoundsException ignore) {
                System.out.println("Invalid input please answer a String  value!");
            }
        }
        for (Client j : banque.getClientsDeBanque()) {
            for (; ; ) {
                if (j.getCin().equals(cinClient)) {
                    System.out.println("exist client");
                    System.out.println(j.toString());
                    client = j;
                    //return clients;
                    break;
                } else {

                    break;
                }
            }
        }
        System.out.println("THE END OF SEARCHING!!!!!!!!!!!!!!!!");
        return client;
    }

    @Override
    public Client chercherClientParEmail() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("\t\t\t\t------ Chercher client -----");
        String cinClient;
        Client client = new Client();
        String email = null;
        while (Client.valEmail(email) == "Invalid") {
            System.out.println("Erreur de syntaxe pour l'email ");
            System.out.println("Entrer l'email : ");
            email = clavier.next();
            Client.valEmail(email);
        }
        for (Client j : banque.getClientsDeBanque()) {
            for (; ; ) {
                if (j.getEmail().equals(email)) {
                    System.out.println("exist client");
                    System.out.println(j.toString());
                    client = j;
                    //return clients;
                    break;
                } else {

                    break;
                }
            }
        }
        System.out.println("THE END OF SEARCHING!!!!!!!!!!!!!!!!");
        return client;
    }

    @Override
    public Compte chercherCompteParId() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("\t\t\t\t------ Chercher client -----");
        Long idCompte;
        Compte compte = new Compte();
        while (true) {
            System.out.println("Donnez l'id de compte");
            try {
                idCompte = Long.valueOf(clavier.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int  value!");
            }
        }
        for (Client j : banque.getClientsDeBanque()) {
            for (Compte c : j.getComptesClient()) {
                if (c.getNumeroCompte().equals(idCompte)) {
                    System.out.println("exist client");
                    //System.out.println(j.toString());
                    compte = c;
                    return c;
                } else {
                    System.out.println("N'existe pas ");
                    return null;
                }
            }
        }
        System.out.println("THE END OF SEARCHING!!!!!!!!!!!!!!!!");
        return compte;
    }

    @Override
    public List<Compte> chercherCompteParSolde() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("\t\t\t\t------ Chercher client -----");
        Double solde;
        List<Compte> comptes = new ArrayList<>();
        while (true) {
            System.out.println("Donnez le solde de client");
            try {
                solde = Double.valueOf((clavier.next()));
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int  value!");
            }
        }
        for (Client j : banque.getClientsDeBanque()) {
            for (Compte c : j.getComptesClient()) {
                if (c.getSolde().equals(solde)) {
                    System.out.println("exist client");
                    //System.out.println(j.toString());
                    Object O = solde;
                    comptes.addAll(j.getComptesClient().stream().filter(p -> p.getSolde().equals(O)).collect(Collectors.toList()));
                    comptes.forEach(client -> System.out.println("=> " + client));
                } else {
                    System.out.println("N'existe pas ");
                    return null;
                }
            }
        }
        System.out.println("THE END OF SEARCHING!!!!!!!!!!!!!!!!");
        return comptes;
    }

    @Override
    public List<Compte> chercherCompteParDateCreation() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("\t\t\t\t------ Chercher client -----");
        LocalDateTime dateCreation;
        List<Compte> comptes = new ArrayList<>();
        while (true) {
            System.out.println("Donnez le solde de client");
            dateCreation = LocalDateTime.parse(clavier.next());
            break;
        }
        for (Client j : banque.getClientsDeBanque()) {
            for (Compte c : j.getComptesClient()) {
                if (c.getDateCreation().equals(dateCreation)) {
                    System.out.println("exist client");
                    //System.out.println(j.toString());
                    Object O = dateCreation;
                    comptes.addAll(j.getComptesClient().stream().filter(p -> p.getDateCreation().equals(O)).collect(Collectors.toList()));
                    comptes.forEach(client -> System.out.println("=> " + client));
                } else {
                    System.out.println("N'existe pas ");
                    return null;
                }
            }
        }
        System.out.println("THE END OF SEARCHING!!!!!!!!!!!!!!!!");
        return comptes;
    }

    @Override
    public List<Compte> chercherCompteParPropriétaire() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("\t\t\t\t------ Chercher client -----");
        Client proprietaire;
        List<Compte> comptes = new ArrayList<>();
        Long idCompte;
        Compte compte = new Compte();
        while (true) {
            System.out.println("Donnez l'id de client");
            try {
                idCompte = Long.valueOf(Integer.parseInt(clavier.next()));
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int  value!");
            }
        }
        for (Client j : banque.getClientsDeBanque()) {
            for (Compte c : j.getComptesClient()) {
                if (c.getPropriétaire().getId().equals(idCompte)) {
                    System.out.println("exist client");
                    //System.out.println(j.toString());
                    Object O = idCompte;

                    comptes.addAll(j.getComptesClient().stream().filter(p -> p.getDateCreation().equals(O)).collect(Collectors.toList()));
                    comptes.forEach(client -> System.out.println("=> " + client));
                } else {
                    System.out.println("N'existe pas ");
                    return null;
                }
            }
        }
        System.out.println("THE END OF SEARCHING!!!!!!!!!!!!!!!!");
        return comptes;
    }

    @Override
    public Client modifierClient(String choix) {
        System.out.println(" -------Modify Client ----------- : ");
       ;
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
        return clie;
    }

    @Override
    public boolean supprimerClient() {
        boolean supprimé = false;
        System.out.println(" -------Delete Client ----------- : ");
        String choix;
        Client clie = new Client();
        Scanner clavier = new Scanner(System.in);
        Long idClient;
        while (true) {
            System.out.println("Donnez l'id de compte ");
            try {
                idClient = Long.parseLong((clavier.next()));
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int  value!");
            }
        }
        for (Client j : banque.getClientsDeBanque()) {
            for (; ; ) {
                if (j.getId().equals(idClient)) {
                    supprimé = this.banque.getClientsDeBanque().remove(j);
                    System.out.println("client supprimé de la collection !!!");
                    break;
                }

                if (!supprimé)
                    System.err.println("Suppression echoué :: Client n°" + j.getId() + " n'existe pas dans la collection !!!");
                break;
            }
        }

        return supprimé;
    }

    @Override
    public TableauDeBord calculerEtAfficherStatistiques() {
        TableauDeBord T=new TableauDeBord();
        Double maxValue = Double.valueOf(0);
        for (Client j : banque.getClientsDeBanque()) {
            for (Compte c : j.getComptesClient()) {
                //  long n = c.getCompteur()-1;
                // System.out.println(n);
                if (c.getSolde() > maxValue) {
                    maxValue=c.getSolde();
                    T.setMaxSolde(c.getSolde());
                    //System.out.println(T.getMaxSolde());
                }
            }
        }
        Double minValue =maxValue ;
        for (Client j : banque.getClientsDeBanque()) {
            for (Compte c : j.getComptesClient()) {
                if (c.getSolde() < minValue) {
                    minValue=c.getSolde();
                    T.setMinSolde(c.getSolde());
                    System.out.println("Le solde minimal " + T.getMinSolde());
                }
                T.setNombreTotaleCompte(c.getCompteur()-1);
            }
        }
        System.out.println("=> Le nombre total de compte :"+T.getNombreTotaleCompte());
        System.out.println("=> Le solde maximaL :" + T.getMaxSolde());
        System.out.println("=> Le solde minimal : " + T.getMinSolde());
        T.setNombreTotaleClient(Long.valueOf(banque.getClientsDeBanque().size()));
        System.out.println("=> Le Nombre total de client :"+T.getNombreTotaleClient());
        return T;
    }

    @Override
    public List<Client> trierClientParNom() {
        List<Client> clients = new ArrayList<>(banque.getClientsDeBanque());
        //(banque.getClientsDeBanque().sort((cd1, cd2) -> cd1.getNom().compareTo(cd2.getNom()))));

        Collections.sort(clients, (cd1, cd2) -> cd1.getNom().compareTo(cd2.getNom()));
        clients.forEach(client -> System.out.println("=> " + client));
        return clients;
    }

    @Override
    public List<Client> trierClientParCin() {
        List<Client> clients = new ArrayList<>(banque.getClientsDeBanque());
        //(banque.getClientsDeBanque().sort((cd1, cd2) -> cd1..compareTo(cd2.getNom()))));
        Collections.sort(clients, (cd1, cd2) -> cd1.getCin().compareTo(cd2.getCin()));
        clients.forEach(client -> System.out.println("=> " + client));
        return clients;
    }

    @Override
    public List<Client> trierClientParEmail() {
        List<Client> clients = new ArrayList<>(banque.getClientsDeBanque());
        //(banque.getClientsDeBanque().sort((cd1, cd2) -> cd1.getNom().compareTo(cd2.getNom()))));

        Collections.sort(clients, (cd1, cd2) -> cd1.getEmail().compareTo(cd2.getEmail()));
        clients.forEach(client -> System.out.println("=> " + client));
        return clients;
    }
    @Override
    public List<Client> trierClientParSoldeCompte() {
        List<Client> clients = new ArrayList<>(banque.getClientsDeBanque());
        for (Client j : banque.getClientsDeBanque()) {
            List<Compte> comptes = new ArrayList<>(j.getComptesClient());

            //(banque.getClientsDeBanque().sort((cd1, cd2) -> cd1.getNom().compareTo(cd2.getNom()))));
            Collections.sort(comptes, (cd1, cd2) -> cd1.getSolde().compareTo(cd2.getSolde()));
            clients.forEach(client -> System.out.println("=> " + client));
        }
        return clients;
    }

    @Override
    public List<Compte> trierComptesParSolde() {
        List<Client> clients = new ArrayList<>(banque.getClientsDeBanque());
        List<Compte> comptes = new ArrayList<>();
        for (Client j : banque.getClientsDeBanque()) {
            comptes = j.getComptesClient();
            //(banque.getClientsDeBanque().sort((cd1, cd2) -> cd1.getNom().compareTo(cd2.getNom()))));
            Collections.sort(comptes, (cd1, cd2) -> cd1.getSolde().compareTo(cd2.getSolde()));
            comptes.forEach(client -> System.out.println("=> " + client));
        }
        return comptes;
    }

    @Override
    public List<Compte> trierComptesParDateDeCreation() {
        return null;
    }

    @Override
    public List<Compte> trierComptesParNomPropriétaire() {
        return null;
    }
}



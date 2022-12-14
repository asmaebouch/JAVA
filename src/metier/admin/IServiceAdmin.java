package metier.admin;

import presentation.model.Client;
import presentation.model.Compte;
import presentation.model.TableauDeBord;

import java.time.LocalDateTime;
import java.util.List;

public interface IServiceAdmin {

    Client          nouveauClient();
    Client      nouveauCompteClientExistant();

    Client          chercherClientParId();
    List<Client>    chercherClientParNom();
    List<Client>    chercherClientParPr√©nom();
    Client          chercherClientParCin();
    Client          chercherClientParEmail();

    Compte          chercherCompteParId();
    List<Compte>    chercherCompteParSolde();
    List<Compte>    chercherCompteParDateCreation();
    List<Compte>    chercherCompteParPropri√©taire();

    Client          modifierClient();
    boolean         supprimerClient();

    TableauDeBord calculerEtAfficherStatistiques();

    List<Client>    trierClientParNom();
    List<Client>    trierClientParCin();
    List<Client>    trierClientParEmail();

    List<Client>    trierClientParSoldeCompte();
    List<Compte>    trierComptesParSolde();
    List<Compte>    trierComptesParDateDeCreation();
    List<Compte>    trierComptesParNomPropri√©taire();

}

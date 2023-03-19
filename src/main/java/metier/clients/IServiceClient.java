package metier.clients;

import presentation.model.Compte;

public interface IServiceClient {

    boolean versement();
    boolean retrait  ();

    boolean retrait  (int choixRetrait);
    boolean virement ();
    boolean modifierProfile(String choixModification);
    void dernièresOpérations();
    Double afficherSolde();
    Compte choisirCompte();

    void afficherTicket();

}

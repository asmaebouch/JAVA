package metier.admin;

import metier.authetification.IServiceIHM;

public interface IServiceIHMAdmin extends IServiceIHM {

    int menuModification();
    int menuRecherche();
    int menuInformations();
    int menuAjout();
    int menuSuppression();
    int tableauDeBord();
    int menuTrie();
    int menuComptabilité();

}

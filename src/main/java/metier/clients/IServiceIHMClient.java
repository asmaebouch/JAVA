package metier.clients;

import metier.authetification.IServiceIHM;

public interface IServiceIHMClient extends IServiceIHM {

    int menuModification();
    int menuRetrait();
    int menuInformations();

}
package metier;
import metier.admin.ServiceAdmin;
import metier.authetification.Authentificationconsole;
import metier.authetification.ServiceIHM;
import presentation.model.Admin;
import presentation.model.Banque;
import presentation.model.Client;

import java.util.Scanner;

public class Service_Test {
    //Service_Banque sb;
    public static void main(String[] args) {
        Banque banque = new Banque();
        ServiceIHM serviceIHM=new ServiceIHM(banque);
        serviceIHM.menuGlobal();
    }
}





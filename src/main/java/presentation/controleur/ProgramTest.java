package presentation.controleur;

import dao.Idao;
import dao.files.AccountDao;
import dao.files.AgenciesDao;
import dao.files.ClientDao2;
import dao.files.FileBasePaths;
import presentation.model.Banque;
import presentation.model.Client;
import presentation.model.Compte;
import presentation.model.Sexe;

import java.io.File;
import java.io.IOException;

public class ProgramTest {
    public static void main(String[] args) {
        try {
            FileBasePaths.createFileBase();
            Idao<Client, Long> clientLongIdao = new ClientDao2();
            Idao<Compte,Long> compteLongIdao=new AccountDao();
            Idao<Banque,Long> banqueLongIdao=new AgenciesDao();
              Client clientSpecial = new Client("asmae", "1234", "asmae", "bouche", "asmae.bouch@gmail.com", "azeee", "0788986", Sexe.FEMME);
            Client clientSpecial3 = new Client("asmaeeee", "1234", "asmae", "bouche", "asmae.bouch@gmail.com", "azeee", "0788986", Sexe.FEMME);
           // Client clientSpecial4 = new Client("oussama", "1234", "asmae", "bouche", "asmae.bouch@gmail.com", "azeee", "0788986", Sexe.FEMME);
          Banque banque=new Banque("aaaa","aaaa","aaaa","aaaa");
              Client clientSpecial2 = new Client(2L,"Zouhair", "1234", "asmeeae", "bouche", "asmae.bouch@gmail.com", "azeee", "0788986", Sexe.FEMME);
           //System.out.println(clientSpecial2.toString());
          //  System.out.println(clientSpecial.toString());
            if (clientSpecial == null) {
                System.out.println("Error: client object is null, it can't be saved.");
                return;
            }
            File clientTable = new File(String.valueOf(FileBasePaths.CLIENT_TABLE));
            if (!clientTable.exists()) {
                System.out.println("Error: client table file does not exist, it should be created first.");
                return;
            }
            if (!clientTable.canWrite()) {
                System.out.println("Error: client table file is not writable.");
                return;
            }
           // banqueLongIdao.save(banque);
            //System.out.println("banque save succeccefuly ");
          //  clientLongIdao.delete(clientSpecial2);
           // System.out.println("Suppression succes");
            //Compte compte=new Compte(300.0,clientSpecial);
          //  compteLongIdao.save(compte);
            //compteLongIdao.findall().forEach(System.out::println);
           // System.out.println("Compte ajouter avec succes");
          // clientLongIdao.save(clientSpecial);
           // clientLongIdao.save(clientSpecial3);
            //clientLongIdao.save(clientSpecial2);
           //clientLongIdao.update(clientSpecial2);
            //System.out.println("Client update successfully.");
            //clientLongIdao.findall().forEach(System.out::println);;
            //System.out.println(clientLongIdao.findById(2L).toString());
            //System.out.println("find by id ");
      //      System.out.println("Client saved successfully.");
        } catch (IOException e) {
            System.out.println("Error: An IOException occurred while saving the client object.");
            e.printStackTrace();
        }
    }
}
/*public static void main(String[] args) {
    try {
        // Create a new client object with updated values
        Client newClient = new Client(1, "John", "Doe", "johndoe", "password123", "123456789", "johndoe@email.com", "male");
        // Call the update method and pass the new client object as an argument
        Client updatedClient = update(newClient);
        // Print the updated client object to verify that the update was successful
        System.out.println(updatedClient);
    } catch (IOException e) {
        System.out.println("Error updating client: " + e.getMessage());
    }
}
*/

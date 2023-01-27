package dao.files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface FileBasePaths {
    Path FILEBASEFOLDER= Paths.get("myFileBase");
    Path LOGSFOLDER= Paths.get(FILEBASEFOLDER.toString(),"operationsLogs");
    Path CLIENT_TABLE= Paths.get(FILEBASEFOLDER.toString(),"clients.txt");
    //Ou  Path CLIENT_TABLE= Paths.get(FILEBASEFOLDER.toString()+"/clients.txt");
    Path ACCOUNT_TABLE= Paths.get(FILEBASEFOLDER.toString(),"accounts.txt");
    Path BANK_AGENCIES_TABLE= Paths.get(FILEBASEFOLDER.toString(),"agencies.txt");
//Archiver les loogs 1 creer un dossier logs_foldre
 static void changeFile(Path path,String header) throws IOException {
    if(path.toFile().exists()){
        try {
            path.toFile().createNewFile();
            Files.writeString(path,header);
            System.out.println(path.getFileName()+"a ete cree avec succes");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    else System.out.println(path.getFileName()+" existe deja");
}
    static void createFileBase() throws IOException {
        String header;
        String clientsHeader ="id\t\t\tNom\t\t\tPrenom\t\t\tlogin\t\t\tpassword\t\t\temail\t\t\tcin\t\t\ttel\t\t\tsex\n";
        String accountsHeader ="id\t\t\tdate de cration\t\t\t\t\t\t\tSolde\t\t\tidClient\n";
        String agencyHeader ="id\t\t\tnom\t\t\tEmail\t\t\ttel\t\t Adress\n";
        String operationsHeader="date\t\t\t time\t\t\t type\t\t\tmsg\n";
        if(!FILEBASEFOLDER.toFile().exists()){
            FILEBASEFOLDER.toFile().mkdir();
            System.out.println(FILEBASEFOLDER.getFileName()+"a été cree avec succes");
        }
        else{
            System.err.println(FILEBASEFOLDER.getFileName()+" exist deja ");
        }

        if(!LOGSFOLDER.toFile().exists()){
            LOGSFOLDER.toFile().createNewFile();
            try (BufferedWriter writer = Files.newBufferedWriter(LOGSFOLDER)) {
                writer.write(operationsHeader);
            } catch (IOException e) {
                // handle the exception
            }
            System.out.println(LOGSFOLDER.getFileName()+"a été cree avec succes");
        }
        else{
            System.err.println(LOGSFOLDER.getFileName()+" exist deja ");
        }
        if(!CLIENT_TABLE.toFile().exists()){
            CLIENT_TABLE.toFile().createNewFile();

            try (BufferedWriter writer = Files.newBufferedWriter(CLIENT_TABLE)) {
                writer.write(clientsHeader);
            } catch (IOException e) {
                // handle the exception
            }

            System.out.println(CLIENT_TABLE.getFileName()+"a été cree avec succes");
        }
        else{
            System.err.println(CLIENT_TABLE.getFileName()+" exist deja ");
        }
        if(!ACCOUNT_TABLE.toFile().exists()){
            ACCOUNT_TABLE.toFile().createNewFile();
            try (BufferedWriter writer = Files.newBufferedWriter(ACCOUNT_TABLE)) {
                writer.write(accountsHeader);
            } catch (IOException e) {
                // handle the exception
            }
            System.out.println(ACCOUNT_TABLE.getFileName()+"a été cree avec succes");
        }
        else{
            System.err.println(ACCOUNT_TABLE.getFileName()+" exist deja ");
        }
        if(!BANK_AGENCIES_TABLE.toFile().exists()){
            BANK_AGENCIES_TABLE.toFile().createNewFile();
            //Files.writestring(,)
            try (BufferedWriter writer = Files.newBufferedWriter(BANK_AGENCIES_TABLE)) {
                writer.write(agencyHeader);
            } catch (IOException e) {
                // handle the exception
            }
            System.out.println(BANK_AGENCIES_TABLE.getFileName()+"a été cree avec succes");
        }
        else{
            System.err.println(BANK_AGENCIES_TABLE.getFileName()+" exist deja ");
        }


    }




}

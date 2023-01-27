package dao.files;

import dao.Idao;
import presentation.model.Client;
import presentation.model.Compte;
import presentation.model.Sexe;
import presentation.model.Utilisateur;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class AccountDao implements Idao<Compte,Long> {
    @Override
    public List<Compte> findall() {
        Utilisateur.compteur = 1    ;
        Compte.compteur=1;
        List<Compte> comptes = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(FileBasePaths.ACCOUNT_TABLE, StandardCharsets.UTF_8);
            lines.remove(0);

            if (!lines.isEmpty()) {
                comptes = lines.stream().map(line -> {
                    Compte cl;
                    StringTokenizer st = new StringTokenizer(line, "\t");
                    String id =st.nextToken();
                  LocalDateTime date2 = null;
                    try {
                         date2 = LocalDateTime.parse(st.nextToken());
                    } catch (DateTimeParseException e) {
                        // Handle the exception by displaying an error message or taking an alternative action
                        System.out.println("Error: Invalid input, expected a long value.");
                    }
                    double solde = 0;
                    try {

                        solde = Double.parseDouble(st.nextToken());
                    } catch (NumberFormatException e) {
                        // Handle the exception by displaying an error message or taking an alternative action
                        System.out.println("Error: Invalid input, expected a long value.");
                    }
                    Client client = new Client();

                    cl = new Compte(solde, client,date2);
                    return cl;
                }).collect(Collectors.toList());
            }
    }  catch (IOException e) {
            System.out.println("Error: An error occurred while reading the file.");

            e.printStackTrace();
        }
        return comptes;
    }

    @Override
    public Compte findById(Long id) {
        return  findall().stream().filter(compte -> compte.getNumeroCompte().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Compte save(Compte compte) {
        long id = Long.parseLong(compte.getNumeroCompte());
        //id			date de cration			Solde			idClient
        String compteStr= id+"\t\t"+
                compte.getDateCreation()+"\t\t\t\t\t"+
                compte.getSolde()+"\t\t\t"+
                compte.getPropriétaire().getId()+"\n";

        try {
            Files.writeString(FileBasePaths.ACCOUNT_TABLE,compteStr, StandardOpenOption.APPEND);
            System.out.println("Compte n° "+compte.getNumeroCompte()+"a ete ajouter avec succes");

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return compte;
    }

    @Override
    public List<Client> saveAll(List<Compte> liste) {
        List<Client> newList=new ArrayList<>();
        for(Compte cl:liste){
            Client client  = save(cl).getPropriétaire();
            newList.add(cl.getPropriétaire());
        }
        return newList;
    }

    @Override
    public Compte update(Compte compte) throws IOException {
        List<Compte> clients = findall();
        findall().forEach(System.out::println);

        for (Compte c : clients) {
            if (c.getNumeroCompte() == compte.getNumeroCompte()) {
               // System.out.println("correcte");
                c.setSolde(compte.getSolde());
                c.setPropriétaire(compte.getPropriétaire());
                c.setId2(compte.getNumeroCompte());
                c.setDateCreation2(compte.getDateCreation());
                break;
            }
        }
        String clientsHeader ="id\t\t\tdate de creation\t\t\tSolde\t\t\tidClient\n";
        FileBasePaths.changeFile(FileBasePaths.ACCOUNT_TABLE,clientsHeader);
        saveAll(clients);
        return compte;
    }

    @Override
    public Boolean delete(Compte compte) throws IOException {
        var clients = findall();
        boolean deleted  =
                clients.remove(compte);

        if(deleted) {
            String clientsHeader ="id\t\t\tdate de creation\t\t\tSolde\t\t\tidClient\n";
            FileBasePaths.changeFile(FileBasePaths.ACCOUNT_TABLE,clientsHeader);
            saveAll(clients);

        }

        return deleted;
    }

    @Override
    public Boolean deleteById(Long idClient) throws IOException {
        var clients = findall();
        boolean deleted  =
                clients.remove(findById(idClient));

        if(deleted) {
            String clientsHeader ="id\t\t\tdate de creation\t\t\tSolde\t\t\tidClient\n";
            FileBasePaths.changeFile(FileBasePaths.ACCOUNT_TABLE,clientsHeader);
            saveAll(clients);
        }

        return deleted;
    }


}

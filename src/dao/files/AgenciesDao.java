package dao.files;

import dao.Idao;
import presentation.model.Banque;
import presentation.model.Client;
import presentation.model.Compte;
import presentation.model.Utilisateur;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class AgenciesDao implements Idao<Banque,Long> {
    @Override
    public List<Banque> findall() {
        Utilisateur.compteur = 1    ;
        Compte.compteur=1;
        Banque.compteur=1;
        List<Banque> banques = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(FileBasePaths.BANK_AGENCIES_TABLE, StandardCharsets.UTF_8);
            lines.remove(0);

            if (!lines.isEmpty()) {
                banques = lines.stream().map(line -> {
                    Banque cl;
                    StringTokenizer st = new StringTokenizer(line, "\t");
                    try {
                        Long id = 0L;
                        id = Long.parseLong(st.nextToken());
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid input, expected a long value.");
                    }
                    //id			nom			Email			tel		 Adress
                    String nom=st.nextToken();
                    String email=st.nextToken();
                    String tel=st.nextToken();
                    String address=st.nextToken();

                    cl = new Banque(nom,address,tel,email);
                    return cl;
                }).collect(Collectors.toList());
            }
        }  catch (IOException e) {
            System.out.println("Error: An error occurred while reading the file.");

            e.printStackTrace();
        }
        return banques;
    }

    @Override
    public Banque findById(Long id) {
        return  findall().stream().filter(banque -> banque.getIdBanque().equals(id)).findFirst().orElse(null);

    }

    @Override
    public Banque save(Banque banque) {
        long id = banque.getIdBanque();
        //id			date de cration			Solde			idClient
        String compteStr= id+"\t\t"+
                //id			nom			Email			tel		 Adress
                banque.getNomBanque()+"\t\t\t\t\t"+
                banque.getEmailBanque()+"\t\t\t"+
                banque.getTelBanque()+"\t\t\t"+
                banque.getAdresseBanque()+"\n";


        try {
            Files.writeString(FileBasePaths.BANK_AGENCIES_TABLE,compteStr, StandardOpenOption.APPEND);
            System.out.println("Compte n° "+banque.getIdBanque()+"a ete ajouter avec succes");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return banque;
    }

    @Override
    public List<Client> saveAll(List<Banque> liste) {
        List<Client> newList=new ArrayList<>();
        for(Banque cl:liste){
            Client client  = (Client) save(cl).getClientsDeBanque();
            newList.add((Client) cl.getClientsDeBanque());
        }
        return newList;
    }

    @Override
    public Banque update(Banque banque) throws IOException {
        List<Banque> banques = findall();
        findall().forEach(System.out::println);

        for (Banque c : banques) {
            if (c.getIdBanque() == banque.getIdBanque()) {
                c.setIdBanque(banque.getIdBanque());
                c.setAdresseBanque(banque.getAdresseBanque());
                c.setTelBanque(banque.getTelBanque());
                c.setNomBanque(banque.getNomBanque());
                c.setClientsDeBanque(banque.getClientsDeBanque());
                break;
            }
        }
        //id			nom			Email			tel		 Adress
        String clientsHeader ="id\t\t\tnom\t\t\tEmail\t\t\ttel\t\t\tAdress\n";
        FileBasePaths.changeFile(FileBasePaths.BANK_AGENCIES_TABLE,clientsHeader);
        saveAll(banques);
        return banque;
    }

    @Override
    public Boolean delete(Banque banque) throws IOException {
        var clients = findall();
        boolean deleted  =
                clients.remove(banque);

        if(deleted) {
            String clientsHeader ="id\t\t\tnom\t\t\tEmail\t\t\ttel\t\t\tAdress\n";
            FileBasePaths.changeFile(FileBasePaths.BANK_AGENCIES_TABLE,clientsHeader);
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
            String clientsHeader ="id\t\t\tnom\t\t\tEmail\t\t\ttel\t\t\tAdress\n";
            FileBasePaths.changeFile(FileBasePaths.BANK_AGENCIES_TABLE,clientsHeader);
            saveAll(clients);

        }

        return deleted;
    }


}

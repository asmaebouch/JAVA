package test;

import dao.Idao;
import dao.files.FileBasePaths;
import presentation.model.Client;
import presentation.model.Sexe;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import static java.lang.Long.parseLong;

public class ClientDao implements Idao<Client,Long> {

    @Override
    public List<Client> findall() {
        List<Client> clients = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(FileBasePaths.CLIENT_TABLE, StandardCharsets.UTF_8);
            lines.remove(0);

            if (!lines.isEmpty()) {
                clients = lines.stream().map(line -> {
                    Client cl;
                    StringTokenizer st = new StringTokenizer(line, "\t");
                   try {
                       Long id = 0L;
                       id = Long.parseLong(st.nextToken());
                   }catch (NumberFormatException e) {
                       // Handle the exception by displaying an error message or taking an alternative action
                       System.out.println("Error: Invalid input, expected a long value.");
                   }
                    String nom = st.nextToken();
                    String prenom = st.nextToken();
                    String Logind = st.nextToken();
                    String password = st.nextToken();
                    String email = st.nextToken();
                    String cin = st.nextToken();
                    String tel = st.nextToken();
                    String sexe = st.nextToken();
                    Sexe sex = null;
                    if (email.equalsIgnoreCase("NULL")) email = "";
                    if (tel.equalsIgnoreCase("NULL")) tel = "";
                    if (!sexe.equalsIgnoreCase("NULL")) {
                        if (sexe.equalsIgnoreCase("HOMME")) sex = Sexe.HOMME;
                        else sex = Sexe.FEMME;

                    }

                    cl = new Client(Logind, password, nom, prenom, email, cin, tel, sex);

                    return cl;
                }).collect(Collectors.toList());
            }
        }

        catch (IOException e) {
            System.out.println("Error: An error occurred while reading the file.");

            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public Client findById(Long id) {
        return null;
    }
    private long getIncrementedId(){
        List<Client> clients = findall();
        if(clients == null || clients.isEmpty()) return 1L;
        return clients.stream().map(client -> client.getId()).max((id1,id2)->id1.compareTo(id2)).orElse(1L) +1;
    }

    @Override
    public Client save(Client client) {
        Long id=getIncrementedId();
        client.setId(id);
        String clientStr= id+"\t\t\t"+
                client.getNom()+"\t\t\t"+
                client.getPrenom()+"\t\t\t"+
                client.getLogin()+"\t\t\t"+
                client.getMotDePasse()+"\t\t\t"+
                client.getCin()+"\t\t\t"+
                (client.getEmail()!=null && client.getEmail().trim().length()!=0?client.getEmail():"null")+"\t"+
                (client.getTel()!=null && client.getTel().trim().length()!=0?client.getTel():"null")+"\t\t\t"+
                (client.getSexe()!=null?client.getSexe():"null")+"\t\t\t\n";

        try {
            Files.writeString(FileBasePaths.CLIENT_TABLE,clientStr, StandardOpenOption.APPEND);
            System.out.println("Client n° "+client.getId()+"a ete ajouter avec succes");

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return client;
    }



    @Override
    public     List<Client> saveAll(List<Client> listeClients) {
        List<Client> newList=new ArrayList<>();
        for(Client cl:listeClients){
            Client client  =  save(cl);
            newList.add(cl);
        }
        return newList;
    }

    @Override
    public Client update(Client client) throws IOException {


       /* List <Client> clients = new ArrayList<>(findall());
        clients.set(clients.indexOf(client),client);
        //clients.replaceAll(c -> c.equals(client) ? client : c);
        String clientsHeader ="id\t\t\tNom\t\t\tPrenom\t\t\tlogin\t\t\tpassword\t\t\tcin\t\t\temail\t\t\tsex\n";
        FileBasePaths.changeFile(FileBasePaths.CLIENT_TABLE,clientsHeader);
saveAll(clients);*/
        List<Client> clients = findall();
      // findall().forEach(System.out::println);

        for (Client c : clients) {
            if (c.getId() == client.getId()) {
                System.out.println("correcte");
                c.setId2(client.getId());
                c.setNom(client.getNom());
                c.setEmail(client.getEmail());
                c.setCin(client.getCin());
                c.setSexe(client.getSexe());
                c.setTel(client.getTel());
                c.setLogin(client.getLogin());
                c.setMotDePasse(client.getMotDePasse());
                c.setPrenom(client.getPrenom());
                break;
            }
        }
        String clientsHeader ="id\t\t\tNom\t\t\tPrenom\t\t\tlogin\t\t\tpassword\t\t\temail\t\t\t\t\t\t\tcin\t\t\t\ttel\t\t\t\tsex\n";
        FileBasePaths.changeFile(FileBasePaths.CLIENT_TABLE,clientsHeader);
        saveAll(clients);
        return client;
    }

    @Override
    public Boolean delete(Client client) {
        return null;
    }

    @Override
    public Boolean deleteById(Long idClient) {
        return null;
    }

}

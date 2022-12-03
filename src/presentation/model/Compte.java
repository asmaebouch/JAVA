package presentation.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Compte implements AffichageInfos {
    private static long          compteur = 1;
    private String          numeroCompte;
    private Double          solde;
    private LocalDateTime   dateCreation;
    private Client propriétaire;
    private List<Log>       logs = new ArrayList<>();
    public void setDateCreation() { this.dateCreation = LocalDateTime.now(); }
    public void setPropriétaire(Client propriétaire) {
        this.propriétaire = propriétaire;
    }
    public void setSolde(Double solde) {
        this.solde = solde;
    }
    public void setLog(TypeLog type, String msg) {
        Log log = new Log(LocalDate.now(), LocalTime.now(), type, msg);
        logs.add(log);
    }
    public Client getPropriétaire() {
        return propriétaire;
    }
    public Double           getSolde() {
        return solde;
    }
    public String getNumeroCompte() {
        return numeroCompte;
    }
    public void setNumeroCompte() {
        this.numeroCompte = String.valueOf(compteur++);
    }
    public LocalDateTime    getDateCreation() {
        return dateCreation;
    }
    public List<Log>        getLogs() {
        return logs;
    }
    public long getCompteur(){
        return compteur;
    }
/*public void setLogs(String log){
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy | HH:mm");
    String dateTime=formatter.format(LocalDateTime.now());
    log="[" + dateTime+"] =>"+log;
    for (Log l:logs) {
        if(l==null){
            logs.add(l);
        }

    }
}*/
    public Compte(){
        setNumeroCompte();
        setDateCreation();
        setSolde(0.0);
        setPropriétaire(null);
    }
    public Compte(Double solde){
        if(solde>0) {
            setNumeroCompte();
            setDateCreation();
            this.solde=solde;
            setPropriétaire(null);
        }
        else{
            System.out.println("Solde est negative ");
            return;
        }

    }
    public  Compte(Double solde,Client propriétaire){
        if(solde>0) {
            setNumeroCompte();
            setDateCreation();
            this.solde=solde;
            setPropriétaire(propriétaire);
        }
        else{
            System.out.println("Solde est negative ");
            return;
        }

    }
    @Override
    public String toString() {
        String      compteStr  = "";
        compteStr += "| N° de Compte            : "   + getNumeroCompte()   + "\n";
        compteStr += "| Solde du Compte         : "   + getSolde()    + " Dh\n" ;
       // compteStr += "| Propriétaire du Compte  : "   + getPropriétaire().getNomComplet() + "\n" ;
        compteStr += "------------------------------------------------------\n";
        return compteStr;
    }


    @Override
    public void afficherBref() {
     System.out.println( "| N° de Compte            : "   + getNumeroCompte()   + "\n"+
                         "| Solde du Compte         : "   + getSolde()    + " Dh\n" +
                         "------------------------------------------------------\n");
    }

    @Override
    public void afficherLesLogs() {
        for (Log log:logs) {
            System.out.println(log.toString());
        }
    }

    @Override
    public void afficherInformations() {
     System.out.println( "| N° de Compte            : "   + getNumeroCompte()   + "\n"+
                         "| Solde du Compte         : "   + getSolde()    + " Dh\n" +
                         "| Propriétaire du Compte  : \n"   + getPropriétaire().toString() + "\n" +
                         "------------------------------------------------------\n");
    }

    @Override
    public void afficherInformationsDétaillées() {
     afficherBref();
     afficherInformations();
     afficherLesLogs();
    }
  /*  public static void main(String[] args) {
        Client Cl=new Client("AAA","AAAA","zzz","rrrrr","eeee","eeee","rrrr",Sexe.HOMME);
        Compte C2=new Compte(30.0,Cl);

        C2.setLog(TypeLog.VIREMENT,"VIREMENT");
        C2.afficherBref();
        C2.afficherInformations();
        C2.afficherInformationsDétaillées();
    }*/
}

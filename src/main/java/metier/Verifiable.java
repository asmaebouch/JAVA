package metier;

import presentation.model.Admin;
import presentation.model.Banque;
import presentation.model.Client;

public interface Verifiable {
    default boolean isNumeric(String value){
        try {
            Integer.parseInt(value);
            return true;
        } catch(Exception e){
            return false;
        }
    }
    default boolean isDecimal(String value){
        try {
            Double.parseDouble(value);
            return true;
        } catch(Exception e){
            return false;
        }
    }
    default Admin isAdmin(String lg, String pass, Banque bq) {
        Admin admin = Admin.getInstance();
        if (admin.isValid(lg, pass)) {
            return admin;
        } else {
            return null;
        }
    }
    default boolean isClient(String lg, String pass , Banque bq){
        return bq.getClientsDeBanque().stream()
                .anyMatch(client -> client.getLogin().equals(lg) && client.getMotDePasse().equals(pass));
    }

}

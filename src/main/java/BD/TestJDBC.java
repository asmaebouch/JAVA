package BD;

import presentation.model.Credit;

import java.sql.*;
import java.util.ArrayList;
public class TestJDBC {
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/banktiproject";
        var login = "root";
        var pss = "";
        var driver = " com .mysql.cj.jdbc.Driver";
        Connection connection = null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        ArrayList credits = new ArrayList<Credit>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Chargemeent du driver JDBC pour MSQL reussi ^_^");
            connection = DriverManager.getConnection(url, login, pss);
            System.out.println("Connexion à la BD Bnkati établit avec succees");
            //  ps = connection.prepareStatement("select * from credits where id = ? and capitl = ?");
            ps = connection.prepareStatement("select * from credit");
            //  ps.setLong(1,3L);//Joker num 1
            // ps.setDouble(2,30000);
            rs=ps.executeQuery();
            while (rs.next()){
                var id = rs.getLong("id");
                var cp = rs.getDouble("capitale_Emprunte");
                var nbrM= rs.getInt("nombre_mois");
                var taux = rs.getDouble("taux_Mensuel");
                var demandeur = rs.getString("nom_demandeur");
                var mensulite = rs.getDouble("mensualite");
                Credit credit=new Credit(id,cp,nbrM,taux,demandeur,mensulite);
                credits.add(credit);
            }
            credits.forEach(System.out::println);
            //siree 9ra maven
        } catch (ClassNotFoundException e) {
            //    throw new RuntimeException(e);
            System.out.println("Le driver du MySQL est introuvble" );
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("Connexion échouée");
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                    System.out.println("Connexion fermé avec succes ");
                }
            } catch (SQLException e) {
                //   throw new RuntimeException(e);
                System.out.println("Connexion n'est pas  fermé avec succes ");

            }
            try {
                if(ps != null)
                {
                    ps.close();
                    System.out.println("Connexion fermé avec succes ");
                }
            } catch (SQLException e) {
                //throw new RuntimeException(e);
                System.out.println("Connexion n'a pas pu etre fermé");
            }
            try {
                if(connection != null)
                {
                    connection.close();
                    System.out.println("Connexion fermé avec succes ");
                }
            } catch (SQLException e) {
                // throw new RuntimeException(e);
                System.out.println("Connexion n'a pas pu etre fermé");
            }


        }
    }
}


package br.inatel.DAO;

import java.sql.*;

public class ConnectionDAO {

    Connection con;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;

    String database = "integracao";
    String user = "root";
    String password = "UARrxLG}";
    String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

    public void connectToDb(){
        try{
            con = DriverManager.getConnection(url,user,password);
            System.out.println("Conectado com sucesso");
        }

        catch(SQLException exc){
            System.out.println("Erro: " + exc.getMessage());
        }
    }
}

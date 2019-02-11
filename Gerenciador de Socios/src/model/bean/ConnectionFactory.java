package model.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection(){
        String schema = "socio"; // colocar aqui o schema do BD
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+schema,"root","");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}



// ///    mysql connector java
//        mysql-connector-java-5.1.43.jar ~3Mb

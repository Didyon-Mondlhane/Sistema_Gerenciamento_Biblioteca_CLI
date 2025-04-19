package Configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configuration {
    
    private static final String url = "jdbc:postgresql://localhost:5432/biblioteca";
    private static final String user = "postgres";
    private static final String password = "root";

    private static Connection conn;

    public static Connection getConfiguration(){

        try {
            if(conn == null || conn.isClosed()){
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }else{
                return conn;
            }
            } catch (SQLException e) {
                e.printStackTrace();  
                return null;
            }
        }

}

package database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class conexion {
    private Connection con = null;

    public Connection getConexion() {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("demo/src/main/java/database/app.properties");
            properties.load(fileInputStream);
            con = (Connection)DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password")); 
            System.out.println("Conexión exitosa");
        } catch (Exception e) {
            System.out.println("Error de conexión");
            e.printStackTrace();
        }
        return con;
    }

    public void conectar() {
    }
    
}

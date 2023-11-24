package demo.src.main.database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.swing.JOptionPane;

public class conection {
    private Connection con = null;

    public Connection getConexion() {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/main/java/database/app.properties");
            properties.load(fileInputStream);
            con = (Connection)DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password")); 
            JOptionPane.showMessageDialog(null, "conectado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
            e.printStackTrace();
        }
        return con;
    }
    
}

package demo.src.main.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import database.Conexion;

import java.sql.Statement;
import java.util.ArrayList;


public class consultasProducto {
    private Conexion conexion;

    public ConsultasProducto() {
        conexion = new Conexion();
    }
    
    public boolean eliminar(int id) {
        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement("DELETE FROM Productos WHERE ID = ?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean registrar (producto producto){
    
        try (Connection con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Productos (nombre, desc, precio) VALUES (?,?,?)")) {
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDesc());
}

    
}
    


}

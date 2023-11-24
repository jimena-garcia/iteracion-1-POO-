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
            ps.setDouble(3, producto.getPrecio());
            return ps.executeUpdate() > 0;
        }   
    }
    
    public boolean modificar (producto producto){

        try (Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE Productos SET nombre = ?, desc = ?, precio = ? WHERE ID = ?")) {
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDesc());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }


        public boolean buscar (producto producto){
            try (Connection con = conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM Productos WHERE ID = ?")) {
                ps.setInt(1, producto.getId());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    producto.setId(rs.getInt("id"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setDesc(rs.getString("desc"));
                    producto.setPrecio(rs.getDouble("precio"));
                    return true;
        }           
}
        }

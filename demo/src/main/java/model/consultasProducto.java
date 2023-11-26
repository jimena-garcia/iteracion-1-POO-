package model;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.conexion;
import java.sql.SQLException;

public class consultasProducto {
    private conexion conexion;

    public consultasProducto() {
        conexion = new conexion();
    }
    
    public List<producto> obtenerTodosLosProductos() {
        List<producto> listaProductos = new ArrayList<>();
    
        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Productos");
             ResultSet rs = ps.executeQuery()) {
    
            while (rs.next()) {
                producto prod = new producto();
                prod.setId(rs.getInt("id"));
                prod.setNombre(rs.getString("nombre"));
                prod.setDesc(rs.getString("desc"));
                prod.setPrecio(rs.getDouble("precio"));
    
                listaProductos.add(prod);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    
        return listaProductos;
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

    public boolean registrar(producto producto) {
        try (Connection con = conexion.getConexion();
                PreparedStatement ps = con
                        .prepareStatement("INSERT INTO Productos (nombre, desc, precio) VALUES (?,?,?)")) {
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDesc());
            ps.setDouble(3, producto.getPrecio());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean modificar(producto producto) {

        try (Connection con = conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("UPDATE Productos SET NOMBRE = ?, DESC = ?, PRECIO = ? WHERE ID = ?")) {
            ps.setInt(4, producto.getId());
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDesc());
            ps.setDouble(3, producto.getPrecio());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean buscar(producto producto) {
        try (Connection con = conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM Productos WHERE ID = ?")) {
            ps.setInt(1, producto.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDesc(rs.getString("desc"));
                try {
                    producto.setPrecio(rs.getDouble("precio"));
                } catch (SQLException e) {
                    System.out.println(e);
                }
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    
}

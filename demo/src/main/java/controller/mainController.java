package controller;

import model.producto;
import model.consultasProducto;
import view.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;

public class mainController implements ActionListener {

    private final producto producto;
    private final consultasProducto consultasProducto;
    private final view view;

    public mainController(producto producto, view view, consultasProducto consultasProducto) {
        this.producto = producto;
        this.view = view;
        this.consultasProducto = consultasProducto;
        this.view.jButtonEliminar.addActionListener(this);
        this.view.jButtonModificar.addActionListener(this);
        this.view.jButtonRegistrar.addActionListener(this);
        this.view.jButtonBuscar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.jButtonEliminar) {
            eliminar();
        }
        if (e.getSource() == view.jButtonModificar) {
            modificar();
        }
        if (e.getSource() == view.jButtonRegistrar) {
            registrar(producto);
        }
        if (e.getSource() == view.jButtonBuscar) {
            buscar();
        }
    }

    public void eliminar() {
        try {
            int id = Integer.parseInt(view.jTextID.getText());
            if (consultasProducto.eliminar(id)) {
                JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar producto");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID no válido");
        }
    }

    public void registrar(producto producto) {
        try {
            obtenerProductoVista();
            if (consultasProducto.registrar(producto)) {
                JOptionPane.showMessageDialog(null, "Producto registrado correctamente");
                view.actualizarTabla(consultasProducto.obtenerTodosLosProductos());
                JOptionPane.showMessageDialog(null, "Error al registrar producto");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Precio no válido");
        }
    }
    
    public void modificar() {
        try {
            obtenerProductoVista();
            if (consultasProducto.modificar(producto)) {
                JOptionPane.showMessageDialog(null, "Producto modificado correctamente");
                limpiarVista();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar producto");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Precio no válido");
        }
    }

    public void buscar() {
        try {
            producto.setId(Integer.parseInt(view.jTextID.getText()));
            if (consultasProducto.buscar(producto)) {
                ocuparProductoVista();
            } else {
                JOptionPane.showMessageDialog(null, "Error al buscar producto");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID no válido");
        }
    }

    private void obtenerProductoVista() {
        producto.setNombre(view.jTextNombre.getText());
        producto.setDesc(view.jTextDescripcion.getText());
        producto.setPrecio(Double.parseDouble(view.jTextPrecio.getText()));
    }

    private void ocuparProductoVista() {
        view.jTextNombre.setText(String.valueOf(producto.getId()));
        view.jTextNombre.setText(producto.getNombre());
        view.jTextDescripcion.setText(producto.getDesc());
        view.jTextPrecio.setText(String.valueOf(producto.getPrecio()));

    }

    private void limpiarVista() {
        view.jTextID.setText("");
        view.jTextNombre.setText("");
        view.jTextDescripcion.setText("");
        view.jTextPrecio.setText("");
    }
}

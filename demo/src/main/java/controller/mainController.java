package controller;

import model.producto;
import model.consultasProducto;
import view.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class mainController implements ActionListener{

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
        } else if (e.getSource() == view.jButtonModificar) {
            modificar();
        } else if (e.getSource() == view.jButtonRegistrar) {
            registrar(producto);
        } else if (e.getSource() == view.jButtonBuscar) {
            buscar();
        }
    }

    public void eliminar() {
        int id = Integer.parseInt(view.jTextID.getText());
        if (consultasProducto.eliminar(id)) {
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar producto");
        }
    }

    public void registrar(producto producto) {
        obtenerProductoVista();
        if (consultasProducto.registrar(producto)) {
            JOptionPane.showMessageDialog(null, "Producto registrado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar producto");
        }
    }

    public void modificar() {
        obtenerProductoVista();
        if (consultasProducto.modificar(producto)) {
            JOptionPane.showMessageDialog(null, "Producto modificado correctamente");
            limpiarVista();
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar producto");
        }
    }

    public void buscar() {
        producto.setId(Integer.parseInt(view.jTextID.getText()));
        if (consultasProducto.buscar(producto)) {
            ocuparProductoVista(); 
        } else {
            JOptionPane.showMessageDialog(null, "Error al buscar producto");
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

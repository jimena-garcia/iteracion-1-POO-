package com.example;

import controller.mainController;
import model.consultasProducto;
import model.producto;
import view.view; 


public class BD_H2 {
    public static void main(String[] args) {
      
      producto producto = new producto();
      view view = new view();
      consultasProducto consultasProducto = new consultasProducto();
      mainController mainController = new mainController(producto, view, consultasProducto);

    
      mainController.modificar();
      mainController.eliminar();
      mainController.buscar();
      mainController.registrar(producto);

      view.setVisible(true);

    }
}

package demo.src.main.java.com.example;

public class BD_H2 {
    public static void main(String[] args) {
        Medicamento medicamento = new Producto();
        ConsultasProducto consultasProducto = new ConsultasProducto();
        ProductView view = new ProductView();
        ControladorProducto controladorProducto = new ControladorProducto(medicamento, consultasProducto, view);
    }
}
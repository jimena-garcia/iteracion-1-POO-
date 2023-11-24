package demo.src.main.model;

public class producto {
    private int id;
    public String nombre;
    public String desc;
    public int precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    public String getNombre() {
         return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrecio(){
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
}

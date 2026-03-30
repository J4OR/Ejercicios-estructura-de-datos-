public class Dispositivo {
    
    private int id;
    private String marca;
    private double precio;
    

    public Dispositivo(int id, String nombre, double precio, int stock){
        this.id = id;
        this.marca = nombre;
        this.precio = precio;
    }
    public int getId() {
        return id;
    }
    public String getMarca(){
        return marca;
    }
    public double getPrecio(){
        return precio;
    }
}
      
    

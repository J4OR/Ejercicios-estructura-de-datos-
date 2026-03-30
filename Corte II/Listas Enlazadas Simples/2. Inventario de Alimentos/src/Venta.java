public class Venta {
    Producto cabeza;

    public Venta() {
        this.cabeza = null;
    }

    public void agregarProducto(Producto nuevoProducto){
        if (cabeza == null){
            cabeza = nuevoProducto;
        }else{
            if(nuevoProducto.diasParaVencer < 3){
                nuevoProducto.siguiente = cabeza;
                cabeza = nuevoProducto;
            }else
            {
                Producto actual = cabeza;
                while (actual.siguiente != null){
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevoProducto;
            }
        }
    }

    public void imprimirProductosPorVencer(){
        Producto actual = cabeza;
        while(actual != null){
            if (actual.diasParaVencer < 5) {
                System.out.println("Producto: " + actual.nombre + ", Cantidad: " + actual.cantidad + ", Días para vencer: " + actual.diasParaVencer);
            }
            actual = actual.siguiente;
        }
    }
}

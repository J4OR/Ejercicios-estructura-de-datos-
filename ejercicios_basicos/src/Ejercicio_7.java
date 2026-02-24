// Ejercicio 7 — Inventario compartido
// Un almacén tiene un arreglo con el stock de 5 productos. El sistema de ventas y el sistema de reportes apuntan al mismo arreglo.

// Crea el arreglo stockAlmacen con valores iniciales.
// Asigna stockReportes = stockAlmacen.
// Simula una venta reduciendo el stock de un producto desde stockReportes.
// Muestra que stockAlmacen también cambió y explica en comentarios por qué.

public class Ejercicio_7 {
    public static void main(String[] args) {
        int[] stockAlmacen = {10, 20, 30, 40, 50}; 
        int[] stockReportes = stockAlmacen; 
        
        System.out.println("Stock inicial en el almacén:");
        for (int i=0; i < stockAlmacen.length; i++){
            System.out.println("Producto " + (i+1) + ": " + stockAlmacen[i]);}
            stockReportes[1] -= 8; 
            
            System.out.println("Después de la venta:");
            System.out.println("Stock en el almacén:");
            for (int i=0; i < stockAlmacen.length; i++){
                System.out.println("Producto " + (i+1) + ": " + stockAlmacen[i]);}   
        }    
    }
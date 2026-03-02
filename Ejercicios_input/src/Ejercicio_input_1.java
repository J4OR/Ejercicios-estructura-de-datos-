// Ejercicio 1 — Recibo de compra
// Pide al usuario el nombre de un producto, la cantidad comprada y el precio unitario.
// Calcula el subtotal, aplica un IVA del 19% y muestra el recibo con el total a pagar.

// Datos de entrada:

// String nombre del producto
// int cantidad
// double precio unitario

public class Ejercicio_input_1 {
    public static void main(String[] args) throws Exception {
        String nombreProducto = "Arroz";
        int cantidad = 3;
        double precioUnitario = 2500;

        double subtotal = precioUnitario*cantidad;
        double iva= subtotal * 0.19;
        double totalPagar = subtotal + iva;

        System.out.println("=== Recibo de Compra ===");
        System.out.println("Producto  : " + nombreProducto);
        System.out.println("Cantidad  : " + cantidad);
        System.out.println("Precio c/u: $" + precioUnitario);
        System.out.println("Subtotal  : $" + subtotal);
        System.out.println("IVA (19%) : $" + iva);
        System.out.println("Total     : $" + totalPagar);

    }
}

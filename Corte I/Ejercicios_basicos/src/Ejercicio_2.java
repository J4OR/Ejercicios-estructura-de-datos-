// Ejercicio 2 — Calculadora de una tienda
// Una tienda de barrio vende productos al por menor. El cajero necesita calcular:

// Precio unitario de un producto (double)
// Cantidad comprada (int)
// Descuento aplicado en porcentaje (double)
// Total a pagar después del descuento
// Declara las variables, realiza el cálculo y muestra el resultado por consola.

import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        double precio;
        int cantidad;
        double descuentoAplicado;

        System.out.println("Ingrese el precio del producto: ");
        precio = sc.nextDouble();
        System.out.println("Ingrese la cantidad del producto: ");
        cantidad = sc.nextInt();
        System.out.println("Ingrese el descuento aplicado (en porcentaje): ");
        descuentoAplicado = sc.nextDouble();

        double totalSinDescuento = precio * cantidad;
        double descuento = totalSinDescuento * (descuentoAplicado / 100);
        double totalConDescuento = totalSinDescuento - descuento;

        System.out.println("Total sin descuento: " + totalSinDescuento);
        System.out.println("Descuento aplicado: " + descuento);
        System.out.println("Total con descuento: " + totalConDescuento);
        sc.close();
    }
}

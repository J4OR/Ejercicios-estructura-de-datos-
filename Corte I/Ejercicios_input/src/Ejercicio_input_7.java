// Ejercicio 7 — Arreglo compartido (inventario)
// Pide al usuario 4 precios para llenar un arreglo precios[]. 
// Crea preciosAuditoria = precios (misma referencia). Pide al usuario 
// el índice y el nuevo precio para hacer una corrección desde preciosAuditoria. 
// Muestra ambos arreglos y verifica que el cambio se refleja en los dos.

// Datos de entrada: double × 4 precios, int índice, double nuevo precio

import java.util.Scanner;

public class Ejercicio_input_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] precios = new double[4];
        for (int i = 0; i < precios.length; i++) {
            System.out.println("Ingresa el precio " + (i + 1) + ":");
            precios[i] = sc.nextDouble();
        }
        double[] preciosAuditoria = precios;
        System.out.println("Ingrese el índice a corregir (0-3):");
        int indice = sc.nextInt();
        System.out.println("Ingrese el nuevo precio:");
        double nuevoPrecio = sc.nextDouble();
        preciosAuditoria[indice] = nuevoPrecio;

        System.out.println("========== Arreglo Precios ==========");
        for (int i=0; i < precios.length; i++) {
            System.out.println("Precio [" + i + "]: " + precios[i] + " | Auditoria [" + i + "]: " + preciosAuditoria[i]);
        }

        sc.close();
    }
}

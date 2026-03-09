// 1. El Podio de la Competencia
// Algoritmo obligatorio: Ordenamiento por Selección (Selection Sort)

// Contexto: Se ha realizado una carrera de 100 metros planos y el comité olímpico necesita 
// determinar quiénes ganaron las medallas.
// Detalle del ejercicio: El programa debe solicitar primero cuántos corredores participaron
//  (ej. 5 a 10). Luego, debe pedir el tiempo en segundos (con decimales) de cada corredor.
// Lógica de Selección: El algoritmo debe buscar el tiempo más bajo (el más rápido) en cada 
// iteración y colocarlo al inicio.
// Resultado esperado: El programa debe imprimir el arreglo totalmente ordenado y,
//  adicionalmente, mostrar un mensaje claro indicando quién obtuvo el Oro (1er lugar), 
//  Plata (2do lugar) y Bronce (3er lugar).


import java.util.Scanner;

public class Ejercicio_ordenamiento_1 {
    public static void main(String[] args) {      
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de participantes: ");
        int n= sc.nextInt();

        while (n < 5 || n > 10) {
            System.out.println("Cantidad de participantes no válida. Ingrese un número entre 5 y 10.");
            n = sc.nextInt();
        }
        
        double[] tiempos = new double[n];
        for (int i = 0; i< n; i++){
            System.out.println("Ingrese el tiempo del corredor " + (i+1) + ": ");
            tiempos[i] = sc.nextDouble();
        }
        // Ordenamiento por selección
        for (int i = 0; i < n - 1; i++) {
            int im=i;
            for (int j = i+1; j < n; j++) {
                if (tiempos[j]< tiempos[im]) {
                    im = j;
                }
            }
            double temp = tiempos[i];
            tiempos[i] = tiempos[im];
            tiempos[im] = temp;
        }

        // Imprimir el arreglo ordenado
        for (int i = 0; i < tiempos.length; i++) {
            System.out.println("Tiempo del corredor " + (i+1) + ": " + tiempos[i]);
        }
        System.out.println("");
        System.out.println("Tabla de posiciones:");
        System.out.println("Oro: Corredor " + (0+1) + " con tiempo " + tiempos[0]);
        System.out.println("Plata: Corredor " + (1+1) + " con tiempo " + tiempos[1]);
        System.out.println("Bronce: Corredor " + (2+1) + " con tiempo " + tiempos[2]);
        sc.close();
    }
}
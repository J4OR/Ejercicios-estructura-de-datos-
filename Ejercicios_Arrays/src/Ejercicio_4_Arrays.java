// 4. Control de Acceso (Gimnasio)
// Un gimnasio tiene una lista de códigos de acceso de los socios que pagaron la mensualidad. 
// La lista está ordenada de menor a mayor.

// El Problema: Cuando un socio digita su código, el sistema debe validar si el código está en la lista de
// "pagos al día". Si no está, se le niega la entrada.
// Algoritmo a usar: Búsqueda Binaria. Es eficiente para buscar códigos numéricos 
// en una lista que ya está organizada.

import java.util.Scanner;

public class Ejercicio_4_Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] pagosAlDia = {1011, 1012, 1013, 1014, 1015, 1016, 1017};

        
        int low = 0;
        int high = pagosAlDia.length -1;
        boolean encontrado= true;
        
        System.out.print("Ingrese su código de acceso: ");
        int codigoIngresado = sc.nextInt();

        while (low<=high) {
            int mid = (low + high) / 2 ;
            if (pagosAlDia[mid] == codigoIngresado ) {
                System.out.println("El codigo " + codigoIngresado + "esta en la posicion " + mid);
                encontrado=true;
                break;
            }
            if (codigoIngresado< pagosAlDia[mid]) {
                high = mid - 1;
            } else{
                low = mid + 1;
            }  
        }
        if (!encontrado) {
            System.out.println("El codigo " + codigoIngresado + " no esta en la lista" );            
        }
        sc.close();
    }        
}

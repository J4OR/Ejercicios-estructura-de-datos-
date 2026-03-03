// 2. Buscador de Cédulas (Base de Datos Bancaria)
// Un banco tiene una lista de 1.000 clientes organizados de forma estricta y ascendente
//  por su número de cédula o ID.

// El Problema: Un cliente llega a la ventanilla y da su número. El sistema debe encontrar 
// sus datos de la manera más rápida posible (en pocos pasos).
// Algoritmo a usar: Búsqueda Binaria. Como los datos ya están ordenados, 
// este algoritmo permitirá encontrar al cliente dividiendo la lista a la mitad en cada paso.

public class Ejercicio_2_Arrays {
    public static void main(String[] args) {
        int[] cedulas = {1003, 1005, 1006, 1008, 1010, 1034, 1207, 1234, 1709, 5678}; 
        int cedulaBuscada = 1003;

        int low= 0;
        int high = cedulas.length - 1;
        boolean encontrar = false;

        while (low<=high) {
            int mid = (low + high) / 2;
            if(cedulas[mid]==cedulaBuscada){
                System.out.println("Cliente encontrado en la posición: " + mid);
                encontrar = true;
                break;
            } 
            if (cedulaBuscada < cedulas[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (!encontrar) {
            System.out.println("Cliente no encontrado.");
        }
    }
}

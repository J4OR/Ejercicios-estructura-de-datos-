import java.util.Scanner;

public class Parcial_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese cuantos montos desea ingresar: ");
        int n=sc.nextInt();
        sc.nextLine();

        double[] montos = new double[n];

        System.out.println("--- INGRESO DE VENTAS ---");
        for (int i = 0; i < n; i++) {
            System.out.print("Venta " + (i+1)+ ": " );
            double monto = sc.nextInt();
            montos[i] = monto;
        }
        selectionSort(montos);
        
        System.out.println("--- VENTAS ORDENADAS ---");
        System.out.print("[");
        for (int i = 0; i < montos.length; i++) {
            System.out.print(montos[i] );
            if (i <montos.length-1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");

        double total = 0;
        for (int i = 0; i < montos.length; i++) {
            total+=montos[i];
        }
         System.out.println("\nTotal de ventas: " + total);

        System.out.println("--- BÚSQUEDA LINEAL ---");
        System.out.println("Ingrese el monto de la venta a buscar: ");
        int buscar = sc.nextInt();

        int posicion = busquedaLineal(montos, buscar);

        if (posicion != -1) {
            System.out.println(">> El monto  " + buscar + " se encuentra en la posicion:  " + (posicion) );
            
        }
        else{
            System.out.println("Venta no encontrado");
        }

        sc.close();

    }

    // selection sort de menor a mayor
    public static void selectionSort(double[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int indiceMenor = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            // Intercambio
            double temp = arr[indiceMenor];
            arr[indiceMenor] = arr[i];
            arr[i] = temp;
        }
    }

    // busqueda lineal 
    public static int busquedaLineal(double[] arr, int objetivo) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == objetivo) {
                return i;
            }
        }

        return -1;
    }

}

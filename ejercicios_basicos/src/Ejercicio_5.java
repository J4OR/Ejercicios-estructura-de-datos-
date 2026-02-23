import java.util.Scanner;

public class Ejercicio_5 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        double tazas;
        double litro;
        double mililitro;

        System.out.println("Ingrese la cantidad de tazas:");
        tazas = sc.nextDouble();
        mililitro = tazas * 236.588;
        litro = mililitro / 1000;

        System.out.println(tazas + " tazas equivalen a " + mililitro + " mililitros.");
        System.out.println(tazas + " tazas equivalen a " + litro + " litros.");

        sc.close();
    }
}

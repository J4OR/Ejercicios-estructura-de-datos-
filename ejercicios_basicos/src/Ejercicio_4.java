import java.util.Scanner;

public class Ejercicio_4 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        String placa;
        int añoFabricacion;
        int cilindraje;
        double precioCompra;
        char inicialColor;
        boolean soat;

        System.out.println("Ingrese la placa del vehículo:");
        placa = sc.nextLine();
        System.out.println("Ingrese el año de fabricación del vehículo:");
        añoFabricacion = sc.nextInt();
        System.out.println("Ingrese el cilindraje del vehículo:");
        cilindraje = sc.nextInt();
        System.out.println("Ingrese el precio de compra del vehículo:");
        precioCompra = sc.nextDouble();
        System.out.println("Ingrese la inicial del color del vehículo:");
        inicialColor = sc.next().charAt(0);
        System.out.println("¿El vehículo tiene SOAT? (true/false):");
        soat = sc.nextBoolean();

        System.out.println("Información del vehículo:");
        System.out.println("Placa: " + placa);
        System.out.println("Año de fabricación: " + añoFabricacion);
        System.out.println("Cilindraje: " + cilindraje);
        System.out.println("Precio de compra: " + precioCompra);
        System.out.println("Inicial del color: " + inicialColor);
        System.out.println("¿Tiene SOAT? " + (soat ? "Sí" : "No"));

        sc.close();
        
    } 
}

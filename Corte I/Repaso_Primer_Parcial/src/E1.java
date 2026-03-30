import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos producto desea agregar: ");
        int n= sc.nextInt();
        Producto[] productos = new Producto[n];

        for (int i = 0; i < n; i++){
            System.out.println("PRODUCTO" + (i+1) );
            System.out.println("Ingrese el id del producto:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese el nombre del producto: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese el precio del producto: ");
            double precio = sc.nextDouble();
            System.out.println("Ingrese el stock del producto:");
            int stock = sc.nextInt();
            productos[i] = new Producto(id, nombre, precio, stock);
        }
        shellSort(productos);
        
        System.out.println( "INVENTARIO ORDENADO ");

        for (int i = 0; i < productos.length; i++) {
            System.out.println("ID: " + productos[i].getId() + "|Nombre: " + productos[i].getNombre() + 
                " |Precio: $" + productos[i].getPrecio() + " |Stock: " + productos[i].getStock());
        }
        System.out.println("\nBUSQUEDA DE PRODUCTO POR ID");
        System.out.println("Ingrese el id del producto a buscar: ");
        int idBuscado= sc.nextInt();

        busquedaBinaria(productos, idBuscado);
        sc.close();
    }
    
    public static void shellSort(Producto[] p) {

        int n = p.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Producto temp = p[i];
                int j;
                for (j = i; j >= gap && p[j - gap].getId() > temp.getId(); j -= gap) {
                    p[j] = p[j - gap];
                }
                p[j] = temp;
            }
        }
    }

    public static void busquedaBinaria (Producto[] p, int idBuscado){
        int low= 0;
        int high = p.length - 1;
        boolean encontrar = false;

        while (low<=high) {
            int mid = (low + high) / 2;
            if(p[mid].getId()==idBuscado){
                System.out.println("Producto Encontrado");
                System.out.println(p[mid].getNombre() + " - Precio: $" + p[mid].getPrecio() + " - Stock: " + p[mid].getStock());
                encontrar = true;
                break;
            } 
            if (idBuscado < p[mid].getId()) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (!encontrar) {
            System.out.println("Producto no encontrado.");
        }
    }
}
